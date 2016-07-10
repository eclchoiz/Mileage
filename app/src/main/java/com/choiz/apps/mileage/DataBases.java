package com.choiz.apps.mileage;

import android.provider.BaseColumns;

/**
 * Created by SSENG on 2016-07-10.
 */
public class DataBases {
    public static final class CreateDB implements BaseColumns {
        public static final String DATE = "date";
        public static final String MONEY = "money";
        public static final String PRICE = "price";
        public static final String GAS = "gas";
        public static final String DISTANCE = "distance";
        public static final String _TABLENAME = "mileage";
        public static final String _CREATE =
                "create table " + _TABLENAME + "("
                        + _ID + " integer primary key autoincrement, "
                        + DATE + " text not null , "
                        + MONEY + " text not null , "
                        + PRICE + " text not null , "
                        + GAS + " text not null , "
                        + DISTANCE + " text not null );";
    }
}
