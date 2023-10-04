package uz.jasurbekruzimov.smartchild.SignIn_Up;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

import uz.jasurbekruzimov.smartchild.Dashboard.MainActivity;
import uz.jasurbekruzimov.smartchild.databinding.ActivitySignInFirebaseBinding;


public class SignIn_Firebase_Activity extends AppCompatActivity {

    ActivitySignInFirebaseBinding binding;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInFirebaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        binding.signInFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Objects.requireNonNull(binding.emailFairbase.getEditText()).getText().toString();
                if (email.isEmpty()) {
                    binding.emailFairbase.setError("Emailni kiriting !");
                    return;
                }
                String password = Objects.requireNonNull(binding.passwordFairbase.getEditText()).getText().toString();
                if (password.isEmpty()) {
                    binding.passwordFairbase.setError("Parolni kiriting !");
                    return;
                }

                progressDialog.show();
                signInWithEmailAndPassword(email, password);
            }
        });

        binding.ForgotPasswordFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Objects.requireNonNull(binding.emailFairbase.getEditText()).getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText(SignIn_Firebase_Activity.this, "Iltimos, emailni kiriting!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.show();
                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                progressDialog.cancel();
                                Toast.makeText(SignIn_Firebase_Activity.this, "Parol tiklash havolasi emailingizga yuborildi!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(SignIn_Firebase_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        binding.GoToSignUpFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn_Firebase_Activity.this, SignUp_Firebase_Activity.class));
            }
        });
    }

    private void signInWithEmailAndPassword(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        // Kirish muvaffaqiyatli bo'ldi
                        saveLoginState(); // Kirish holatini saqlash
                        startActivity(new Intent(SignIn_Firebase_Activity.this, MainActivity.class));
                        finish();
                        progressDialog.cancel();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Kirishda xato bo'lsa
                        clearLoginState(); // Kirish holatini o'chirish
                        progressDialog.cancel();
                        Toast.makeText(SignIn_Firebase_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveLoginState() {
        // Kirish holatini saqlash
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    private void clearLoginState() {
        // Kirish holatini o'chirish
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.apply();
    }
}
