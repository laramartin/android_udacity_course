package eu.laramartin.kawaiimusicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer song = MediaPlayer.create(this, R.raw.rolemusic_14_the_will);

        Button playButton = (Button) this.findViewById(R.id.play);
        Button pauseButton = (Button) this.findViewById(R.id.pause);
        Button downButton = (Button) this.findViewById(R.id.pause);
        Button upButton = (Button) this.findViewById(R.id.pause);


        playButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                song.start();
            }
        });


        pauseButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                song.pause();
            }
        });

    }
}



