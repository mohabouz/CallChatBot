package com.mapps.callchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.mapps.callchatbot.utils.CustomRateDialog;

public class MainActivity extends AppCompatActivity {

    public static String CALL_TYPE = "CALL_TYPE";
    public static String CALL = "CALL";
    public static String VIDEO_CALL = "VIDEO_CALL";
    public static int CLICKS_COUNTER = 0;
    public static int CLICK_THRESHOLD = 2;
    private float ratingValue;

    private NativeAd nativeAd;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudienceNetworkAds.initialize(this);


        nativeAd = new NativeAd(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID");
        nativeAd.setAdListener(new NativeAdListener(){

            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
                View adView = NativeAdView.render(MainActivity.this, nativeAd);
                LinearLayout nativeAdContainer = (LinearLayout) findViewById(R.id.native_container);
                nativeAdContainer.addView(adView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 800));
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });
        nativeAd.loadAd();

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

        Button callButton = findViewById(R.id.call_button);
        Button messengerButton = findViewById(R.id.messenger_button);
        Button videoCallButton = findViewById(R.id.video_call_button);
        ImageView rateButton = findViewById(R.id.rate_button);
        ImageView moreAppsButton = findViewById(R.id.more_app_button);
        ImageView shareButton = findViewById(R.id.share_button);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WaitingActivity.class);
                intent.putExtra(CALL_TYPE, CALL);
                startActivity(intent);
                if(CLICKS_COUNTER%CLICK_THRESHOLD == 0){
                    interstitialAd.loadAd();
                }
                CLICKS_COUNTER++;
            }
        });

        messengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ChatRoomActivity.class);
                startActivity(intent);
                if(MainActivity.CLICKS_COUNTER%CLICK_THRESHOLD == 0){
                    interstitialAd.loadAd();
                }
                CLICKS_COUNTER++;
            }
        });


        videoCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WaitingActivity.class);
                intent.putExtra(CALL_TYPE, VIDEO_CALL);
                startActivity(intent);
                if(MainActivity.CLICKS_COUNTER%CLICK_THRESHOLD == 0){
                    interstitialAd.loadAd();
                }
                CLICKS_COUNTER++;
            }
        });

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder popDialog = new AlertDialog.Builder(MainActivity.this);

                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                final RatingBar rating = new RatingBar(MainActivity.this);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                rating.setLayoutParams(lp);
                rating.setNumStars(5);
                rating.setStepSize(1);

                //add ratingBar to linearLayout
                linearLayout.addView(rating);


                popDialog.setIcon(android.R.drawable.btn_star_big_on);
                popDialog.setTitle("Add Rating: ");

                //add linearLayout to dailog
                popDialog.setView(linearLayout);



                rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        ratingValue = v;
                        System.out.println("Rated val:"+v);
                    }
                });

                // Button OK
                popDialog.setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(ratingValue >= 3) {
                                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                                    try {
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                                    } catch (android.content.ActivityNotFoundException anfe) {
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                                    }
                                } else {
                                    Toast.makeText(MainActivity.this , "Thank you." , Toast.LENGTH_SHORT).show();
                                }

                                dialog.dismiss();
                            }

                        })

                        // Button Cancel
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                popDialog.create();
                popDialog.show();
            }
        });

        moreAppsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MoreAppsActivity.class);
                startActivity(intent);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Check out this cool application : https://play.google.com/store/apps/details?id=" + getPackageName());
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        CustomRateDialog rateDialog = new CustomRateDialog(this);
        rateDialog.showDialog();
    }

}
