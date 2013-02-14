package com.flosoftware.emileage.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/12/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class notesSqlLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_NOTES = "notes";
    public static final String COLUMN_NOTEID = "id";
    public static final String COLUMN_TRIPID = "tripid";
    public static final String COLUMN_NOTES = "notes";
    public static final String COLUMN_USERID = "userid";

    private static final String DATABASE_NAME = "emileage.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_NOTES + "( "
            + COLUMN_NOTEID + " integer primary key autoincrement, "
            + COLUMN_NOTES + " text, "
            + COLUMN_USERID + " integer, "
            + COLUMN_TRIPID + " integer, "
            + "FOREIGN KEY(" + COLUMN_TRIPID + ") REFERENCES " + tripSqlLiteHelper.TABLE_TRIP + "(" + tripSqlLiteHelper.COLUMN_TRIPID + "), "
            + "FOREIGN KEY(" + COLUMN_USERID + ") REFERENCES " + userSqlLiteHelper.TABLE_USER + "(" + userSqlLiteHelper.COLUMN_USERID + ");";

    public notesSqlLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(notesSqlLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }
}
