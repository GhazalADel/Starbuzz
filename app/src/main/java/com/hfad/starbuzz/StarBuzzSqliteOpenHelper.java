package com.hfad.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Peyman on 7/9/2017.
 */
public class StarBuzzSqliteOpenHelper extends SQLiteOpenHelper {

    static String dbName = "starBuzz";
    static int db_version = 1;

    public StarBuzzSqliteOpenHelper(Context context) {
        super(context, dbName, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DRINKS ( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT," +
                "DESCRIPTION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER);");
        ContentValues cv = new ContentValues();
        cv.put("NAME","Latte");
        cv.put("DESCRIPTION","Espresso and steamed milk");
        cv.put("IMAGE_RESOURCE_ID",R.drawable.latte);
        db.insert("DRINKS",null,cv);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
