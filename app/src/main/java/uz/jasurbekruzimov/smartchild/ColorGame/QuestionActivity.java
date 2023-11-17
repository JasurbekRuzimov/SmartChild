package uz.jasurbekruzimov.smartchild.ColorGame;

import androidx.annotation.NonNull;
import androidx.annotation.OpenForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import uz.jasurbekruzimov.smartchild.ColorGame.Models.QuestionModels;
import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.databinding.ActivityQuestionBinding;

public class QuestionActivity extends AppCompatActivity {

    ArrayList<QuestionModels> list = new ArrayList<>();
    private int count = 0;
    private int position = 0;
    private int score = 0;
    CountDownTimer timer;

    ActivityQuestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String setName = getIntent().getStringExtra("Bo'limlar ro'yxati");

        if (setName.equals("1-bosqich")) {
            setOne();
        } else if (setName.equals("2-bosqich")) {
            setTwo();
        }

        for (int i = 0; i < 4; i++) {
            binding.optionContainer.getChildAt(i).setOnClickListener(v -> checkAnswer((Button) v));
        }
        playAnimation(binding.question, 0, String.valueOf(list.get(position).getQuestion()));


        binding.btnNext.setOnClickListener(v -> {
            binding.btnNext.setEnabled(false);
            binding.btnNext.setAlpha((float) 0.3);
            enabledOption(true);
            position++;

            if (position == list.size()) {
                Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
                intent.putExtra("Natija", score);
                intent.putExtra("Umumiy", list.size());
                startActivity(intent);
                finish();
                return;
            }
            count = 0;
            playAnimation(binding.question, 0, String.valueOf(list.get(position).getQuestion()));
        });
    }

    private void playAnimation(View view, int value, String data) {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(300).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {

                        if (value == 0 && count < 4) {
                            String opinion = "";

                            if (count == 0) {
                                opinion = list.get(position).getOptionA();
                            } else if (count == 1) {
                                opinion = list.get(position).getOptionB();
                            } else if (count == 2) {
                                opinion = list.get(position).getOptionC();
                            } else if (count == 3) {
                                opinion = list.get(position).getOptionD();
                            }
                            playAnimation(binding.optionContainer.getChildAt(count), 0, opinion);
                            count++;
                        }
                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {
                        if (value == 0) {
                            try {
                                ((TextView) view).setText(data);
                                binding.totalQuestion.setText(position + 1 + "/" + list.size());
                            } catch (Exception e) {
                                ((Button) view).setText(data);
                            }
                            view.setTag(data);
                            playAnimation(view, 1, data);
                        }
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                });

    }

    private void enabledOption(boolean enable) {
        for (int i = 0; i < 4; i++) {
            binding.optionContainer.getChildAt(i).setEnabled(enable);
            if (enable) {
                binding.optionContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opt);
            }
        }

    }

    private void checkAnswer(Button selectedOpinion) {
        binding.btnNext.setEnabled(true);
        binding.btnNext.setAlpha(1);

        if (selectedOpinion.getText().toString().equals(list.get(position).getCorrectAnswer())) {
            score++;
            selectedOpinion.setBackgroundColor(R.drawable.correct_answ);
        } else {
            selectedOpinion.setBackgroundColor(R.drawable.wrong_answ);

            Button correctOpinion = (Button) binding.optionContainer.findViewWithTag(list.get(position).getCorrectAnswer());
        }

    }

    private void setTwo() {
        list.add(new QuestionModels("Savol-1", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-1", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-1", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-1", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-1", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-1", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));

    }

    private void setOne() {
        list.add(new QuestionModels("Savol-2", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-2", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-2", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-2", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-1", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));
        list.add(new QuestionModels("Savol-1", "Qora", "Oq", "Jigarrang", "Yashil", "Jigarrang"));

    }


}