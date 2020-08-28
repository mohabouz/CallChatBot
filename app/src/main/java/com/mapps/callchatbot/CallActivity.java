package com.mapps.callchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mapps.callchatbot.utils.CustomRateDialog;

public class CallActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        mediaPlayer = MediaPlayer.create(this, R.raw.hero_voice);
        mediaPlayer.start();

        ImageView finishCall = findViewById(R.id.finish_call);
        finishCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.CLICKS_COUNTER++;
                finish();
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
