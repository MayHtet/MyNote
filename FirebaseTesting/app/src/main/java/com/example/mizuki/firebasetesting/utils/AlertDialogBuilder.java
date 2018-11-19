package com.example.mizuki.firebasetesting.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.mizuki.firebasetesting.data.model.AppModel;
import com.example.mizuki.firebasetesting.data.vos.Note;

public class AlertDialogBuilder {

    public static void showDialog(Context context,final AppModel appModel, final Note note){
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Delete")
                .setMessage("Are you sure to delete this note")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        appModel.deleteNote(note.getCreatedmili());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }
}
