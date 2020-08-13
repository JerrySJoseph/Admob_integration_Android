package com.example.googleadmobintegration.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.googleadmobintegration.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class RewardedActivity extends AppCompatActivity {

    private RewardedAd rewardedAd;
    int points=0;
    TextView points_tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rewarded);
        points_tv=findViewById(R.id.points);
        btn=findViewById(R.id.btn);
        points_tv.setText("Points: "+points);
        setBtnLoading(true);
        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }

    public void ShowAD(View view) {
        if(rewardedAd.isLoaded())
        {
            rewardedAd.show(this,adCallback);
        }
    }
    RewardedAdCallback adCallback=new RewardedAdCallback() {
        @Override
        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
            points+=rewardItem.getAmount();
            points_tv.setText("Points: "+points);
        }

        @Override
        public void onRewardedAdClosed() {
            setBtnLoading(true);
            rewardedAd = new RewardedAd(RewardedActivity.this,
                    "ca-app-pub-3940256099942544/5224354917");
            rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        }
    };

    RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
        @Override
        public void onRewardedAdLoaded() {
            setBtnLoading(false);
            Toast.makeText(RewardedActivity.this,"Ad Loaded",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedAdFailedToLoad(LoadAdError adError) {
            Toast.makeText(RewardedActivity.this,"Ad Failed to Load",Toast.LENGTH_SHORT).show();
        }
    };
    public void setBtnLoading(boolean a)
    {
     if(a)
     {
         btn.setEnabled(false);
         btn.setText("Loading Ads...");
     }
     else
     { btn.setEnabled(true);
         btn.setText("Show Rewarded Ad");

     };
    }
}