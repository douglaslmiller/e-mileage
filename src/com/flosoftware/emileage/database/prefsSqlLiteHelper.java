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
public class prefsSqlLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_PREFS = "prefs";
    public static final String COLUMN_PREFSID = "id";
    public static final String COLUMN_USERID = "userid";
    public static final String COLUMN_PREFVAL = "val";
    public static final String COLUMN_PREFNAME = "name";

    private static final String DATABASE_NAME = "emileage.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_PREFS + "( "
            + COLUMN_PREFSID + " integer primary key autoincrement, "
            + COLUMN_PREFVAL + " text, "
            + COLUMN_PREFNAME + " text, "
            + COLUMN_USERID + " integer, "
            + "FOREIGN KEY(" + COLUMN_USERID + ") REFERENCES " + userSqlLiteHelper.TABLE_USER + "(" + userSqlLiteHelper.COLUMN_USERID + ");";

    public prefsSqlLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(prefsSqlLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PREFS);
        onCreate(db);
    }
}
