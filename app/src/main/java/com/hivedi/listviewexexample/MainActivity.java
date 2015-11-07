package com.hivedi.listviewexexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.hivedi.widget.listviewex.ListViewEx;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewEx list = (ListViewEx) findViewById(R.id.list);

        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"item1", "item2", "item 3"}));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }
}
