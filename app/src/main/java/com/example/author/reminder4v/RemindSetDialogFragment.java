package com.example.author.reminder4v;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class RemindSetDialogFragment extends DialogFragment {


    public RemindSetDialogFragment() {
    }

    public static RemindSetDialogFragment newInstance(Fragment target){
        RemindSetDialogFragment fragment =new RemindSetDialogFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle(R.string.edit_of_reminder);
        View v=inflater.inflate(R.layout.dialog_remind_set, container, false);
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
        // ダイアログを生成して返す
        return builder.create();
    }
}
