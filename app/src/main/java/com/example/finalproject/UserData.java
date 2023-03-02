package com.example.finalproject;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.auth.User;

public class UserData {
    public void CreateUser(View view) {
        User user = new User(Username.getText().toString().trim(), ContactsContract.CommonDataKinds.Email.getText().toString().trim(), date.getText().toString().trim());
        fstore.collection("Users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(view.getContext(), "User has been added", Toast.LENGTH_SHORT).show();
                        return;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(view.getContext(), "failed to add User", Toast.LENGTH_SHORT).show();
                        return;
                    }
                });
    }
}
