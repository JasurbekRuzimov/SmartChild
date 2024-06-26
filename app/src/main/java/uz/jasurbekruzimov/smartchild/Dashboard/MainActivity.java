package uz.jasurbekruzimov.smartchild.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import uz.jasurbekruzimov.smartchild.ColorGame.SetsActivity;
import uz.jasurbekruzimov.smartchild.NavMenu.AboutUs_activity;
import uz.jasurbekruzimov.smartchild.NavMenu.FAQ_activity;
import uz.jasurbekruzimov.smartchild.NavMenu.Profile;
import uz.jasurbekruzimov.smartchild.NavMenu.Settings_activity;
import uz.jasurbekruzimov.smartchild.NavMenu.Support_Activity;
import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.ShapesGame.Shapes;
import uz.jasurbekruzimov.smartchild.SignIn_Up.SignIn_Firebase_Activity;


public class MainActivity extends AppCompatActivity {
    ImageView navMenu, profile;
    TextView KinderGardenName, BolalarSoni;
    LinearLayout ertaklar,tasviriySanat,shakllar,ranglar, videoDars;
    private boolean isMenuOpen = false;
    public boolean isBackPressed = false;

    @SuppressLint({"MissingInflatedId", "NonConstantResourceId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KinderGardenName = findViewById(R.id.appName);

        ertaklar = findViewById(R.id.Ertaklar);
        tasviriySanat = findViewById(R.id.TasviriySanat);
        ranglar = findViewById(R.id.ranglar);
        shakllar = findViewById(R.id.shakllar);
        profile = findViewById(R.id.profile);
        videoDars = findViewById(R.id.videoDars);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        navMenu = findViewById(R.id.imagemenu);
        navMenu.setOnClickListener(v -> {
            Animation animation;
            if (isMenuOpen) {
                animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            } else {
                animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            }
            animation.setDuration(300);
            animation.setFillAfter(true);
            navMenu.startAnimation(animation);
            drawerLayout.openDrawer(GravityCompat.START);
            isMenuOpen = !isMenuOpen;
        });
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            item.setChecked(true);
            switch (item.getItemId()) {
                case R.id.nav_profile:
                    Intent intent = new Intent(MainActivity.this, Profile.class);
                    startActivity(intent);
                    break;
                case R.id.nav_settings:
                    Intent intent1 = new Intent(MainActivity.this, Settings_activity.class);
                    startActivity(intent1);
                    break;
                case R.id.nav_share1:
                    Intent intent2 = new Intent(Intent.ACTION_SEND);
                    intent2.setType("text/plain");
                    String shareBody = "https://play.google.com/store/apps/details?id=SmartChild.uz";
                    String shareSub = "Kindergarten";
                    intent2.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    intent2.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(intent2, "Share Using"));
                    break;
                case R.id.nav_support:
                    Intent intent3 = new Intent(MainActivity.this, Support_Activity.class);
                    startActivity(intent3);
                    break;
                case R.id.nav_FAQ:
                    Intent intent4 = new Intent(MainActivity.this, FAQ_activity.class);
                    startActivity(intent4);
                    break;
                case R.id.nav_AboutUs:
                    Intent intent5 = new Intent(MainActivity.this, AboutUs_activity.class);
                    startActivity(intent5);
                    break;
            }
            return false;
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Profile.class);
            startActivity(intent);
        });

        ertaklar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ertak_Activity.class);
            startActivity(intent);
        });

        tasviriySanat.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Tasviriy_Sanat_Activity.class);
            startActivity(intent);
        });

        ranglar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SetsActivity.class);
            startActivity(intent);
        });

        shakllar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Shapes.class);
            startActivity(intent);
        });

        videoDars.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VideoDars.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Firebase Authentication orqali foydalanuvchi o'zgartirilganligini tekshirish
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            // Foydalanuvchi tizimdan chiqqan bo'lsa, kirish oynasiga o'tish
            startActivity(new Intent(MainActivity.this, SignIn_Firebase_Activity.class));
            finish(); // Aktivitani yopish
        }
    }

    public void onBackPressed() {
        if (isBackPressed) {
            super.onBackPressed();
        } else {
            isBackPressed = true;
            Toast.makeText(this, " Chiqish uchun 🔙 ni ikki marta bosing ", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(() -> isBackPressed = false, 2000);
        }
    }

    public static class Counter {
        private final int counter;
        private final TextView textView;
        private CountDownTimer countDownTimer;

        public Counter(int counter, TextView textView) {
            this.counter = counter;
            this.textView = textView;
        }

        public void start() {
            countDownTimer = new CountDownTimer(counter, 1) {
                public void onTick(long millisUntilFinished) {
                    textView.setText(String.valueOf(counter - (int) (millisUntilFinished)));
                }

                public void onFinish() {
                    textView.setText(String.valueOf(counter));
                }
            }.start();
        }

        public void stop() {
            countDownTimer.cancel();
        }


    }

}