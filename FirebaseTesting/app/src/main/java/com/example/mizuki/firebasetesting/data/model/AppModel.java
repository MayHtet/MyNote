package com.example.mizuki.firebasetesting.data.model;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.mizuki.firebasetesting.callback.NoteListCallback;
import com.example.mizuki.firebasetesting.data.vos.Note;
import com.example.mizuki.firebasetesting.utils.ChildDatabaseReference;
import com.example.mizuki.firebasetesting.utils.NetworkConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppModel extends AndroidViewModel {

    public AppModel(Application application){
        super(application);
    }

    public void startLoadingNoteList(final NoteListCallback noteListCallback){

        ChildDatabaseReference.getChildDBR().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Note> noteList = new ArrayList<>();

                for(DataSnapshot noteDSS: dataSnapshot.getChildren()){
                    Note note = noteDSS.getValue(Note.class);
                    if(note.getDelete() != 1)
                    noteList.add(note);
                }

                noteListCallback.loadNoteList(noteList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void startUploadNote(Note note){

        ChildDatabaseReference.getChildDBR().child(note.getCreatedmili()).setValue(note);
    }

    public void editNote(Note note){

        ChildDatabaseReference.getChildDBR().child(note.getCreatedmili()).setValue(note);

    }

    public void deleteNote(Note note){

        Note newNote = new Note();
        newNote.setCreatedmili(note.getCreatedmili());
        newNote.setDate(note.getDate());
        newNote.setDescription(note.getDescription());
        newNote.setEmotion(note.getEmotion());
        newNote.setTitle(note.getTitle());
        newNote.setDelete(Long.valueOf(1));

        ChildDatabaseReference.getChildDBR().child(newNote.getCreatedmili()).setValue(newNote);
    }


}
