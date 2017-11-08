package com.example.author.reminder4v;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class ItemDetailActivity extends AppCompatActivity {
    private final static String TAG = ItemDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        if (savedInstanceState == null) {
            ItemDetailFragment fragment = new ItemDetailFragment();
            Bundle arguments = new Bundle();
            if (getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID) != null) {
                Log.d(TAG, "come here");
                arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                        getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));

            } else {
                arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                        "new");
            }
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            navigateUpTo(new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
