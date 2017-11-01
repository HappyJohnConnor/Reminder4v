package com.example.author.reminder4v.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.author.reminder4v.ItemListActivity;
import com.example.author.reminder4v.R;
import com.example.author.reminder4v.model.ReminderItem;
import com.example.author.reminder4v.model.ReminderRepository;

import java.util.List;

/**
 * Created by author on 2017/09/24.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderViewHolder> {

    private FragmentActivity context;
    private final ItemListActivity mParentActivity;
    ReminderRepository mReminderRepository;
    Context mContext;

    Activity activity;

    private final List<ReminderItem> mItems;

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

        holder.mItem = mItems.get(position);
        holder.mSubjectView.setText(mItems.get(position).getSubject());
        holder.mBodyView.setText(mItems.get(position).getBody());
        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext = mContext.getApplicationContext();
                mReminderRepository = new ReminderRepository(mContext);
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.getId());
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Log.v("mTwoPane", "this");
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.getId());

                    context.startActivity(intent);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}

