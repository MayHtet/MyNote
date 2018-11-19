
package com.example.mizuki.firebasetesting.data.vos;

import java.util.List;

@SuppressWarnings("unused")
public class NoteResponse {

    private List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}
