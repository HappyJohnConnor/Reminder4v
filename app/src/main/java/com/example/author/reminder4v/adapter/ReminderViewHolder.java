package com.example.author.reminder4v.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.author.reminder4v.R;
import com.example.author.reminder4v.model.ReminderItem;

/**
 * Created by author on 2017/09/24.
 */

public class ReminderViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final TextView mSubjectView;
    public final TextView mBodyView;
    public ReminderItem mItem;

    public ReminderViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mIdView = (TextView) itemView.findViewById(R.id.id);
        mSubjectView = (TextView) itemView.findViewById(R.id.subject);
        mBodyView=(TextView)itemView.findViewById(R.id.body);

    }
}
