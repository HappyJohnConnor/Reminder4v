package com.example.author.reminder4v;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.author.reminder4v.database.MyDBHelper;
import com.example.author.reminder4v.model.ReminderItem;
import com.example.author.reminder4v.model.ReminderRepository;

import java.util.ArrayList;
import java.util.List;


public class ItemListActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;
    private MyDBHelper mDBHelper;
    private ReminderRepository mReminderRepository;
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

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;

        mReminderRepository = new ReminderRepository(this);
        items = mReminderRepository.getAllItems();
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        mDBHelper = new MyDBHelper(this);
        mDatabase = mDBHelper.getWritableDatabase();
    }



    private void onAddingBottomPushed() {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, ItemDetailActivity.class);
            startActivity(intent);
        }

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new ReminderAdapter(this, items));
    }

    public static class ReminderAdapter
            extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {

        private final ItemListActivity mParentActivity;
        private final List<ReminderItem> mItems;
        private ItemPresenter mItemPresenter;


        public ReminderAdapter(ItemListActivity parent, List<ReminderItem> items) {
            mItems = items;
            mParentActivity = parent;
        }

        @Override
        public ReminderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ReminderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ReminderViewHolder holder, int position) {

            holder.mSubjectView.setText(mItems.get(position).getSubject());
            holder.mBodyView.setText(mItems.get(position).getBody());
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        class  ReminderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public final View mView;
            public final TextView mSubjectView;
            public final TextView mBodyView;

            public ReminderViewHolder(View itemView) {
                super(itemView);
                mView = itemView;
                mSubjectView = (TextView) itemView.findViewById(R.id.subject);
                mBodyView=(TextView)itemView.findViewById(R.id.body);
                itemView.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                mItemPresenter=new ItemPresenter(context);
                ReminderItem item=  mItemPresenter.getItemAt(getAdapterPosition());
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.getId());
                Log.v("came", item.getId());
                context.startActivity(intent);
            }
        }

    }



}