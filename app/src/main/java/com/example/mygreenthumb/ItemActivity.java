package com.example.mygreenthumb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        productList=new ArrayList<>();

        productList.add(new Product("Tool","₹ 145",R.drawable.tool));
        productList.add(new Product("Vitro","₹ 400",R.drawable.vitro));
        productList.add(new Product("Carrot","₹ 40",R.drawable.carrot));
        productList.add(new Product("Corn","₹ 60",R.drawable.corn));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recycler_product);
        ItemRecyclerAdapter myAdapter = new ItemRecyclerAdapter(this,productList);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);


        Toolbar toolbar = findViewById(R.id.toolbarItem);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.item,menu);

        return true;
    }

}
