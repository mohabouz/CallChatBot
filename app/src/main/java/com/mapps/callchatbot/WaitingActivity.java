package com.mapps.callchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WaitingActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    String callType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

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
        super.onDestroy();
        mediaPlayer.stop();
    }
}
