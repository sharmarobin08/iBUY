package com.example.ibuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibuy.db.members;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Signup extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5;
    EditText e1, e2, e3, e4, e5;
    Button b;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);
        t4 = findViewById(R.id.text4);
        t5 = findViewById(R.id.text5);
        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.edit2);
        e3 = findViewById(R.id.edit3);
        e4 = findViewById(R.id.edit4);
        e5 = findViewById(R.id.edit5);
        b = findViewById(R.id.button);
        db = FirebaseFirestore.getInstance();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = e1.getText().toString();
                String Email = e2.getText().toString();
                String Password = e3.getText().toString();
                String Address = e4.getText().toString();
                String Mobile = e5.getText().toString();
                addData(Name, Email, Password, Address, Mobile);
            }
        });
    }

    public void addData(String Name, String Email, String Password, String Address, String Mobile) {
        members M = new members(Name, Email, Password, Address, Mobile);
        db.collection("Registered Members")
                .add(M)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Member Registered", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
