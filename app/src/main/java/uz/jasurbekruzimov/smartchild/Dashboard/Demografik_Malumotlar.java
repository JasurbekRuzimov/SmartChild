package uz.jasurbekruzimov.smartchild.Dashboard;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Objects;

import uz.jasurbekruzimov.smartchild.DataBase.DBHelper;
import uz.jasurbekruzimov.smartchild.R;


public class Demografik_Malumotlar extends AppCompatActivity {
    ImageView backHome;
    Button addbaby;
    TextInputLayout Ismi;
    TextInputLayout Familiyasi;


    int day, month, year;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demografik_malumotlar);

        // id larni e'lon qilish va tanlash

        Ismi = findViewById(R.id.ismi);
        Familiyasi = findViewById(R.id.familiyasi);
        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(v -> {
            finish();
        });


        addbaby = findViewById(R.id.royxatgaOlish);
        addbaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(Demografik_Malumotlar.this);
                //check isEmpty
                if (Objects.requireNonNull(Ismi.getEditText()).getText().toString().isEmpty()) {
                    Ismi.setError("Ismini kiriting");
                    return;
                }
                if (Objects.requireNonNull(Familiyasi.getEditText()).getText().toString().isEmpty()) {
                    Familiyasi.setError("Familiyasini kiriting");
                    return;
                }

                dbHelper.mahalla(Objects.requireNonNull(Ismi.getEditText()).getText().toString().trim(),
                        Objects.requireNonNull(Familiyasi.getEditText()).getText().toString().trim());

                Intent intent = new Intent(Demografik_Malumotlar.this, MainActivity.class);
                startActivity(intent);
                finish();

            }

        });


    }


}