package com.example.author.reminder4v.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.author.reminder4v.R;
import com.example.author.reminder4v.dummy.DummyContent;

/**
 * Created by author on 2017/09/24.
 */

public class ReminderViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public DummyContent.DummyItem mItem;

    public ReminderViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mIdView = (TextView) itemView.findViewById(R.id.id);
        mContentView = (TextView) itemView.findViewById(R.id.subject);
    }
}
