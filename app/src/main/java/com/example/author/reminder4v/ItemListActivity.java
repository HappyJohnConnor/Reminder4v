package com.example.author.reminder4v;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.author.reminder4v.adapter.ReminderAdapter;
import com.example.author.reminder4v.model.DummyContent;

import static com.example.author.reminder4v.model.DummyContent.DUMMY_ITEMS;

public class ItemListActivity extends AppCompatActivity {


    public static boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });

        View recyclerView = findViewById(R.id.reminderitem_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.reminderitem_detail_container) != null) {
            mTwoPane = true;
        }
    }



    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        DummyContent dummyContent= new DummyContent();
        dummyContent.getDumuyItems();
        recyclerView.setAdapter(new ReminderAdapter(DUMMY_ITEMS));
    }

    private void addItem() {
        Intent intent = new Intent(this, ItemDetailActivity.class);
        this.startActivity(intent);
    }

}
/*
@Override
public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";*/