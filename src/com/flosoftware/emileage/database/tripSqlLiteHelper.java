package com.flosoftware.emileage.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/12/13
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class tripSqlLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_TRIP = "trip";
    public static final String COLUMN_TRIPID = "id";
    public static final String COLUMN_USERID = "userid";
    public static final String COLUMN_STARTLAT = "startlat";
    public static final String COLUMN_STARTLONG = "startlong";
    public static final String COLUMN_ENDLAT = "endlat";
    public static final String COLUMN_ENDLONG = "endlong";
    public static final String COLUMN_DISTANCE = "distance";
    public static final String COLUMN_STARTNAME = "startname";
    public static final String COLUMN_ENDNAME = "endname";

    private static final String DATABASE_NAME = "emileage.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_TRIP + "( "
            + COLUMN_TRIPID + " integer primary key autoincrement, "
            + COLUMN_STARTLAT + " real, "
            + COLUMN_STARTLONG + " real, "
            + COLUMN_ENDLAT + " real, "
            + COLUMN_ENDLONG + " real, "
            + COLUMN_STARTNAME + " text, "
            + COLUMN_ENDNAME + " text, "
            + COLUMN_DISTANCE + " integer, "
            + COLUMN_USERID + " integer, "
            + "FOREIGN KEY(" + COLUMN_USERID + ") REFERENCES " + userSqlLiteHelper.TABLE_USER + "(" + userSqlLiteHelper.COLUMN_USERID + ");";

    public tripSqlLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(tripSqlLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIP);
        onCreate(db);
    }
}
