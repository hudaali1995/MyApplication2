package hudaali.myapplication;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserCRUD {
        private MySQLiteOpenHelper helper;
    private SQLiteDatabase db;
    private final String TABLE_NAME ="USER";

    public UserCRUD(MySQLiteOpenHelper helper) {
        this.helper = helper;
        db=helper.getWritableDatabase();
    }

    public long adduser (User user){

        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("confirm_pass", user.getConfirmpass());
        long id =db.insert(TABLE_NAME,null,values);
        return id;

    }

    public void updateUser ( int id ,User user){
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("confirm_pass", user.getConfirmpass());
        db.update(TABLE_NAME,values," _id =?",new String[]{id+""});

    }
    public String search (String email){
        db=helper.getReadableDatabase();
        String query= "select email,pass From "+TABLE_NAME;
        Cursor cursor= db.rawQuery(query,null);
        String e,p;
        p="is not found ";
        if(cursor.moveToFirst()){
            do{
                e=cursor.getString(0);
                if (e.equals(email)){
                    p=cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
         return p;
    }

    public boolean check (String email){
       db=helper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] {helper.COLUMN_ID ,
                        helper.COLUMN_EMAIL },  helper.COLUMN_EMAIL + "=" + "'" + email + "'",
                null, null, null, null, null);

        if (cursor.moveToFirst()) {
            return true;
        }
        return false;
    }




}
