package com.example.rams.interact;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetupActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private EditText setname;
    private Button setbtn;
    private String user_id;
    public String username;
    public boolean bool;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        user_id=firebaseAuth.getCurrentUser().getUid();
        setname=findViewById(R.id.setname);
        setbtn=findViewById(R.id.setbtn);

        setbtn.setEnabled(false);

        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        username=task.getResult().getString("user_name");
                        setname.setText(username);
                    }
                }
                else{
                    String doc=task.getException().getMessage();
                    Toast.makeText(getApplicationContext(),"Retrieve Error:"+doc,Toast.LENGTH_SHORT).show();
                }
                setbtn.setEnabled(true);
            }
        });

        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData(new FirebaseCallback() {
                    @Override
                    public void onCallBack(boolean bool) {
                        if(bool==false){
                            Toast.makeText(getApplicationContext(),"User Name Exists",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            final String username=setname.getText().toString();
                            if(!TextUtils.isEmpty(username)) {
                                    Map<String, Object> userdata = new HashMap<>();
                                    userdata.put("user_name", username);
                                    firebaseFirestore.collection("Users").document(user_id).set(userdata).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(SetupActivity.this, "The user Settings are updated.", Toast.LENGTH_LONG).show();
                                                Intent mainIntent = new Intent(SetupActivity.this, MainActivity.class);
                                                startActivity(mainIntent);
                                                finish();
                                            } else {
                                                String error = task.getException().getMessage();
                                                Toast.makeText(SetupActivity.this, "(FIRESTORE Error) : " + error, Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Enter the User Name",Toast.LENGTH_SHORT).show();
                                }
                        }
                    }
                });
            }
        });
    }

    private void readData(final FirebaseCallback firebaseCallback){
        bool = true;
        firebaseFirestore.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    List<DocumentSnapshot> doclist = task.getResult().getDocuments();
                    Log.i("Current User",setname.getText().toString());
                    for(DocumentSnapshot d : doclist){
                        if(d.get("user_name").equals(setname.getText().toString())){
                            bool = false;
                            break;
                        }
                    }
                }
                firebaseCallback.onCallBack(bool);
            }
        });
    }
    private interface FirebaseCallback{
        void onCallBack(boolean bool);
    }
}
