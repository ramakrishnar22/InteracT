package com.example.rams.interact;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rams.interact.utils.FontChanger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    private EditText signupmail;
    private EditText signuppass;
    private EditText signuppass1;
    private Button signupbtn;
    Animation Zoomin,Zoomout;
    private CheckBox showpass;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private static final String email_pattern="^([^@])+@(.*)it\\.ssn\\.edu\\.in";
    private static final String email_pattern1="^([^@])+@(.*)ssn\\.edu\\.in";
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setAnimation();
        FontChanger f = new FontChanger(getAssets(),"font/sourceSansProRegular.ttf");
        f.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        signupmail=findViewById(R.id.signupmail);
        signuppass=findViewById(R.id.signuppass);
        signuppass1=findViewById(R.id.signuppass1);
        showpass=findViewById(R.id.showpass);
        progressbar=findViewById(R.id.progressBar2);
        final Pattern pattern = Pattern.compile(email_pattern);
        final Pattern pattern1 = Pattern.compile(email_pattern1);
        mAuth = FirebaseAuth.getInstance();
        signupbtn=findViewById(R.id.signupbtn);

        //Declaration are done above here!
        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b){
                    signuppass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    signuppass1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    signuppass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    signuppass1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        //

        signupmail.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });
        signuppass.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });
        signuppass1.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=signupmail.getText().toString();
                String pass=signuppass.getText().toString();
                String pass1=signuppass1.getText().toString();
                Matcher matcher = pattern.matcher(email);
                Matcher matcher1 = pattern1.matcher(email);
                if(!(matcher.matches() || matcher1.matches())){
                    Toast.makeText(SignUpActivity.this,"The mail ID is not a valid ssn  IT mail",Toast.LENGTH_LONG).show();
                    signupmail.setText(null);
                    email="";
                }
                if( !(pass.equals(pass1) && (pass1.length() > 8) && (pass.length() > 8))){
                    Toast.makeText(SignUpActivity.this,"Passwords are not equal!: Min of 9 characters needed!",Toast.LENGTH_LONG).show();
                    signuppass.setText(null);
                    signuppass1.setText(null);
                    pass="";
                }
                if(!TextUtils.isEmpty(email)&& !TextUtils.isEmpty(pass)){
                    progressbar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                currentUser= mAuth.getCurrentUser();
                                currentUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            signupmail.setText(null);
                                            signuppass.setText(null);
                                            signuppass1.setText(null);
                                            mAuth.signOut();
                                            Toast.makeText(SignUpActivity.this,"Check your mail for confirmation link and Click on it to verify",Toast.LENGTH_LONG).show();
                                            Intent loginIntent = new Intent(getApplicationContext(),LoginActivity.class);
                                            startActivity(loginIntent);
                                        }
                                    }
                                });

                            }
                            progressbar.setVisibility(View.INVISIBLE);
                        }
                    });
                }else{
                    Toast.makeText(SignUpActivity.this,"Empty Fields!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        currentUser=mAuth.getCurrentUser();
        if(currentUser != null){
            Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainIntent);
            finish();
        }

    }
}
