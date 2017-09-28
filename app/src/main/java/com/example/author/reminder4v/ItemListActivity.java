package com.example.author.reminder4v;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.author.reminder4v.adapter.ReminderAdapter;
import com.example.author.reminder4v.database.MyDBHelper;
import com.example.author.reminder4v.database.ReminderRepository;
import com.example.author.reminder4v.model.ReminderItem;

import java.util.ArrayList;
import java.util.List;


public class ItemListActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;
    private MyDBHelper mDBHelper;
    private ReminderRepository mRemiderRepository;
    public static boolean mTwoPane;


    public List<ReminderItem> items = new ArrayList<>();

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
                onAddingBottomPushed();
            }
        });

        View recyclerView = findViewById(R.id.reminderitem_list);
        assert recyclerView != null;
        /*DummyContent dummyContent = new DummyContent();
        dummyContent.getDumuyItems();*/
        mRemiderRepository= new ReminderRepository(this);
        items =mRemiderRepository.getAllItems();
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.reminderitem_detail_container) != null) {
            mTwoPane = true;
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        /*for (int i = 0; i < DUMMY_ITEMS.size(); i++) {
            Log.v(String.valueOf(i), DUMMY_ITEMS.get(i).getSubject());
            int count;

        }*/

        mDBHelper = new MyDBHelper(this);
        mDatabase = mDBHelper.getWritableDatabase();
        long recodeCount = DatabaseUtils.queryNumEntries(mDatabase, MyDBHelper.TABLE_NAME);
        Log.d("hoge", "recodeCount : " + recodeCount);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        recyclerView.setAdapter(new ReminderAdapter(items));
    }

    private void onAddingBottomPushed() {
        Intent intent = new Intent(this, ItemDetailActivity.class);
        this.startActivity(intent);

    }

}
/*
@Override
public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";*/