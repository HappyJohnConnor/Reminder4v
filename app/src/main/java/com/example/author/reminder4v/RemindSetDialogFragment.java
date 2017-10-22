package com.example.author.reminder4v;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class RemindSetDialogFragment extends DialogFragment {

    Spinner dateSpinner;
    Spinner timeSpinner;
    Button deleteBtn;
    Button cancelBtn;
    Button saveBtn;

    public RemindSetDialogFragment() {
    }

    public static RemindSetDialogFragment newInstance(Fragment target) {
        RemindSetDialogFragment fragment = new RemindSetDialogFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle(R.string.edit_of_reminder);
        View v = inflater.inflate(R.layout.dialog_remind_set, container, false);
        dateSpinner = v.findViewById(R.id.date_spin);
        timeSpinner = v.findViewById(R.id.time_spin);
        deleteBtn = v.findViewById(R.id.delete_date_btn);
        cancelBtn = v.findViewById(R.id.cancel_date_btn);
        saveBtn = v.findViewById(R.id.save_date_btn);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();

        // 入力ダイアログ用のView
        LayoutInflater inflater = LayoutInflater.from(context);
        View contentView = inflater.inflate(R.layout.dialog_remind_set, null);

        // ダイアログ生成用のビルダー
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.edit_of_reminder)
                .setView(contentView);
        // Log.v("test", String.valueOf(dateSpinner.getSelectedItem()));
        // ダイアログを生成して返す
        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();

        dateSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        String selectedItemString = (String) dateSpinner.getItemAtPosition(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );

        timeSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }

                }
        );
        // Log.v("test", String.valueOf(dateSpinner.getSelectedItem()));
    }

}
