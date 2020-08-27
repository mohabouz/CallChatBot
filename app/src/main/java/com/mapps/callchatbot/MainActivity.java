package com.mapps.callchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static String CALL_TYPE = "CALL_TYPE";
    public static String CALL = "CALL";
    public static String VIDEO_CALL = "VIDEO_CALL";
    public static int CLICKS_COUNTER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            }
        });

        messengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ChatRoomActivity.class);
                startActivity(intent);
            }
        });


        videoCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WaitingActivity.class);
                intent.putExtra(CALL_TYPE, VIDEO_CALL);
                startActivity(intent);
            }
        });


    }
}
