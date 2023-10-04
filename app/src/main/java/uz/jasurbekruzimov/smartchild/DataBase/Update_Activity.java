package uz.jasurbekruzimov.smartchild.DataBase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Objects;

import uz.jasurbekruzimov.smartchild.Dashboard.Natijalar_Activity;
import uz.jasurbekruzimov.smartchild.R;


public class Update_Activity extends AppCompatActivity {

    LinearLayout backHome;
    Button addbaby, delete_button;
    TextInputLayout Ismi;
    TextInputLayout Familiyasi;

    String id, ismi, familiyasi;
    int day, month, year;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Ismi = findViewById(R.id.ismi_update);
        Familiyasi = findViewById(R.id.familiyasi_update);
        delete_button = findViewById(R.id.royxatgaOlish_delete);

        backHome = findViewById(R.id.backHome1);
        backHome.setOnClickListener(v -> {
            finish();
        });


        addbaby = findViewById(R.id.royxatgaOlish_update);
        getAndSetIntentData();

        addbaby.setOnClickListener(v -> {
            DBHelper myDB = new DBHelper(Update_Activity.this);
            ismi = Objects.requireNonNull(Ismi.getEditText()).getText().toString().trim();
            if (ismi.isEmpty()) {
                Ismi.setError("Ismingizni kiriting");
                return;
            }
            familiyasi = Objects.requireNonNull(Familiyasi.getEditText()).getText().toString().trim();
            if (familiyasi.isEmpty()) {
                Familiyasi.setError("Familiyangizni kiriting");
                return;
            }
            myDB.updateData(id, ismi, familiyasi);
            Intent intent = new Intent(Update_Activity.this, Natijalar_Activity.class);
            startActivity(intent);
            finish();
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }

        });


    }


    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("ismi") && getIntent().hasExtra("familiyasi")) {
            // Getting Data from Intent
            id = getIntent().getStringExtra("id");
            ismi = getIntent().getStringExtra("ismi");
            familiyasi = getIntent().getStringExtra("familiyasi");
            Objects.requireNonNull(Ismi.getEditText()).setText(ismi);
            Objects.requireNonNull(Familiyasi.getEditText()).setText(familiyasi);
            Log.println(Log.ASSERT, "id", id + ismi + familiyasi);

        } else {
            Toast.makeText(this, "Hech qanday ma'lumotlar yo'q.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(ismi + " ni o'chirish");
        builder.setMessage(ismi + " haqidagi barcha ma'lumotlarni o'chirmoqchimisiz ?");
        builder.setPositiveButton("Ha", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelper myDB = new DBHelper(Update_Activity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("Yo'q", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }

}