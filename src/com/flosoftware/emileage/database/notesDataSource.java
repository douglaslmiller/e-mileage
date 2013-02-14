package com.flosoftware.emileage.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.flosoftware.emileage.database.notesSqlLiteHelper;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/12/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class notesDataSource {
    private SQLiteDatabase database;
    private notesSqlLiteHelper dbHelper;
    private String[] allColumns = {
            notesSqlLiteHelper.COLUMN_NOTEID,
            notesSqlLiteHelper.COLUMN_NOTES,
            notesSqlLiteHelper.COLUMN_TRIPID,
            notesSqlLiteHelper.COLUMN_USERID };

    public notesDataSource(Context context) {
        dbHelper = new notesSqlLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

}
