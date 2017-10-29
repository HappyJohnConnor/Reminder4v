package com.example.author.reminder4v;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.author.reminder4v.database.ReminderRepository;
import com.example.author.reminder4v.model.ReminderItem;

import static com.example.author.reminder4v.ItemDetailFragment.ARG_ITEM_ID;

public class RemindSetDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener,
        View.OnClickListener {

    Dialog dialog;

    private ReminderItem mItem;
    private ReminderRepository mReminderRepository;

    private Spinner dateSpinner;
    private Spinner timeSpinner;
    private Button deleteBtn;
    private Button cancelBtn;
    private Button saveBtn;

    public RemindSetDialogFragment() {
    }

    public static RemindSetDialogFragment newInstance(String item_id) {
        RemindSetDialogFragment fragment = new RemindSetDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_ID, item_id);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_remind_set, null, false);

        mReminderRepository=new ReminderRepository(getActivity());
        if(getArguments().containsKey(ARG_ITEM_ID)){
            if(ARG_ITEM_ID!="item_id"){
                mItem=mReminderRepository.getReminderItem(ARG_ITEM_ID);
            }
        }
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

        deleteBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        dateSpinner.setOnItemSelectedListener(this);
        timeSpinner.setOnItemSelectedListener(this);


        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.v("datespin", String.valueOf(dateSpinner.getSelectedItemPosition()));
        switch (dateSpinner.getSelectedItemPosition()) {
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_date_btn:
                dialog.dismiss();
                break;
            case R.id.cancel_date_btn:
                dialog.dismiss();
                break;
        }
    }
}
