package com.example.itemlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        ArrayList<Model> list = new ArrayList<>();

        list.add(new Model("Alexa Dot","Amazon Alexa Smart Speaker", R.drawable.alexa ));
        list.add(new Model("DSLR Camera","DSLR camera that can take high quality images",R.drawable.camera));
        list.add(new Model("Rubik's Cube","Rubik's Cube for kids",R.drawable.cube));
        list.add(new Model("Headphone","Headphone for music",R.drawable.headphone));
        list.add(new Model("Lighter","Rugged lighter",R.drawable.lighter));

        adapter = new ListAdapter(this,list);

        recyclerView.setAdapter(adapter);
    }
}