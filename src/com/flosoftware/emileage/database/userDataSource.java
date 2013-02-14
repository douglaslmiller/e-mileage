package com.flosoftware.emileage.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.flosoftware.emileage.domain.User;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/12/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class userDataSource {

    private SQLiteDatabase database;
    private userSqlLiteHelper dbHelper;
    private String[] allColumns = {
            userSqlLiteHelper.COLUMN_USERID,
            userSqlLiteHelper.COLUMN_NAME,
            userSqlLiteHelper.COLUMN_PASSWORD,
            userSqlLiteHelper.COLUMN_AUTHKEY};

    public userDataSource(Context context){
        dbHelper = new userSqlLiteHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public User createUser(User user){
        ContentValues values = new ContentValues();
        values.put(userSqlLiteHelper.COLUMN_NAME, user.get_name());
        values.put(userSqlLiteHelper.COLUMN_PASSWORD, user.get_password());
        long insertId = database.insert(userSqlLiteHelper.TABLE_USER, null, values);
        Cursor cursor = database.query(userSqlLiteHelper.TABLE_USER, allColumns, userSqlLiteHelper.COLUMN_USERID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        User newUser = cursorToUser(cursor);
        cursor.close();
        Log.v(userDataSource.class.getName(), userSqlLiteHelper.TABLE_USER + " created");
        return newUser;
    }

    public void updateUser(User user){
        long updateID = user.get_id();
        ContentValues values = new ContentValues();
        values.put(userSqlLiteHelper.COLUMN_NAME, user.get_name());
        values.put(userSqlLiteHelper.COLUMN_PASSWORD, user.get_password());

        database.update(userSqlLiteHelper.TABLE_USER, values, userSqlLiteHelper.COLUMN_USERID + " = " + updateID, null);
        Log.v(userDataSource.class.getName(), userSqlLiteHelper.TABLE_USER + " updated");
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        Cursor cursor = database.query(userSqlLiteHelper.TABLE_USER, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            User user = cursorToUser(cursor);
            users.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return users;
    }


    private User cursorToUser(Cursor cursor){
        User user = new User();
        user.set_id(cursor.getLong(0));
        user.set_name(cursor.getString(1));
        user.set_password(cursor.getString(2));
        user.set_authkey(cursor.getString(3));
        return user;
    }





}
