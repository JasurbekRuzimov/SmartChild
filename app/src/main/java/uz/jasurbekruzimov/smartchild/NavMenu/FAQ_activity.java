package uz.jasurbekruzimov.smartchild.NavMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import uz.jasurbekruzimov.smartchild.R;


public class FAQ_activity extends AppCompatActivity {
LinearLayout backHome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        backHome=findViewById(R.id.backHome);
        backHome.setOnClickListener(v -> {
            finish();
        });




    }
}