package com.example.finalmobiledevelopment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference dRef;

    EditText ETInput;
    FloatingActionButton FBSend;
    String User, Inputan,Tanggal;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FBSend = findViewById(R.id.FBSend);
        ETInput = findViewById(R.id.ETInput);
        lv = findViewById(R.id.LVPesan);

        User = getIntent().getStringExtra("User");

        database = FirebaseDatabase.getInstance();
        dRef = database.getReference().child("mobiledevelopment");

        displayChatMessages();

        FBSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Inputan = ETInput.getText().toString();
                Date nowTanggal = Calendar.getInstance().getTime();
                DateFormat df = new DateFormat();
                Tanggal = df.format("dd-MM-yyyy (HH:mm:ss)",nowTanggal).toString();
                Chat chat = new Chat(Inputan, User, Tanggal);
                dRef.push().setValue(chat);
                ETInput.setText("");
        }
        });

    }

    private void displayChatMessages() {
        FirebaseListAdapter<Chat> adapter = new FirebaseListAdapter<Chat>(this, Chat.class, R.layout.pesan, FirebaseDatabase.getInstance().getReference("mobiledevelopment")) {
            @Override
            protected void populateView(View v, Chat model, int position) {
                TextView txtUser = v.findViewById(R.id.txtUserPesan);
                TextView txtWaktu = v.findViewById(R.id.txtWaktuPesan);
                TextView txtPesan = v.findViewById(R.id.txtPesan);

                txtPesan.setText(model.getMessageText());
                txtUser.setText(model.getMessageUser());

                txtWaktu.setText(model.getMessageTime());

            }
        };

        lv.setAdapter(adapter);
    }
}
