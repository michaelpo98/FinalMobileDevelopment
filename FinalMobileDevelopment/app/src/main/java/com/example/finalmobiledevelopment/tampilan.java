package com.example.finalmobiledevelopment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tampilan extends AppCompatActivity {

    EditText ETUser, ETPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan);

        ETUser = findViewById(R.id.ETUser);
        ETPass = findViewById(R.id.ETPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tampilan.this,MainActivity.class);
                intent.putExtra("User",ETUser.getText().toString());
                startActivity(intent);
            }
        });

    }

}
