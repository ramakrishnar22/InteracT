package com.example.rams.interact;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rams.interact.utils.FontChanger;
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
    TextView signupbtn;
    Animation Zoomin,Zoomout;
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
    protected void onResume() {
        super.onResume();
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        Typeface normal = Typeface.createFromAsset(getAssets(),"font/sourceSansProSemiBold.ttf");
        FontChanger f = new FontChanger(getAssets(),"font/sourceSansProRegular.ttf");
        f.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        ((TextView)findViewById(R.id.interacTT)).setTypeface(normal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressbar=findViewById(R.id.progressBar3);
        mAuth = FirebaseAuth.getInstance();
        setAnimation();
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
    public void setAnimation(){
        Zoomin = AnimationUtils.loadAnimation(this,R.anim.zoomin);
        Zoomout = AnimationUtils.loadAnimation(this,R.anim.zoomout);
        ((ImageView)findViewById(R.id.deptbg)).startAnimation(Zoomin);
        Log.i("Animation","ZoomIN");
        Zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("Animation","ZoomOUT");
                ((ImageView)findViewById(R.id.deptbg)).startAnimation(Zoomout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("Animation","ZoomIN");
                ((ImageView)findViewById(R.id.deptbg)).startAnimation(Zoomin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
