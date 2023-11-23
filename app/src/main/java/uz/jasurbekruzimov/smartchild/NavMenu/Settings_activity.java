package uz.jasurbekruzimov.smartchild.NavMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import uz.jasurbekruzimov.smartchild.R;

public class Settings_activity extends AppCompatActivity {
    ImageView backHome;
    private List<String> videoUrls = new ArrayList<>();
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef = storage.getReference();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(v -> finish());

    }

}
