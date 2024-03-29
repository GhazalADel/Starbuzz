package com.hfad.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TopLevelActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);


        //Create an OnItemClickListener
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(TopLevelActivity.this,
                            DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
