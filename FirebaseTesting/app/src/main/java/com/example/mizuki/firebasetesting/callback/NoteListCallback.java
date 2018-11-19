package com.example.mizuki.firebasetesting.callback;

import com.example.mizuki.firebasetesting.data.vos.Note;

import java.util.List;

public interface NoteListCallback {

    void loadNoteList(List<Note> noteList);
}
