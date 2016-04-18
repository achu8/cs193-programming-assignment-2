package com.example.albert.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemLongClickListener {
    private ArrayList<String> toDoItems;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                toDoItems);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> list,
                               View row,
                               int index,
                               long rowID) {
        if (index < toDoItems.size()) {
            toDoItems.remove(index);
            adapter.notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void add_click(View view) {
        EditText newItem = (EditText) findViewById(R.id.newItem);

        toDoItems.add(newItem.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
