package com.example.mizuki.firebasetesting.callback;

import com.example.mizuki.firebasetesting.data.vos.Note;

public interface EditNoteCallback {

    void onTapNote(Note note);

    void onPressNote(Note note);
}
