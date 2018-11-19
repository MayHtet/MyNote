package com.example.mizuki.firebasetesting.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mizuki.firebasetesting.R;
import com.example.mizuki.firebasetesting.callback.EditNoteCallback;
import com.example.mizuki.firebasetesting.data.vos.Note;
import com.example.mizuki.firebasetesting.viewholders.NoteViewHolder;

public class NoteRecyclerAdapter extends BaseRecyclerAdapter<NoteViewHolder,Note> {

    EditNoteCallback mEditNoteCallback;

    public NoteRecyclerAdapter(Context context, EditNoteCallback editNoteCallback) {
        super(context);
        mEditNoteCallback = editNoteCallback;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_note, viewGroup, false);
        return new NoteViewHolder(view,mEditNoteCallback);

    }
}
