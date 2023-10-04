package uz.jasurbekruzimov.smartchild.Game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import uz.jasurbekruzimov.smartchild.R;


public class Oyinlar_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyinlar);

    }

    public void StartGame(View view) {
        Intent intent = new Intent(Oyinlar_Activity.this, StartGame_Activity.class);
        startActivity(intent);
        finish();
    }
}