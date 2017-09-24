package com.example.author.reminder4v.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.author.reminder4v.R;
import com.example.author.reminder4v.temDetailActivity;
import com.example.author.reminder4v.ItemDetailFragment;
import com.example.author.reminder4v.dummy.DummyContent;

import java.util.List;

import static com.example.author.reminder4v.ItemListActivity.mTwoPane;

/**
 * Created by author on 2017/09/24.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderViewHolder> {

    private FragmentActivity context;

    Activity activity;

    private final List<DummyContent.DummyItem> mValues;

    public ReminderAdapter(List<DummyContent.DummyItem> items) {
        mValues = items;
    }

    @Override
    public ReminderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ReminderViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context = (FragmentActivity) activity;
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);

                    context.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.reminderitem_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, temDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

}

