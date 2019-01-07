package com.vaidoos.guitorio.customnavigationdrawer;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.vaidoos.guitorio.customnavigationdrawer.widget.AdvanceDrawerLayout;

public class NewDrawerActivity extends AppCompatActivity {

    private AdvanceDrawerLayout drawer;
    private Button btnButtonNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (AdvanceDrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        drawer.setViewScale(Gravity.START,0.9f);
        drawer.setRadius(Gravity.START, 35);
        drawer.setViewElevation(Gravity.START, 20);

        btnButtonNotification = findViewById(R.id.btnButtonNotification);

        btnButtonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(btnButtonNotification,"Clicked",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
