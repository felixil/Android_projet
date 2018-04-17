package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ImbFe1233046 on 2018-04-16.
 */

public class FriendDataScource {



    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID_FRIEND,
            MySQLiteHelper.COLUMN_ID_USER};

    public FriendDataScource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public User createFriend(String userId, String friendId) {


        ContentValues values = new ContentValues();
        values.put(dbHelper.COLUMN_ID_FRIEND, friendId);
        values.put(dbHelper.COLUMN_ID_USER, userId);
        database.insert(dbHelper.TABLE_USER, null, values);
        Cursor cursor = database.query(dbHelper.TABLE_USER,
                allColumns, dbHelper.COLUMN_ID_USER + " = " + friendId, null,
                null, null, null);
        cursor.moveToFirst();
        User user = cursorToFriend(cursor);
        cursor.close();
        return user;
    }

    public void deleteFriend(User user,String friendId) {


        System.out.println("Friend deleted with id: " +  user.getId());
        database.delete(dbHelper.TABLE_FRIEND, dbHelper.COLUMN_ID_FRIEND
                + " = " + friendId +" AND " +dbHelper.COLUMN_ID_USER +"="+ user.getId(), null);
    }


    public User getFriendByID(String ID) {
        String where = dbHelper.COLUMN_ID_USER +" = "+ ID ;
        Cursor cursor = database.query(dbHelper.TABLE_USER,
                allColumns, where, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = cursorToFriend(cursor);
            if (user.getId() == ID ) {
                return user;
            }
            cursor.moveToNext();
        }
        cursor.close();
        return null;
    }
    public List getFriendByUser(User user) {

        String where = user.getId()+" = "+dbHelper.COLUMN_ID_USER;
        Cursor cursor = database.query(dbHelper.TABLE_FRIEND,allColumns,where ,null,null,null,null);
        List list = new LinkedList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            list.add(getFriendByID(cursor.getString(0)));




            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    private User cursorToFriend(Cursor cursor) {
            User user = new User();
            user.setId(cursor.getString(0));
            user.setName(cursor.getString(1));
            user.setPassword("secret");
            user.setLvl(cursor.getInt(3));
            return user;
        }
}