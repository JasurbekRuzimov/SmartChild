package uz.jasurbekruzimov.smartchild.Splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import uz.jasurbekruzimov.smartchild.Dashboard.MainActivity;
import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.SignIn_Up.SignIn_Firebase_Activity;


public class Splash_Screen_activity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (isUserLoggedIn()) {
            startActivity(new Intent(Splash_Screen_activity.this, MainActivity.class));
        } else {
            startActivity(new Intent(Splash_Screen_activity.this, SignIn_Firebase_Activity.class));
        }
        finish();
    }

    private boolean isUserLoggedIn() {
        // SharedPreferences dan foydalanuvchi kirish holatini o'qish
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }
}