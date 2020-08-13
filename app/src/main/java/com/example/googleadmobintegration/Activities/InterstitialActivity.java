package com.example.googleadmobintegration.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.example.googleadmobintegration.Adapters.ImageAdapter;
import com.example.googleadmobintegration.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;

import java.util.ArrayList;

public class InterstitialActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<Integer>models= new ArrayList<>();
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        LoadModels(20);

        //Loading ad to Show
        mInterstitialAd = new InterstitialAd(InterstitialActivity.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(mlistener);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        //Setting up Viewpager for Sliding images
        viewPager2=findViewById(R.id.viewpager);
        viewPager2.setAdapter(new ImageAdapter(models));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if(position%5==0 && mInterstitialAd.isLoaded())
                {
                    mInterstitialAd.show();

                }

            }
        });
    }
    AdListener mlistener= new AdListener(){
        @Override
        public void onAdClosed() {
            // Load the next interstitial.
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }

        @Override
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Toast.makeText(InterstitialActivity.this,"Ad Failed to Load",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdLoaded() {
            Toast.makeText(InterstitialActivity.this,"Ad Loaded",Toast.LENGTH_SHORT).show();
        }
    };

    void LoadModels(int size)
    {
     for(int i=0;i<size;i++)
     {
         int id=(i%2==0)?R.drawable.img1:R.drawable.img2;
         models.add(id);
     }
    }



}