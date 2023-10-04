package uz.jasurbekruzimov.smartchild.NavMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import uz.jasurbekruzimov.smartchild.R;


public class AboutUs_activity extends AppCompatActivity {
    LinearLayout backHome;
    LinearLayout gitHub;
    LinearLayout telegram;
    LinearLayout instagram;
    LinearLayout linkedIn;
    LinearLayout youtube;
    LinearLayout twitter;
    TextView webSite;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(v -> {
            finish();
        });

        gitHub = findViewById(R.id.gitHub);
        gitHub.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/JasurbekRuzimov"));
            startActivity(intent);
        });

        telegram = findViewById(R.id.telegram);
        telegram.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/RuzimovDev"));
            startActivity(intent);
        });

        instagram = findViewById(R.id.instagram);
        instagram.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ruzimov_01/"));
            startActivity(intent);
        });

        linkedIn = findViewById(R.id.linkedIn);
        linkedIn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/jasurbek-ruzimov-b19234213/"));
            startActivity(intent);
        });

        youtube = findViewById(R.id.youTube);
        youtube.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/@RuzimovJasurbek?si=jlwpDdfVMTIKMTxD"));
            startActivity(intent);
        });

        twitter = findViewById(R.id.twitter);
        twitter.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/RuzimovJasurbek"));
            startActivity(intent);
        });

        webSite= findViewById(R.id.WebSite);
        webSite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jasurbekruzimov.uz"));
            startActivity(intent);
        });

    }
}