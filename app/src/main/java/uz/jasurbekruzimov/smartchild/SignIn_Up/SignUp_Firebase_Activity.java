package uz.jasurbekruzimov.smartchild.SignIn_Up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

import uz.jasurbekruzimov.smartchild.DataBase.UserModel;
import uz.jasurbekruzimov.smartchild.databinding.ActivitySignUpFirebaseBinding;


public class SignUp_Firebase_Activity extends AppCompatActivity {
    ActivitySignUpFirebaseBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpFirebaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        progressDialog = new ProgressDialog(this);

        binding.signUpButtonFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Objects.requireNonNull(binding.emailIdFairbase.getEditText()).getText().toString();
                if (email.isEmpty()) {
                    binding.emailIdFairbase.setError("Emailni kiriting !");
                    return;
                }
                String phoneNumber = Objects.requireNonNull(binding.phoneNumberIdFirebase.getEditText()).getText().toString();
                if (phoneNumber.isEmpty()) {
                    binding.phoneNumberIdFirebase.setError("Telefon raqam kiriting !");
                    return;
                }
                String password = Objects.requireNonNull(binding.passwordIdFairbase.getEditText()).getText().toString();
                if (password.isEmpty()) {
                    binding.passwordIdFairbase.setError("Parolni kiriting !");
                    return;
                }

                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(SignUp_Firebase_Activity.this, SignIn_Firebase_Activity.class));
                                progressDialog.cancel();

                                firebaseFirestore.collection("User")
                                        .document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                        .set(new UserModel( email,password,phoneNumber));

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SignUp_Firebase_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                progressDialog.cancel();
                            }
                        });


            }
        });
        binding.alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp_Firebase_Activity.this, SignIn_Firebase_Activity.class));
                finish();
            }
        });

        binding.alreadyHaveAnAccount1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp_Firebase_Activity.this, SignIn_Firebase_Activity.class));
                finish();
            }
        });


    }
}


