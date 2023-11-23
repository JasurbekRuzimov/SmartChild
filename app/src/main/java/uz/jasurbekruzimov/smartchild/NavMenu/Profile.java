package uz.jasurbekruzimov.smartchild.NavMenu;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.SignIn_Up.SignIn_Firebase_Activity;

public class Profile extends AppCompatActivity {

    ImageView backHome;
    TextView userEmail, userPassword;
    Button logOutButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logOutButton = findViewById(R.id.logOutButton);
        logOutButton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
            builder.setMessage(R.string.accountdan_chiqib_ketmoqchimisiz)
                    .setPositiveButton("Ha", (dialog, id) -> {
                        ProgressDialog progressDialog = new ProgressDialog(Profile.this);
                        progressDialog.setMessage(getString(R.string.chiqish_amalga_oshmoqda));
                        progressDialog.show();
                        FirebaseAuth.getInstance().signOut();
                        progressDialog.dismiss();
                        startActivity(new Intent(Profile.this, SignIn_Firebase_Activity.class));
                        finish();
                    })
                    .setNegativeButton("Yo'q", (dialog, id) -> dialog.dismiss());
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser != null) {
            String email = currentUser.getEmail();
            String displayName = currentUser.getDisplayName();

            userEmail = findViewById(R.id.userEmail);
            userPassword = findViewById(R.id.userPassword);

            userEmail.setText(email);
            userPassword.setText("********");
        } else {
            Toast.makeText(this, R.string.siz_avtorizatsiyadan_o_tmadingiz, Toast.LENGTH_SHORT).show();
        }

        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(v -> {
            finish();
        });

    }


}
