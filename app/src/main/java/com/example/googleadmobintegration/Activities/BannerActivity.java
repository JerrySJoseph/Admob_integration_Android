package com.example.googleadmobintegration.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.googleadmobintegration.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class BannerActivity extends AppCompatActivity {

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Banner Ads");
        LaodAd();
    }
    public void LaodAd()
    {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.setAdListener(mlistener);
        mAdView.loadAd(adRequest);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return true;
    }

    AdListener mlistener= new AdListener(){
        @Override
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Toast.makeText(BannerActivity.this,"Ad Failed to Load",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdLoaded() {
            Toast.makeText(BannerActivity.this,"Ad Loaded",Toast.LENGTH_SHORT).show();
        }
    };
}