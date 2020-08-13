package com.example.googleadmobintegration;

import android.content.Intent;
import android.os.Bundle;

import com.example.googleadmobintegration.Activities.BannerActivity;
import com.example.googleadmobintegration.Activities.InterstitialActivity;
import com.example.googleadmobintegration.Activities.NativeActivity;
import com.example.googleadmobintegration.Activities.RewardedActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    //Handling Button Click Events
    public void OnClick(View view) {
        Intent intent;
        switch (view.getId())
        {
            case R.id.banner:intent=new Intent(this, BannerActivity.class);break;
            case R.id.interstitial:intent=new Intent(this, InterstitialActivity.class);break;
            case R.id.rewarded:intent=new Intent(this, RewardedActivity.class);break;
            case R.id.nativeads:intent=new Intent(this, NativeActivity.class);break;
            default:return;
        }
        startActivity(intent);
    }

}