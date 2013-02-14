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
public class userSqlLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_USER = "user";
    public static final String COLUMN_USERID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_AUTHKEY = "authkey";

    private static final String DATABASE_NAME = "emileage.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_USER + "( "
            + COLUMN_USERID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text, "
            + COLUMN_PASSWORD + " text, "
            + COLUMN_AUTHKEY + " text);";

    public userSqlLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(userSqlLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
