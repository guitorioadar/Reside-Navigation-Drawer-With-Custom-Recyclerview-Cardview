package com.vaidoos.guitorio.customnavigationdrawer;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {

    FrameLayout fragmentContainer, layoutContainer;

    homeFragment homeFrag;

    Boolean NavOpen = false;

    private TextView tvCreditCards,tvNameUser,tvLocationName,tvBills,tvSmallLoad,tvInformation,tvSetUp,tvSignOut;

    private Activity activity;

    private Toolbar toolbar;

    private int height;

    private CircleImageView circleImageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

       /* Toolbar.LayoutParams params = (Toolbar.LayoutParams) toolbar.getLayoutParams();

        params.setMargins(0,63,0,0);

        toolbar.setLayoutParams(params);*/

        toolbar.setPadding(50,getStatusBarHeight(),0,0);

        setSupportActionBar(toolbar);



        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        circleImageView = findViewById(R.id.imageViewProfile);


        tvNameUser =(TextView) findViewById(R.id.tvNameUser);
        tvLocationName =(TextView) findViewById(R.id.tvLocationName);
        tvCreditCards =(TextView) findViewById(R.id.tvCreditCards);
        tvBills =(TextView) findViewById(R.id.tvBills);
        tvSmallLoad =(TextView) findViewById(R.id.tvSmallLoad);
        tvInformation =(TextView) findViewById(R.id.tvInformation);
        tvSetUp =(TextView) findViewById(R.id.tvSetUp);
        tvSignOut =(TextView) findViewById(R.id.tvSignOut);

        fragmentContainer = (FrameLayout) findViewById(R.id.fragmentContainer);
        layoutContainer = (FrameLayout) findViewById(R.id.layoutContainer);

        homeFrag = new homeFragment();

        setfragment(homeFrag);



    }

    private void setfragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,fragment,"Hello");
        fragmentTransaction.commit();

    }

    public void toggleNavBar(View view) {

        if(NavOpen){
            layoutContainer.animate().scaleX(1f).scaleY(1f).translationX(0).translationY(0).getStartDelay();

            //getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            NavOpen = false;
        }else {
            layoutContainer.animate().scaleX(0.8f).scaleY(0.8f).translationX(600).getStartDelay();
            //handleAnimation(view);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_resource);
            //animation.setInterpolator(new AccelerateDecelerateInterpolator());

            //circleImageView.animate().alpha(0).alphaBy(1).translationY(0).translationYBy(300).getStartDelay();

            //tvNameUser,tvLocationName,tvBills,tvSmallLoad,tvInformation,tvSetUp,tvSignOut

            circleImageView.startAnimation(animation);
            tvNameUser.startAnimation(animation);
            tvLocationName.startAnimation(animation);
            tvCreditCards.startAnimation(animation);
            tvBills.startAnimation(animation);
            tvSmallLoad.startAnimation(animation);
            tvInformation.startAnimation(animation);
            tvSetUp.startAnimation(animation);
            tvSignOut.startAnimation(animation);


            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


            NavOpen = true;



            //StatusBarUtil.setTransparent(activity);

            /*UltimateBar. newTransparentBuilder ()
                    .statusColor ( Color . TRANSPARENT )         // Status Bar Color
                    .statusAlpha ( 45 )                // Status Bar Transparency
                    //.applyNav ( true )                  // Whether to apply to navigation bar
                    //.navColor ( Color . GREEN )           // Navigation Bar Color
                    //.navAlpha ( 100 )                   // Navigation bar transparency
                    .build ( this )
                    .apply();*/

            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //window.setStatusBarColor(ContextCompat.getColor(getApplication(),R.color.lightGray));
                window.setStatusBarColor(Color.parseColor("#99ffffff"));

                *//*View decor = getWindow().getDecorView();
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);*//*
            } else {
                // We want to change tint color to white again.
                // You can also record the flags in advance so that you can turn UI back completely if
                // you have set other flags before, such as translucent or full screen.
                View decor = getWindow().getDecorView();
                decor.setSystemUiVisibility(0);
            }*/


        }

    }

    public void callProfile(View view) {
        toggleNavBar(view);
        changeFragment("CardDetail");
    }

    public void callMessages(View view) {
        toggleNavBar(view);
        changeFragment("Messages");
    }

    public void callNotification(View view) {
        toggleNavBar(view);
        changeFragment("Notifications");
    }

    public void callEvents(View view) {
        toggleNavBar(view);
        changeFragment("Events");
    }


    private void changeFragment(String string) {
        Fragment myf = null;

        switch (string){
            case "CardDetail": {
                myf = new homeFragment();
                break;
            }

            case "Messages": {
                myf = new messageFragment();
                break;
            }

            case "Notifications": {
                myf = new notificationFragment();
                break;
            }

            case "Events": {
                myf = new eventFragment();
            }

        }
        setfragment(myf);
    }

    public void handleAnimation(View view){

        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(tvCreditCards,"Y",5f);
        objectAnimatorY.setDuration(1000);

        ObjectAnimator alpahAnimation = ObjectAnimator.ofFloat(tvCreditCards,View.ALPHA,0.0f,1.0f);
        alpahAnimation.setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorY,alpahAnimation);
        animatorSet.start();


    }



    private int getStatusBarHeight() {
        int height;

        Resources myResources = getResources();
        int idStatusBarHeight = myResources.getIdentifier(
                "status_bar_height", "dimen", "android");
        if (idStatusBarHeight > 0) {
            height = getResources().getDimensionPixelSize(idStatusBarHeight);
            Toast.makeText(this,
                    "Status Bar Height = " + height,
                    Toast.LENGTH_LONG).show();
        }else{
            height = 0;
            Toast.makeText(this,
                    "Resources NOT found",
                    Toast.LENGTH_LONG).show();
        }

        return height;
    }


}
