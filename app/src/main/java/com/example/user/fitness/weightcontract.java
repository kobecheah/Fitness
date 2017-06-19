package com.example.user.fitness;

import android.provider.BaseColumns;

import android.provider.BaseColumns;


public class weightcontract {


    public weightcontract() {


    }

    public static final class weightEntry implements BaseColumns {

        public static final String TABLE_NAME = "weight";

        public static final String COLUMN_DAY = "day";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_BMI = "bmi";

    }
}
