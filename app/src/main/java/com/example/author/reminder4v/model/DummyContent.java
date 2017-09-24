package com.example.author.reminder4v.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by author on 2017/09/24.
 */

public class DummyContent {
    public static final List<ReminderItem> DUMMY_ITEMS = new ArrayList<>();

    public Integer[] id={
            1,2,3
    };
    public String[] subject = {
            "ほげ", "abc", "abcd"
    };
    public String[] body={
            "ほげ", "abc", "abcd"
    };

    public List<ReminderItem> getDumuyItems(){
        for(int i=0; i< id.length; i++){
            DUMMY_ITEMS.add(new ReminderItem(subject[i], body[i],id[i]));
        }
        return DUMMY_ITEMS;
    }



}
