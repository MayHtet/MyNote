package com.example.mizuki.firebasetesting.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.mizuki.firebasetesting.R;
import com.example.mizuki.firebasetesting.callback.EditNoteCallback;
import com.example.mizuki.firebasetesting.data.vos.Note;

import butterknife.BindView;

public class NoteViewHolder extends BaseViewHolder<Note> implements View.OnLongClickListener{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_description)
    TextView tvDescription;

    EditNoteCallback mEditNoteCallback;

    public NoteViewHolder(@NonNull View itemView, EditNoteCallback editNoteCallback) {
        super(itemView);
        mEditNoteCallback = editNoteCallback;
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void bind(Context context) {

        tvTitle.setText(mData.getTitle());
        tvDescription.setText(mData.getDescription());
    }

    @Override
    public void onClick(View v) {
        mEditNoteCallback.onTapNote(mData);

    }

    @Override
    public boolean onLongClick(View v) {

        mEditNoteCallback.onPressNote(mData);

        return true;
    }
}
