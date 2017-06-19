package com.example.user.fitness;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.user.fitness.weightcontract.weightEntry;

import java.util.ArrayList;

public class weightmanaged extends AppCompatActivity {

   weightdbhelper mweightdbhelper;
    SQLiteDatabase db;

    Button btn_save, btn_update, btn_delete;
    TextInputEditText et_date, et_day, et_bmi;
    ListView lv_weight;

    String day, date, bmi, std;

    // define which columns want to return
    private String[] allColumns = {weightEntry._ID,weightEntry.COLUMN_DAY,
            weightEntry.COLUMN_DATE, weightEntry.COLUMN_BMI};
    // store the data in the arraylist for displaying in listview
    ArrayList<String> weightInfor;

    // Which row to update
    String updateWhereClause ;

    // Specify arguments/values in where clause
    String[] updateWhereArgs ;

    // Define 'where' part of query.
    String deleteWhereClause = weightEntry.COLUMN_DAY + " LIKE ?";

    // Specify arguments/values in where clause
    String[] deleteWhereArgs;

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightmanaged);

        // To access your database, instantiate your subclass of
        // SQLiteOpenHelper:
        mweightdbhelper = new weightdbhelper(this);
        // Gets the data repository in write mode
        db = mweightdbhelper.getWritableDatabase();

        btn_save = (Button) findViewById(R.id.main_btn_save);
        btn_update = (Button) findViewById(R.id.main_btn_update);
        btn_delete = (Button) findViewById(R.id.main_btn_delete);

        et_date = (TextInputEditText) findViewById(R.id.main_et_date);
        et_day = (TextInputEditText) findViewById(R.id.main_et_day);
        et_bmi = (TextInputEditText) findViewById(R.id.main_et_bmi);

        lv_weight = (ListView) findViewById(R.id.main_lv_weight);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get values from edit text in xml layout
                day = et_day.getText().toString();
                date = et_date.getText().toString();
                bmi = et_bmi.getText().toString();

                //create a new map of value where column name are the key
                ContentValues values = new ContentValues();
                values.put(weightEntry.COLUMN_DAY, day);
                values.put(weightEntry.COLUMN_DATE, date);
                values.put(weightEntry.COLUMN_BMI, bmi+"kg");

                // Create data insert function
                insertData(db, values);

            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                std = et_bmi.getText().toString();

                // New value for one column
                ContentValues values = new ContentValues();
                values.put(weightEntry.COLUMN_BMI, std);

                // Which row to update, based on the name
                String updateWhereClause = weightEntry.COLUMN_DAY +
                        " LIKE ?";
                // Specify arguments/values in where clause
                String[] updateWhereArgs = new String[]{et_day.getText().toString()};

                int affectedRow = db.update(
                        //the table to update in
                       weightEntry.TABLE_NAME,
                        // a map from column names to new column values. null is a valid value that will be translated to NULL.
                        values,
                        //the optional WHERE clause to apply when updating. Passing null will update all rows.
                        updateWhereClause,
                        //You may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings.
                        updateWhereArgs);

                if (affectedRow > 0) {
                    Message.message(getApplicationContext(), affectedRow +
                            " record updated");
                    loadData();
                }


            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteWhereArgs = new String[]{et_day.getText().toString()};

                int affectedRow = db.delete(weightEntry.TABLE_NAME, //the table to delete from
                        deleteWhereClause,//the optional WHERE clause to apply when deleting. Passing null will delete all rows.
                        deleteWhereArgs); // You may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings.

                if (affectedRow > 0) {
                    Message.message(getApplicationContext(),
                            affectedRow + " record deleted");
                    loadData();
                }

            }
        });



    }

    public void insertData(SQLiteDatabase db, ContentValues values) {
        long newRowId;
        newRowId = db.insert(weightEntry.TABLE_NAME, null, values);

        // If data is inserted then toast a message
        if (newRowId != -1) {
            Message.message(weightmanaged.this, "New Data Inserted");
            // Create a function for reading the data in next step
            loadData();
        }

    }

    public void loadData() {
       weightInfor = new ArrayList<String>();

        Cursor cursor = db.query(weightEntry.TABLE_NAME,// Table
                allColumns, // The columns to return
                null, // The columns for the WHERE clause
                null, // The values for the WHERE clause
                null, // don't group the rows
                null, // don't filter by row groups
                null, // The sort order
                null); // Limits the number of rows returned by the query

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
           weightInfor.add(cursor.getString(0) + ")DAY: "
                    + cursor.getString(1) + " DATE: "
                    + cursor.getString(2) + " WEIGHT: "
                    + cursor.getString(3) + " Count:"
                    + cursor.getCount());
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                weightInfor);

        lv_weight.setAdapter(adapter);
        cursor.close();

    }

}