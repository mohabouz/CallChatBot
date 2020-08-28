package com.mapps.callchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class WaitingActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    String callType;

    private AdView adView;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        adView = new AdView(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();

        interstitialAd = new InterstitialAd(getBaseContext(), "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID");
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


        callType = getIntent().getStringExtra(MainActivity.CALL_TYPE);
        final TextView incomingCall = findViewById(R.id.incoming_call);
        ImageView acceptButton = findViewById(R.id.accept_button);
        ImageView refuseButton = findViewById(R.id.refuse_button);

        int ringingTone;

        if (callType.equals(MainActivity.VIDEO_CALL)){
            incomingCall.setText("incoming Video Call ...");
            ringingTone = R.raw.ring_video;
        } else {
            incomingCall.setText("incoming Call ...");
            ringingTone = R.raw.ring;
        }

        mediaPlayer = MediaPlayer.create(this, ringingTone);
        mediaPlayer.start();

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (callType.equals(MainActivity.VIDEO_CALL)) {
                    intent = new Intent(getBaseContext(), VideoCallActivity.class);
                } else {
                    intent = new Intent(getBaseContext(), CallActivity.class);
                }
                startActivity(intent);

                if(MainActivity.CLICKS_COUNTER%MainActivity.CLICK_THRESHOLD == 0){
                    interstitialAd.loadAd();
                }

                MainActivity.CLICKS_COUNTER++;
                finish();
            }
        });

        refuseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        mediaPlayer.stop();
        super.onDestroy();



    }
}
