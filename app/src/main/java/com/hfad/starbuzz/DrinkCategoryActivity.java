package com.hfad.starbuzz;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DrinkCategoryActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            StarBuzzSqliteOpenHelper openHelper = new StarBuzzSqliteOpenHelper(this);
            SQLiteDatabase db = openHelper.getReadableDatabase();
            Cursor cursor =  db.query("DRINKS",new String[]
                    {"_id","NAME","IMAGE_RESOURCE_ID"}
                    ,null,null,null,null,null);
            CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, cursor,new String[]{"NAME"},new int[]{android.R.id.text1},0);
            ListView lw = getListView();
            lw.setAdapter(cursorAdapter);

        }catch (SQLiteException e){
            Toast.makeText(this,"DataBase is not Available!!!",Toast.LENGTH_LONG).show();
        }


//        ArrayAdapter<Drink> adapter = new ArrayAdapter<Drink>(
//                this, android.R.layout.simple_list_item_1
//                , Drink.drinks
//        );
//        ListView view = getListView();
//        view.setAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, DrinkActivity.class);
        i.putExtra("index", position+1);
        startActivity(i);
    }
}





