package com.example.author.reminder4v;

import android.content.Context;

import com.example.author.reminder4v.model.ReminderRepository;
import com.example.author.reminder4v.model.ReminderItem;

/**
 * Created by author on 2017/10/31.
 */

public class ItemPresenter {
    private ReminderRepository mReminderRepositroy;
    private Context mContext;

    public ItemPresenter(Context context) {
        mReminderRepositroy= ReminderRepository.getInstance(context);
    }

    public ReminderItem getItemAt(int position){
        return mReminderRepositroy.getAllItems().get(position);
    }
}
