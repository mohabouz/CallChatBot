package com.mapps.callchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.mapps.callchatbot.utils.CustomRateDialog;

public class ChatRoomActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout msgr1;
    LinearLayout msg1;
    TextView msg1Btn;
    LinearLayout msg2;
    LinearLayout msgr2;
    TextView msg2Btn;
    LinearLayout msg3;
    LinearLayout msgr3;
    TextView msg3Btn;
    LinearLayout msg4;
    LinearLayout msgr4;
    TextView msg4Btn;
    LinearLayout msg5;
    LinearLayout msgr5;
    TextView msg5Btn;
    LinearLayout msg6;
    LinearLayout msgr6;
    TextView msg6Btn;
    LinearLayout msg7;
    LinearLayout msgr7;
    TextView msg7Btn;
    LinearLayout msg8;
    LinearLayout msgr8;
    TextView msg8Btn;
    LinearLayout msg9;
    LinearLayout msgr9;
    TextView msg9Btn;
    LinearLayout msg10;
    LinearLayout msgr10;
    TextView msg10Btn;
    LinearLayout msg11;
    LinearLayout msgr11;
    TextView msg11Btn;
    LinearLayout msg12;
    LinearLayout msgr12;
    TextView msg12Btn;
    LinearLayout msg13;
    LinearLayout msgr13;
    TextView msg13Btn;
    LinearLayout msg14;
    LinearLayout msgr14;
    TextView msg14Btn;
    LinearLayout msg15;
    LinearLayout msgr15;
    TextView msg15Btn;

    ScrollView scroll;

    AdView adView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        adView = new AdView(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();

        interstitialAd = new InterstitialAd(getBaseContext(), "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID");

        adView.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(getBaseContext(), "Error: " + adError.getErrorMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
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

        ImageView callBtn = findViewById(R.id.call);
        ImageView videoCallBtn = findViewById(R.id.video_call);

        TextView restart = findViewById(R.id.restart);
        restart.setOnClickListener(this);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WaitingActivity.class);
                intent.putExtra(MainActivity.CALL_TYPE, MainActivity.CALL);
                startActivity(intent);
                if(MainActivity.CLICKS_COUNTER%MainActivity.CLICK_THRESHOLD == 0){
                    interstitialAd.loadAd();
                }
                MainActivity.CLICKS_COUNTER++;

            }
        });

        videoCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WaitingActivity.class);
                intent.putExtra(MainActivity.CALL_TYPE, MainActivity.VIDEO_CALL);
                startActivity(intent);
                if(MainActivity.CLICKS_COUNTER%MainActivity.CLICK_THRESHOLD == 0){
                    interstitialAd.loadAd();
                }
                MainActivity.CLICKS_COUNTER++;
            }
        });


        scroll = findViewById(R.id.scroll);

        msg1 = findViewById(R.id.mdiscussion1);
        msgr1 = findViewById(R.id.fdiscussion1);
        msg1Btn = findViewById(R.id.msg1);

        msg2 = findViewById(R.id.mdiscussion2);
        msgr2 = findViewById(R.id.fdiscussion2);
        msg2Btn = findViewById(R.id.msg2);

        msg3 = findViewById(R.id.mdiscussion3);
        msgr3 = findViewById(R.id.fdiscussion3);
        msg3Btn = findViewById(R.id.msg3);

        msg4 = findViewById(R.id.mdiscussion4);
        msgr4 = findViewById(R.id.fdiscussion4);
        msg4Btn = findViewById(R.id.msg4);

        msg5 = findViewById(R.id.mdiscussion5);
        msgr5 = findViewById(R.id.fdiscussion5);
        msg5Btn = findViewById(R.id.msg5);

        msg6 = findViewById(R.id.mdiscussion6);
        msgr6 = findViewById(R.id.fdiscussion6);
        msg6Btn = findViewById(R.id.msg6);

        msg7 = findViewById(R.id.mdiscussion7);
        msgr7 = findViewById(R.id.fdiscussion7);
        msg7Btn = findViewById(R.id.msg7);

        msg8 = findViewById(R.id.mdiscussion8);
        msgr8 = findViewById(R.id.fdiscussion8);
        msg8Btn = findViewById(R.id.msg8);

        msg9 = findViewById(R.id.mdiscussion9);
        msgr9 = findViewById(R.id.fdiscussion9);
        msg9Btn = findViewById(R.id.msg9);

        msg10 = findViewById(R.id.mdiscussion10);
        msgr10 = findViewById(R.id.fdiscussion10);
        msg10Btn = findViewById(R.id.msg10);

        msg11 = findViewById(R.id.mdiscussion11);
        msgr11 = findViewById(R.id.fdiscussion11);
        msg11Btn = findViewById(R.id.msg11);

        msg12 = findViewById(R.id.mdiscussion12);
        msgr12 = findViewById(R.id.fdiscussion12);
        msg12Btn = findViewById(R.id.msg12);

        msg13 = findViewById(R.id.mdiscussion13);
        msgr13 = findViewById(R.id.fdiscussion13);
        msg13Btn = findViewById(R.id.msg13);

        msg14 = findViewById(R.id.mdiscussion14);
        msgr14 = findViewById(R.id.fdiscussion14);
        msg14Btn = findViewById(R.id.msg14);

        msg15 = findViewById(R.id.mdiscussion15);
        msgr15 = findViewById(R.id.fdiscussion15);
        msg15Btn = findViewById(R.id.msg15);

        msg1Btn.setOnClickListener(this);
        msg2Btn.setOnClickListener(this);
        msg3Btn.setOnClickListener(this);
        msg4Btn.setOnClickListener(this);
        msg5Btn.setOnClickListener(this);
        msg6Btn.setOnClickListener(this);
        msg7Btn.setOnClickListener(this);
        msg8Btn.setOnClickListener(this);
        msg9Btn.setOnClickListener(this);
        msg10Btn.setOnClickListener(this);
        msg11Btn.setOnClickListener(this);
        msg12Btn.setOnClickListener(this);
        msg13Btn.setOnClickListener(this);
        msg14Btn.setOnClickListener(this);
        msg15Btn.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.msg1:
                msg1.setVisibility(View.VISIBLE);
                msg1Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr1.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg2:
                msg2.setVisibility(View.VISIBLE);
                msg2Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr2.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg3:
                msg3.setVisibility(View.VISIBLE);
                msg3Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr3.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg4:
                msg4.setVisibility(View.VISIBLE);
                msg4Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr4.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg5:
                msg5.setVisibility(View.VISIBLE);
                msg5Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr5.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg6:
                msg6.setVisibility(View.VISIBLE);
                msg6Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr6.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg7:
                msg7.setVisibility(View.VISIBLE);
                msg7Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr7.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg8:
                msg8.setVisibility(View.VISIBLE);
                msg8Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr8.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg9:
                msg9.setVisibility(View.VISIBLE);
                msg9Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr9.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg10:
                msg10.setVisibility(View.VISIBLE);
                msg10Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr10.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg11:
                msg11.setVisibility(View.VISIBLE);
                msg11Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr11.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg12:
                msg12.setVisibility(View.VISIBLE);
                msg12Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr12.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg13:
                msg13.setVisibility(View.VISIBLE);
                msg13Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr13.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg14:
                msg14.setVisibility(View.VISIBLE);
                msg14Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr14.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.msg15:
                msg15.setVisibility(View.VISIBLE);
                msg15Btn.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msgr15.setVisibility(View.VISIBLE);
                    }
                },1000);
                break;
            case R.id.restart:
                interstitialAd.loadAd();
                restartConversation();

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scroll.scrollTo(0, scroll.getBottom());
            }
        },1100);
