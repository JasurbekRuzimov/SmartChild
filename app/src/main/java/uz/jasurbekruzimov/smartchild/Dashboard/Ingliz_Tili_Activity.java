package uz.jasurbekruzimov.smartchild.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.LimitExceededException;
import android.view.View;
import android.widget.LinearLayout;

import uz.jasurbekruzimov.smartchild.R;


public class Ingliz_Tili_Activity extends AppCompatActivity {

    LinearLayout alphabet;
    LinearLayout word;
    LinearLayout backHome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingliz_tili);

        backHome = findViewById(R.id.backHomeInglizTili);

        backHome.setOnClickListener(v -> {
            finish();
        });

        alphabet = findViewById(R.id.alphabet);
        word = findViewById(R.id.word);

        alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ingliz_Tili_Activity.this, Alifbe_Activity.class);
                startActivity(intent);
            }
        });

        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ingliz_Tili_Activity.this, Alifbe_Activity.class);
                startActivity(intent);
            }
        });

    }
}