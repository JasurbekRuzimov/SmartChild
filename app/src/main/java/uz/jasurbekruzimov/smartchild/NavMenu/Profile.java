package uz.jasurbekruzimov.smartchild.NavMenu;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.makeramen.roundedimageview.RoundedImageView;

import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.SignIn_Up.SignIn_Firebase_Activity;
import uz.jasurbekruzimov.smartchild.Splash.Splash_Screen_activity;


public class Profile extends AppCompatActivity {

    LinearLayout backHome;
    RoundedImageView userImage;
    TextView userEmail;
    TextView userPassword;

    Button logOutButton;
    ProgressDialog progressDialog;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logOutButton = findViewById(R.id.logOutButton);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                builder.setMessage("Accountdan chiqib ketmoqchimisiz?")
                        .setPositiveButton("Ha", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Progress dialogni yaratish
                                ProgressDialog progressDialog = new ProgressDialog(Profile.this);
                                progressDialog.setMessage("Chiqish amalga oshmoqda...");
                                progressDialog.show();

                                // Foydalanuvchi chiqish
                                FirebaseAuth.getInstance().signOut();

                                // Progress dialogni yopish
                                progressDialog.dismiss();

                                // Kirish oynasiga o'tish
                                startActivity(new Intent(Profile.this, SignIn_Firebase_Activity.class));
                                finish(); // Aktivitini yopish
                            }
                        })
                        .setNegativeButton("Yo'q", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Foydalanuvchi chiqmagan
                                dialog.dismiss();
                            }
                        });
                // AlertDialog ni chiqarish
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        // Firebase Auth obyekti
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser != null) {
            // Foydalanuvchi haqida ma'lumotlarni olish
            String email = currentUser.getEmail();
            String displayName = currentUser.getDisplayName(); // Foydalanuvchi nomi

            // UI elementlariga ma'lumotlarni joylash
            userEmail = findViewById(R.id.userEmail);
            userPassword = findViewById(R.id.userPassword);

            userEmail.setText(email);
            userPassword.setText("********"); // Parolni ko'rsatmaslik uchun ******** yozish mumkin
        } else {
            // Foydalanuvchi avtorizatsiya qilmagan
            Toast.makeText(this, "Siz avtorizatsiyadan o'tmadingiz", Toast.LENGTH_SHORT).show();
        }

        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(v -> {
            finish();
        });

        userImage = findViewById(R.id.userImage);

    }




}