//
        scroll.post(new Runnable() {
            public void run() {
                // then wait for the child of the scroll view (normally a LinearLayout) to be laid out
                scroll.getChildAt(0).post(new Runnable() {
                    public void run() {
                        // finally scroll without animation
                        scroll.scrollTo(0, scroll.getBottom());
                    }
                });
            }
        });
    }

    private void restartConversation() {
        msg1.setVisibility(View.GONE);
        msgr1.setVisibility(View.GONE);
        msg1Btn.setVisibility(View.VISIBLE);
        msg2.setVisibility(View.GONE);
        msgr2.setVisibility(View.GONE);
        msg2Btn.setVisibility(View.VISIBLE);
        msg3.setVisibility(View.GONE);
        msgr3.setVisibility(View.GONE);
        msg3Btn.setVisibility(View.VISIBLE);
        msg4.setVisibility(View.GONE);
        msgr4.setVisibility(View.GONE);
        msg4Btn.setVisibility(View.VISIBLE);
        msg5.setVisibility(View.GONE);
        msgr5.setVisibility(View.GONE);
        msg5Btn.setVisibility(View.VISIBLE);
        msg6.setVisibility(View.GONE);
        msgr6.setVisibility(View.GONE);
        msg6Btn.setVisibility(View.VISIBLE);
        msg7.setVisibility(View.GONE);
        msgr7.setVisibility(View.GONE);
        msg7Btn.setVisibility(View.VISIBLE);
        msg8.setVisibility(View.GONE);
        msgr8.setVisibility(View.GONE);
        msg8Btn.setVisibility(View.VISIBLE);
        msg9.setVisibility(View.GONE);
        msgr9.setVisibility(View.GONE);
        msg9Btn.setVisibility(View.VISIBLE);
        msg10.setVisibility(View.GONE);
        msgr10.setVisibility(View.GONE);
        msg10Btn.setVisibility(View.VISIBLE);
        msg11.setVisibility(View.GONE);
        msgr11.setVisibility(View.GONE);
        msg11Btn.setVisibility(View.VISIBLE);
        msg12.setVisibility(View.GONE);
        msgr12.setVisibility(View.GONE);
        msg12Btn.setVisibility(View.VISIBLE);
        msg13.setVisibility(View.GONE);
        msgr13.setVisibility(View.GONE);
        msg13Btn.setVisibility(View.VISIBLE);
        msg14.setVisibility(View.GONE);
        msgr14.setVisibility(View.GONE);
        msg14Btn.setVisibility(View.VISIBLE);
        msg15.setVisibility(View.GONE);
        msgr15.setVisibility(View.GONE);
        msg15Btn.setVisibility(View.VISIBLE);

    }

    @Override
    public void onBackPressed() {
        CustomRateDialog rateDialog = new CustomRateDialog(this);
        rateDialog.showDialog();
    }
}
