package com.example.rams.interact;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rams.interact.utils.FontChanger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    static String userName;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    Typeface normal;
    FontChanger f;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
                Intent mainIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(mainIntent);
                finish();
       }else{
            String user_id=mAuth.getCurrentUser().getUid();
            firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        if(!task.getResult().exists()){
                            Intent setup=new Intent(MainActivity.this,SetupActivity.class);
                            startActivity(setup);
                            finish();
                        }
                        else{
                            String name=task.getResult().getString("user_name");
                            userName = name;
                            TextView namer=findViewById(R.id.username);
                            namer.setText(name);
                        }
                    }
                    else{
                        String doc=task.getException().getMessage();
                        Toast.makeText(getApplicationContext(),"Retrieve Error:"+doc,Toast.LENGTH_SHORT).show();
                    }
                }
           });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        normal = Typeface.createFromAsset(getAssets(),"font/sourceSansProRegular.ttf");
        f = new FontChanger(normal);
        f.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupViewPager(ViewPager viewPager) {


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new home(), "home");
        adapter.addFragment(new ait_core(), "aitcore");
        adapter.addFragment(new identity(), "identity");
        adapter.addFragment(new Chat(),"chat");
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.log_out) {
            mAuth.signOut();
            Intent mainIntent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(mainIntent);
            finish();
            return true;
        }
        else{
            Intent mainIntent = new Intent(getApplicationContext(),SetupActivity.class);
            startActivity(mainIntent);

        }

        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //handle the sections
      if (id == R.id.timetable) {
            Intent timetablepage = new Intent(getApplicationContext(), timetable_page.class);
            startActivity(timetablepage);

        } else if (id == R.id.UTschedule) {
            Intent UTschedulepage = new Intent(getApplicationContext(), utschedule_page.class);
            startActivity(UTschedulepage);

        } else if (id == R.id.About) {
            Intent aboutpage = new Intent(getApplicationContext(), about_page.class);
            startActivity(aboutpage);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}