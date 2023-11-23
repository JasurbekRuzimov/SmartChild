package uz.jasurbekruzimov.smartchild.ColorGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.color.utilities.Score;

import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {
    ActivityScoreBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityScoreBinding.inflate(getLayoutInflater()) ;
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        int totalScore = getIntent().getIntExtra("Umumiy", 0);
        int correctAnsw = getIntent().getIntExtra("Natija", 0);

        int wrong = totalScore-correctAnsw;

        binding.totalQuestions.setText(String.valueOf(totalScore));
        binding.rightAnsw.setText(String.valueOf(correctAnsw));
        binding.wrongAnsw.setText(String.valueOf(wrong));

        binding.btnRetry.setOnClickListener(v -> {
            Intent intent = new Intent(ScoreActivity.this, SetsActivity.class);
            startActivity(intent);
        });

        binding.btnQuit.setOnClickListener(v -> finish());
        binding.backHome.setOnClickListener(v -> finish());
    }
}