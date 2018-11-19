package com.example.mizuki.firebasetesting.activities;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.mizuki.firebasetesting.R;
import com.example.mizuki.firebasetesting.adapters.NoteRecyclerAdapter;
import com.example.mizuki.firebasetesting.callback.EditNoteCallback;
import com.example.mizuki.firebasetesting.callback.NoteListCallback;
import com.example.mizuki.firebasetesting.data.vos.Note;
import com.example.mizuki.firebasetesting.utils.AlertDialogBuilder;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements EditNoteCallback{

    @BindView(R.id.rv_note)
    RecyclerView rvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getmAppModel().startLoadingNoteList(new NoteListCallback() {
            @Override
            public void loadNoteList(List<Note> noteList) {
                Toast.makeText(MainActivity.this,noteList.size()+"",Toast.LENGTH_LONG).show();
                
                setUpRecyclerView(noteList);
            }
        });
    }

    private void setUpRecyclerView(List<Note> noteList) {

        NoteRecyclerAdapter noteRecyclerAdapter = new NoteRecyclerAdapter(this,this);
        rvNote.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rvNote.setAdapter(noteRecyclerAdapter);
        noteRecyclerAdapter.setData(noteList);
    }

    @Override
    protected boolean setDisplayHomeUpEnabled() {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.fab_add)
    public void onTapAdd(){
        startActivity(NewNoteActivity.newIntent(this));
    }

    @Override
    public void onTapNote(Note note) {
        startActivity(EditNoteActivity.newIntent(this,note));
    }

    @Override
    public void onPressNote(Note note) {

        AlertDialogBuilder.showDialog(this, getmAppModel(),note);
    }

//    @OnClick(R.id.btn_insert)
//    public void onTapInsert(){
//        Note note = new Note();
//        note.setDate(new Date().toString());
//        note.setDescription("Thank you");
//        note.setTitle("DAY");
//        note.setEmotion("bored");
//
//        getmAppModel().startUploadNote(note);
//    }
}
