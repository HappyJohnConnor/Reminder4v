package com.example.author.reminder4v.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.author.reminder4v.ItemDetailActivity;
import com.example.author.reminder4v.ItemDetailFragment;
import com.example.author.reminder4v.ItemPresenter;
import com.example.author.reminder4v.R;
import com.example.author.reminder4v.model.ReminderItem;

/**
 * Created by author on 2017/09/24.
 */

public class ReminderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public final View mView;
    public final TextView mSubjectView;
    public final TextView mBodyView;
    public ReminderItem mItem;
    private Context mContext;


    private ItemPresenter mItemPresenter;

    public ReminderViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mSubjectView = (TextView) itemView.findViewById(R.id.subject);
        mBodyView=(TextView)itemView.findViewById(R.id.body);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mContext=mContext.getApplicationContext();
        mItemPresenter=new ItemPresenter(mContext);
        ReminderItem item=  mItemPresenter.getItemAt(this.getAdapterPosition());
        Intent intent = new Intent(mContext, ItemDetailActivity.class);
        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.getId());
        mContext.startActivity(intent);
    }
}
