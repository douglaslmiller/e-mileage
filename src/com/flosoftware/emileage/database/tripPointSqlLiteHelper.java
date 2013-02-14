package com.flosoftware.emileage.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/13/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class tripPointSqlLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_TRIPPOINT = "trippoint";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LAT = "latitude";
    public static final String COLUMN_LONG = "longitude";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_TRIPID = "tripid";

    private static final String DATABASE_NAME = "emileage.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_TRIPPOINT + "( "
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LAT + " real, "
            + COLUMN_LONG + " real, "
            + COLUMN_TIMESTAMP + " integer, "
            + COLUMN_TRIPID + " integer, "
            + "FOREIGN KEY(" + COLUMN_TRIPID + ") REFERENCES " + tripSqlLiteHelper.TABLE_TRIP + "(" + tripSqlLiteHelper.COLUMN_TRIPID + ");";

    public tripPointSqlLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(tripPointSqlLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIPPOINT);
        onCreate(db);
    }

}
