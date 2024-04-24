package uz.jasurbekruzimov.smartchild.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import uz.jasurbekruzimov.smartchild.R;

public class Splash1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(Splash1.this, Splash_Screen_activity.class));
            finish();
        }, 2000);

    }
}