package eu.laramartin.kawaiimusicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    float volume = 0.5f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer song = MediaPlayer.create(this, R.raw.rolemusic_14_the_will);

        ImageButton playButton = (ImageButton) this.findViewById(R.id.play);
        ImageButton pauseButton = (ImageButton) this.findViewById(R.id.pause);
        ImageButton downButton = (ImageButton) this.findViewById(R.id.downVolume);
        ImageButton upButton = (ImageButton) this.findViewById(R.id.upVolume);

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

        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (volume > 0){
                    volume = volume - 0.1f;
                    song.setVolume(volume, volume);
                }
            }
        });

        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (volume < 1){
                    volume = volume + 0.1f;
                    song.setVolume(volume, volume);
                }
            }
        });
    }
}



