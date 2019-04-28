package mx.dbas.odissey;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    private static final String[] PLACES = new String[]{
            "Starbucks","Casa","Silla","Sanitarios"};
    AutoCompleteTextView editText;
    TextView mapText;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mapText = findViewById(R.id.textView3);
        mapText.setVisibility(View.INVISIBLE);// For Visible/Appear

        video = findViewById(R.id.videoView);
        video.setVideoPath("android.resource://" + getPackageName()+ "/" + R.raw.map);
        video.setMediaController(new MediaController(this));
        video.seekTo(1);
        this.video.setVisibility(View.INVISIBLE);

        editText = findViewById(R.id.actv);
        Button ShowEnteredValueButton = findViewById(R.id.button);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,PLACES);
        editText.setAdapter(adapter);

        ShowEnteredValueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String HoldAutocompletetextview = editText.getText().toString();

                if (HoldAutocompletetextview.equals("Starbucks")){
                    mapText.setVisibility(View.VISIBLE);
                    MainActivity.this.video.setVisibility(View.VISIBLE);
                    MainActivity.this.video.start();

                    video.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.setLooping(true);
                        }
                    });


                }
            }
        });



    }



}