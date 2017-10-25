package com.example.author.reminder4v;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;

public class RemindSetDialogFragment extends DialogFragment {

    Dialog dialog;
    Spinner dateSpinner;
    Spinner timeSpinner;
    Button deleteBtn;
    Button cancelBtn;
    Button saveBtn;

    public RemindSetDialogFragment() {
    }

    public static RemindSetDialogFragment newInstance() {
        RemindSetDialogFragment fragment = new RemindSetDialogFragment();

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_remind_set, null, false);
        dateSpinner = v.findViewById(R.id.date_spin);
        timeSpinner = v.findViewById(R.id.time_spin);
        deleteBtn = v.findViewById(R.id.delete_date_btn);
        cancelBtn = v.findViewById(R.id.cancel_date_btn);
        saveBtn = v.findViewById(R.id.save_date_btn);

        dialog = new Dialog(getActivity());
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.setContentView(v);
        dialog.setTitle(R.string.edit_of_reminder);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
