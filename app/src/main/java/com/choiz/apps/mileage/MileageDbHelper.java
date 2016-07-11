package com.choiz.apps.mileage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Eclchoiz on 2016-07-11.
 */


public class MileageDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Mileage.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + MileageEntry.TABLE_NAME + " (" +
                    MileageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    MileageEntry.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP +
                    MileageEntry.COLUMN_NAME_MONEY + TEXT_TYPE + COMMA_SEP +
                    MileageEntry.COLUMN_NAME_PRICE + TEXT_TYPE + COMMA_SEP +
                    MileageEntry.COLUMN_NAME_GAS + TEXT_TYPE + COMMA_SEP +
                    MileageEntry.COLUMN_NAME_DISTANCE + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + MileageEntry.TABLE_NAME;


    public MileageDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static abstract class MileageEntry implements BaseColumns {
        public static final String TABLE_NAME = "mileage";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_MONEY = "money";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_GAS = "gas";
        public static final String COLUMN_NAME_DISTANCE = "distance";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
