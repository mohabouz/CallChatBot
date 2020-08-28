package com.mapps.callchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.mapps.callchatbot.utils.CustomRateDialog;

public class CallActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    AdView adView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        adView = new AdView(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();

        interstitialAd = new InterstitialAd(getBaseContext(), "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID");

        mediaPlayer = MediaPlayer.create(this, R.raw.hero_voice);
        mediaPlayer.start();

        ImageView finishCall = findViewById(R.id.finish_call);
        finishCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.CLICKS_COUNTER%MainActivity.CLICK_THRESHOLD == 0){
                    interstitialAd.loadAd();
                }
                MainActivity.CLICKS_COUNTER++;
                finish();
            }
        });

        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onBackPressed() {
        CustomRateDialog rateDialog = new CustomRateDialog(this);
        rateDialog.showDialog();
    }
}
