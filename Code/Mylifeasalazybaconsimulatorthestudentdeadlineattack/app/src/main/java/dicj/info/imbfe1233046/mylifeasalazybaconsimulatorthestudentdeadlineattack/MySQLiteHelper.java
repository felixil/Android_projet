package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ImbFe1233046 on 2018-04-11.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_USER = "user";
    public static final String TABLE_SCORE = "score";
    public static final String TABLE_FRIEND = "friend";
    public static final String COLUMN_ID_USER = "id_user";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LVL = "lvl";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_ID_FRIEND = "id_friend";
    public static final String COLUMN_ID_SCORE = "id_score";
    public static final String COLUMN_SCORE = "score";

    private static final String DATABASE_NAME = "myaslazy.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE_USER = "create table "
            + TABLE_USER + "(" + COLUMN_ID_USER
            + " text primary key, " + COLUMN_NAME
            +" text not null,"+COLUMN_PASSWORD+" text not null,"+COLUMN_LVL+"integer not null);";

    private static final String DATABASE_CREATE_SCORE = "create table "
            + TABLE_SCORE + "(" + COLUMN_ID_SCORE
            + " integer primary key autoincrement, " + COLUMN_ID_USER
            + " integer not null,"+COLUMN_LVL+" integer not null,"+COLUMN_TIME+"real not null,"+COLUMN_SCORE+" integer not null);";

    private static final String DATABASE_CREATE_FRIEND = "create table "
            + TABLE_FRIEND + "(" + COLUMN_ID_FRIEND
            + " integer primary key("+COLUMN_ID_USER+","+COLUMN_ID_FRIEND+") autoincrement, " + COLUMN_ID_FRIEND
            + " integer not null,"+COLUMN_ID_USER+");";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_USER);
        database.execSQL(DATABASE_CREATE_SCORE);
        database.execSQL(DATABASE_CREATE_FRIEND);
        Log.i("DATABASE","onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIEND);
        onCreate(db);
        Log.i("DATABASE","onUpgrade");
    }
}