package com.hnam.firebasechatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference rootDB = firebaseDatabase.getReference();

    private Button btnClick;
    private EditText editText;
    private RecyclerView rv;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.button2);
        btnClick.setOnClickListener(onButtonClick);
        editText = findViewById(R.id.editText);
        rv = findViewById(R.id.rv);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setHasFixedSize(true);
        adapter = new ChatAdapter(this);
        rv.setAdapter(adapter);

        registerListener();
    }

    private View.OnClickListener onButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //todo push
            String msg = editText.getText().toString().trim();
            long timestample = Calendar.getInstance().getTimeInMillis();
            MyMessage message = new MyMessage(msg, timestample);
            rootDB.child("Messages").push().setValue(message);
        }
    };

    private void registerListener(){
        rootDB.child("Messages").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.e(TAG,">>>>>" + s);
                if (dataSnapshot.exists()){
                    MyMessage m = dataSnapshot.getValue(MyMessage.class);
                    if (m != null) {
                        Log.e(TAG,">>>>> 11" + s);
                        adapter.addData(m);
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
