package com.example.author.reminder4v;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.author.reminder4v.database.MyContentProvider;
import com.example.author.reminder4v.database.MyDBHelper;
import com.example.author.reminder4v.model.ReminderItem;
import com.example.author.reminder4v.model.ReminderRepository;

import static android.net.Uri.withAppendedPath;

public class ItemDetailFragment extends Fragment implements TimePickerDialog.OnTimeSetListener {
    private final static String TAG = ItemDetailFragment.class.getSimpleName();

    public static final String ARG_ITEM_ID = "item_id";
    private static final String TAG_DIALOG_FRAGMENT = "dialog_fragment";

    private ReminderItem mItem;
    EditText subject_edit;
    EditText body_edit;
    Button ok_btn;

    private ReminderRepository mReminderRepository;
    private RemindSetDialogFragment mRemindSetDialogFragment;

    String strSubject;
    String strBody;


    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReminderRepository = ReminderRepository.getInstance(getContext());

        //ARG自体がそもそもない
        //でもsavedInstanceはnull
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            if (!getArguments().getString(ARG_ITEM_ID).equals("new")) {
                mItem = mReminderRepository.getReminderItem(getArguments().getString(ARG_ITEM_ID));
            } else {
                Log.d(TAG, "come here");
                mItem = new ReminderItem();
            }
        }

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        subject_edit = rootView.findViewById(R.id.subject_edit);
        body_edit = rootView.findViewById(R.id.body_edit);
        ok_btn = rootView.findViewById(R.id.ok_btn);

        if (mItem != null) {
            subject_edit.setText(mItem.getSubject());
            body_edit.setText(mItem.getBody());
            if (mItem.isHasRemind()) {
                //todo 時間をゲットしてセット
                //integerを時間に変換

            }
        }
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem();
            }
        });
        strSubject = subject_edit.getText().toString();
        strBody = body_edit.getText().toString();

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.detail_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_item:
                Uri uri = withAppendedPath(MyContentProvider.CONTENT_URI, mItem.getId());
                getActivity().getContentResolver().delete(uri, MyDBHelper.COL_ID + "=" + mItem.getId(), null);
                getActivity().navigateUpTo(new Intent(getActivity(), ItemListActivity.class));
                break;
            case R.id.set_alarm:
                RemindSetDialogFragment dialog = RemindSetDialogFragment.newInstance(ARG_ITEM_ID);
                dialog.show(getFragmentManager(), TAG_DIALOG_FRAGMENT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void saveItem() {
        if (isEmpty(subject_edit) && isEmpty(body_edit)) {
            getActivity().navigateUpTo(new Intent(getActivity(), ItemListActivity.class));

        } else if (mItem.getId() != null) {
            ContentValues values = new ContentValues();
            values.put(MyDBHelper.COL_SUBJECT, subject_edit.getText().toString());
            values.put(MyDBHelper.COL_BODY, body_edit.getText().toString());
            values.putNull(MyDBHelper.COL_DATE);
            Uri uri = withAppendedPath(MyContentProvider.CONTENT_URI, mItem.getId());
            getActivity().getContentResolver().update(uri, values,MyDBHelper.COL_ID + "=" + mItem.getId(), null);
            getActivity().navigateUpTo(new Intent(getActivity(), ItemListActivity.class));

        } else {
            ContentValues values = new ContentValues();
            values.put(MyDBHelper.COL_SUBJECT, subject_edit.getText().toString());
            values.put(MyDBHelper.COL_BODY, body_edit.getText().toString());
            values.putNull(MyDBHelper.COL_DATE);
            getActivity().getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
            getActivity().navigateUpTo(new Intent(getActivity(), ItemListActivity.class));
        }
    }


    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}
