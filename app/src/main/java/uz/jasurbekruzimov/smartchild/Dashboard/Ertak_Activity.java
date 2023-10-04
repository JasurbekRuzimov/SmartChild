package uz.jasurbekruzimov.smartchild.Dashboard;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import uz.jasurbekruzimov.smartchild.R;

public class Ertak_Activity extends AppCompatActivity {

    LinearLayout backHome;
    LinearLayout ertak1;
    LinearLayout ertak2;
    TextView playingNameId;

    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    SeekBar seekBar;
    Button toggleButton;
    boolean isPlaying = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ertak);

        ertak1 = findViewById(R.id.ertak1);
        ertak2 = findViewById(R.id.ertak2);
        playingNameId = findViewById(R.id.playingNameId);
        backHome = findViewById(R.id.backHomeErtak);
        seekBar = findViewById(R.id.seekBar);
        toggleButton = findViewById(R.id.toggleButton);

        backHome.setOnClickListener(v -> finish());

        toggleButton.setOnClickListener(v -> toggleAudio());

        ertak1.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.abror_dostov_arazingdan, "O'zbek Xalq Ertaklari");
        });

        ertak2.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.sherali_jorayev_bandaman, "Odamtoy");
        });

        // SeekBar o'zgartirilganda amalga oshiriladigan kod
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null) {
                    int newPosition = progress * mediaPlayer.getDuration() / 100;
                    mediaPlayer.seekTo(newPosition);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // SeekBar bosilganda
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // SeekBar qo'ymay olib tashlanib qolganida
            }
        });

        // Ovoz ijrosini o'zgartirish vaqtini aniqlash
        Runnable updateSeekBar = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    int totalDuration = mediaPlayer.getDuration();
                    seekBar.setProgress((currentPosition * 100) / totalDuration);
                    handler.postDelayed(this, 1000);
                }
            }
        };

        handler.postDelayed(updateSeekBar, 1000);
    }

    private void toggleAudio() {
        if (mediaPlayer != null) {
            if (isPlaying) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
            isPlaying = !isPlaying;
            updateToggleButton();
        }
    }

    private void updateToggleButton() {
        if (isPlaying) {
            toggleButton.setText("Pause");
        } else {
            toggleButton.setText("Play️");
        }
    }

    private void playAudio(int audioResId, String ertakName) {
        mediaPlayer = MediaPlayer.create(this, audioResId);
        mediaPlayer.start();
        isPlaying = true;
        updateToggleButton();
        playingNameId.setText(ertakName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
