package com.example.author.reminder4v;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.author.reminder4v.database.MyContentProvider;
import com.example.author.reminder4v.database.MyDBHelper;
import com.example.author.reminder4v.database.ReminderRepository;
import com.example.author.reminder4v.model.ReminderItem;

public class ItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    private ReminderItem mItem;
    private EditText subject_edit;
    private EditText body_edit;
    private Button ok_btn;

    private ReminderRepository mReminderRepository;

    private String strSubject;
    private String strBody;


    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReminderRepository = new ReminderRepository(getActivity());
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = mReminderRepository.getReminderItem(getArguments().getString(ARG_ITEM_ID));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        subject_edit = (EditText) rootView.findViewById(R.id.subject_edit);
        body_edit = (EditText) rootView.findViewById(R.id.body_edit);
        ok_btn = (Button) rootView.findViewById(R.id.ok_btn);

        if (mItem != null) {
            subject_edit.setText(mItem.getSubject());
            body_edit.setText(mItem.getBody());
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
        strSubject=subject_edit.getText().toString();
        strBody=body_edit.getText().toString();
    }

    private void saveItem() {
        if (isEmpty(subject_edit) && isEmpty(body_edit)) {
            getActivity().navigateUpTo(new Intent(getActivity(), ItemListActivity.class));

        } {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MyDBHelper.COLUMN_SUBJECT, subject_edit.getText().toString());
            contentValues.put(MyDBHelper.COLUMN_BODY, body_edit.getText().toString());
            getActivity().getContentResolver().insert(MyContentProvider.CONTENT_URI, contentValues);
            getActivity().navigateUpTo(new Intent(getActivity(), ItemListActivity.class));
        }
    }


    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}
