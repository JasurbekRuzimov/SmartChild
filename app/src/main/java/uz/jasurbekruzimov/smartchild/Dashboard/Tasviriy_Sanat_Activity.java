package uz.jasurbekruzimov.smartchild.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import uz.jasurbekruzimov.smartchild.R;


public class Tasviriy_Sanat_Activity extends AppCompatActivity {

    ImageView backHome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasviriy_sanat);

        backHome = findViewById(R.id.backHomeTasviriySanat);

        backHome.setOnClickListener(v -> {
            finish();
        });

    }
}

