package com.example.rams.interact;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailid;
    private EditText passwordid;
    private Button loginbtn;
    private Button signupbtn;
    private FirebaseUser currentUser;
    private ProgressBar progressbar;
    @Override
    protected void onStart() {
        super.onStart();
        currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        progressbar=findViewById(R.id.progressBar3);
        mAuth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.user_name);
        passwordid = findViewById(R.id.user_pass);
        loginbtn = findViewById(R.id.btnlogin);
        signupbtn = findViewById(R.id.signup);

        //login process
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailid.getText().toString();
                String password = passwordid.getText().toString();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    progressbar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                currentUser = mAuth.getCurrentUser();
                                if (currentUser.isEmailVerified()) {
                                    Toast.makeText(LoginActivity.this, "Successsfully logged in!", Toast.LENGTH_LONG).show();
                                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(mainIntent);
                                    finish();
                                } else {
                                    mAuth.signOut();
                                    Toast.makeText(LoginActivity.this, "Verify your mail so that you can login", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                String errormsg = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this, errormsg, Toast.LENGTH_SHORT).show();
                            }
                            progressbar.setVisibility(View.INVISIBLE);
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Empty strings! Try again!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //SignUp process
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });

    }
}
