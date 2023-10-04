package uz.jasurbekruzimov.smartchild.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "smartChild.db";
    private static final String TABLE_NAME = "users";
    private static final String COL_ID = "id";
    private static final String Ismi = "Ismi";
    private static final String Familiyasi = "Familiyasi";
    private final Context context;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Ismi + " TEXT, " +
                Familiyasi + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + " TimeStamp DEFAULT CURRENT_TIMESTAMP");
        }
    }

    public void mahalla(String ismi, String familiyasi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Ismi, ismi);
        contentValues.put(Familiyasi, familiyasi);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            Toast.makeText(context, "Xatolik yuz berdi !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ma'lumotlar saqlandi !", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String ismi, String familiyasi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Ismi, ismi);
        contentValues.put(Familiyasi, familiyasi);
        long result = db.update(TABLE_NAME, contentValues, "id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Xatolik yuz berdi !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ma'lumotlar yangilandi !", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Xatolik yuz berdi !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ma'lumotlar o'chirildi !", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

}
