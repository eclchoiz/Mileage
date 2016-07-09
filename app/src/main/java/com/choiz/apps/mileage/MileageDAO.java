package com.choiz.apps.mileage;

/**
 * Created by SSENG on 2016-07-09.
 */
public class MileageDAO {
}

/*

public class dbOpenHelper extends SQLiteOpenHelper
{
    public static final String TABLE_NAME = "mileage";

    public dbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void createTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + TABLE_NAME + "(name text)";
        try
        {
            db.execSQL(sql);
        }
        catch (SQLException e)
        {
        }
    }

    public void insertRecord(SQLiteDatabase db, MileageDTO dto)
    {
        db.beginTransaction();
        try
        {
            String sql = "insert into " + TABLE_NAME + "(name)" + " values('" + name + "')";
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            db.endTransaction();
        }
    }
}
*/
