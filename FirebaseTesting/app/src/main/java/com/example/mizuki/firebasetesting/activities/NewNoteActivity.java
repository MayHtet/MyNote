package com.example.mizuki.firebasetesting.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mizuki.firebasetesting.R;
import com.example.mizuki.firebasetesting.data.vos.Note;

import java.text.DateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class NewNoteActivity extends BaseActivity {

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

    public static Intent newIntent(Context context){
        return new Intent(context,NewNoteActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());

        tvDate.setText(dateFormat.format(new Date()));
    }

    @Override
    protected boolean setDisplayHomeUpEnabled() {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_new_note;
    }

    @OnClick(R.id.fab_save)
    public void onTapSave(){
        Note note = new Note();
        note.setCreatedmili(String.valueOf(new Date().getTime()));
        note.setDate(new Date().toString());
        note.setDescription(etDescription.getText().toString());
        note.setTitle(etTitle.getText().toString());
        note.setEmotion(etFeeling.getText().toString());

        getmAppModel().startUploadNote(note);

        finish();
    }
}
