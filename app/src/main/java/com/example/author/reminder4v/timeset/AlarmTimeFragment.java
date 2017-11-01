package com.example.author.reminder4v.timeset;

import android.app.TimePickerDialog;
import android.content.Context;

/**
 * Created by author on 2017/10/09.
 */

public class AlarmTimeFragment extends TimePickerDialog {
    public AlarmTimeFragment(Context context, OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) {
        super(context, listener, hourOfDay, minute, is24HourView);
    }
}
