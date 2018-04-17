package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ImbFe1233046 on 2018-04-11.
 */

public class UserDataSource {

    private SQLiteDatabase database;
    private FriendDataScource friendScource;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID_USER,
            MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_PASSWORD, MySQLiteHelper.COLUMN_LVL};

    public UserDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public User createUser(String id, String password,String name) {

        ContentValues values = new ContentValues();
        values.put(dbHelper.COLUMN_NAME, name);
        values.put(dbHelper.COLUMN_ID_USER, id);
        values.put(dbHelper.COLUMN_PASSWORD, password);
        database.insert(dbHelper.TABLE_USER, null, values);
        Cursor cursor = database.query(dbHelper.TABLE_USER,
                allColumns, dbHelper.COLUMN_ID_USER + " = " + id, null,
                null, null, null);
        cursor.moveToFirst();
        User newUser = cursorToUser(cursor);
        cursor.close();
        return newUser;
    }

    public void deleteUser(User user) {


        System.out.println("User deleted with id: " + user.getId());
        database.delete(dbHelper.TABLE_USER, dbHelper.COLUMN_ID_USER
                + " = " + user.getId(), null);
    }


    public User getUser(String ID, String Password) {

        String whereUser=dbHelper.COLUMN_ID_USER +" = "+ ID +" AND  "+dbHelper.COLUMN_PASSWORD+" = "+ Password;
        Cursor cursor = database.query(MySQLiteHelper.TABLE_USER,
                allColumns, whereUser, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            User user = cursorToUser(cursor);
            if (user.getId() == ID && user.getPassword() == Password) {
                user.setListFriend(friendScource.getFriendByUser(user));
                return user;
            }

        }

        cursor.close();
        return null;
    }

    private User cursorToUser(Cursor cursor) {

        User user = new User();
        user.setId(cursor.getString(0));
        user.setName(cursor.getString(1));
        user.setPassword(cursor.getString(2));
        user.setLvl(cursor.getInt(3));
        return user;
    }

}