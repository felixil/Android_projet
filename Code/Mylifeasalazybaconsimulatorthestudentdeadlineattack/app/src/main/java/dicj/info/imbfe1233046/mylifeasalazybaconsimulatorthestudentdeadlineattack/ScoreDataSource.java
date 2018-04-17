package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

        import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ImbFe1233046 on 2018-04-11.
 */

public class ScoreDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID_SCORE,
            MySQLiteHelper.COLUMN_ID_USER, MySQLiteHelper.COLUMN_LVL, MySQLiteHelper.COLUMN_TIME,MySQLiteHelper.COLUMN_SCORE};

    public ScoreDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void createScore(String user, String time ,int lvl, int score) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_ID_USER, user);
        values.put(MySQLiteHelper.COLUMN_SCORE, score);
        values.put(MySQLiteHelper.COLUMN_LVL, lvl);
        values.put(MySQLiteHelper.COLUMN_TIME, time);
        database.insert(MySQLiteHelper.TABLE_SCORE, null, values);

    }

    public void deleteScore(Score score) {

        Integer id = score.getId();
        System.out.println("Score deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_SCORE, MySQLiteHelper.COLUMN_ID_SCORE
                + " = " + id, null);
    }


    public Score getScoreByID(int ID) {

        Cursor cursor = database.query(MySQLiteHelper.TABLE_SCORE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Score score = cursorToScore(cursor);
            if (score.getId() == ID ) {
                return score;
            }
            cursor.moveToNext();
        }
        cursor.close();
        return null;
    }
    public Score getScoreByUser(User user) {

        Cursor cursor = database.query(MySQLiteHelper.TABLE_SCORE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Score score = cursorToScore(cursor);
            if (score.getUser() == user.getId() ) {
                return score;
            }
            cursor.moveToNext();
        }
        cursor.close();
        return null;
    }

    private Score cursorToScore(Cursor cursor) {

        Score score = new Score();
        score.setId(cursor.getInt(0));
        score.setUser(cursor.getString(1));
        score.setlvl(cursor.getInt(2));
        score.setTime(cursor.getString(3));
        score.setScore(cursor.getInt(4));
        return score;
    }
}