package uz.jasurbekruzimov.smartchild.NavMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import uz.jasurbekruzimov.smartchild.R;


public class Support_Activity extends AppCompatActivity {

    LinearLayout backHome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        backHome = findViewById(R.id.backHome11);
        backHome.setOnClickListener(v -> finish());



    }
}