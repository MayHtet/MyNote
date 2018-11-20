package com.example.mizuki.firebasetesting.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mizuki.firebasetesting.R;
import com.example.mizuki.firebasetesting.data.vos.Note;

import java.text.DateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class EditNoteActivity extends BaseActivity{

    public static final String NOTE = "NOTE";

    @BindView(R.id.fab_save)
    FloatingActionButton fabSave;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_description)
    EditText etDescription;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.et_feeling)
    EditText etFeeling;

    Note mNote;

    public static Intent newIntent(Context context, Note note){
        Intent intent= new Intent(context, EditNoteActivity.class);
        intent.putExtra(NOTE,note);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNote = (Note)getIntent().getSerializableExtra(NOTE);
        etTitle.setText(mNote.getTitle());
        etDescription.setText(mNote.getDescription());
        etFeeling.setText(mNote.getEmotion());

        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        tvDate.setText(dateFormat.format(new Date(mNote.getDate())));


    }

    @Override
    protected boolean setDisplayHomeUpEnabled() {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_new_note;
    }

    @OnClick(R.id.fab_save)
    public void onTapEdit(){

        Note newNote = new Note();
        newNote.setCreatedmili(mNote.getCreatedmili());
        newNote.setDate(mNote.getDate());
        newNote.setDescription(etDescription.getText().toString());
        newNote.setTitle(etTitle.getText().toString());
        newNote.setEmotion(etFeeling.getText().toString());
        newNote.setDelete(mNote.getDelete());

        getmAppModel().editNote(newNote);

        finish();
    }
}
