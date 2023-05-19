package com.hfad.starbuzz;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends Activity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        
        //Get the drink from the intent
        int drinkNo = (Integer)getIntent().getExtras().get("index");
        Drink drink = null;
        try {
            StarBuzzSqliteOpenHelper openHelper = new StarBuzzSqliteOpenHelper(this);
            SQLiteDatabase db = openHelper.getWritableDatabase();
            Cursor cursor = db.query("DRINKS",
                    new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID"},"_id=?",
                    new String[]{String.valueOf(drinkNo)},null,null,null);
            if(cursor.moveToFirst()){
                String name =  cursor.getString(0);
                String desc  = cursor.getString(1);
                int id = cursor.getInt(2);
                drink = new Drink(name,desc,id);
            }


        }catch (SQLException e){
            Toast.makeText(this, "DataBase Does not Exists", Toast.LENGTH_SHORT).show();
        }


        //Populate the drink image
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());

        //Populate the drink name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(drink.getName());

        //Populate the drink description
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(drink.getDescription());
    }
}
