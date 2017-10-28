package hudaali.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MySQLiteOpenHelper extends SQLiteOpenHelper{
    public static final String COLUMN_ID = "user_id";
    private static final String COLUMN_NAME = "user_name";
    private static final String COLUMN_Confirm = "user_confirmPass";
    public static final String COLUMN_EMAIL = "user_email";
    public static final String COLUMN_PASSWORD = "user_password";


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql  = "Create table User"+"("+ COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," +
        COLUMN_EMAIL + " TEXT," + COLUMN_PASSWORD  + " TEXT,"+COLUMN_Confirm  + " TEXT," + ")";
               db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
