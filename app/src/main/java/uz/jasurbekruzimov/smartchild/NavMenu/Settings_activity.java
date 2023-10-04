package uz.jasurbekruzimov.smartchild.NavMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

import uz.jasurbekruzimov.smartchild.R;


public class Settings_activity extends AppCompatActivity {
    LinearLayout backHome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        backHome=findViewById(R.id.backHome);
        backHome.setOnClickListener(v -> finish());





    }

}