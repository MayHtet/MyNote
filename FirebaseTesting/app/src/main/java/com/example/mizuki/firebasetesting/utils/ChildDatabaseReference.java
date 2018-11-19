package com.example.mizuki.firebasetesting.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChildDatabaseReference {

    public static DatabaseReference getChildDBR(){

        DatabaseReference noteDBR = FirebaseDatabase.getInstance().getReference();
        DatabaseReference noteChildDBR = noteDBR.child(NetworkConstants.NOTES);

        return noteChildDBR;

    }
}
