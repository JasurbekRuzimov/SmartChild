package uz.jasurbekruzimov.smartchild.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import uz.jasurbekruzimov.smartchild.Game.HarfInfoDialog;
import uz.jasurbekruzimov.smartchild.R;

public class Alifbe_Activity extends AppCompatActivity {

    ImageView backHome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alifbe);

        backHome = findViewById(R.id.backHomeAlifbe);

        backHome.setOnClickListener(v -> {
            finish();
        });


    }

    public void CallA(View view) {
        // Harf ma'lumotlari
        int harfImageResource = R.drawable.a; // Rasm resursi
        String harfInfoText = "A dan boshlanadigan hayvon - AYIQ";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.a);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }


    public void CallB(View view) {
        int harfImageResource = R.drawable.b; // Rasm resursi
        String harfInfoText = "B dan boshlanadigan hayvon - BEGEMOT";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.b);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallD(View view) {
        int harfImageResource = R.drawable.d; // Rasm resursi
        String harfInfoText = "D dan boshlanadigan hayvon - DINAZAVR";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.d);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallE(View view) {
        int harfImageResource = R.drawable.e; // Rasm resursi
        String harfInfoText = "E dan boshlanadigan hayvon - ECHKI";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.e);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallF(View view) {
        int harfImageResource = R.drawable.f; // Rasm resursi
        String harfInfoText = "F dan boshlanadigan hayvon - FIL";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.f);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallG(View view) {
        int harfImageResource = R.drawable.g; // Rasm resursi
        String harfInfoText = "G dan boshlanadigan hayvon - GEPART";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.g);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallH(View view) {
        int harfImageResource = R.drawable.h; // Rasm resursi
        String harfInfoText = "H dan boshlanadigan hayvon - HO'TIK";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.h);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallI(View view) {
        int harfImageResource = R.drawable.i; // Rasm resursi
        String harfInfoText = "I dan boshlanadigan hayvon - ILON";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.i);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallJ(View view) {
        int harfImageResource = R.drawable.j; // Rasm resursi
        String harfInfoText = "J dan boshlanadigan hayvon - JIRAFA";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.j);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallK(View view) {
        int harfImageResource = R.drawable.k; // Rasm resursi
        String harfInfoText = "K dan boshlanadigan hayvon - KIYIK";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.k);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallL(View view) {
        int harfImageResource = R.drawable.l; // Rasm resursi
        String harfInfoText = "L dan boshlanadigan hayvon - LAYLAK";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.l);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallM(View view) {
        int harfImageResource = R.drawable.m; // Rasm resursi
        String harfInfoText = "M dan boshlanadigan hayvon - MAYMUN";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.m);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallN(View view) {
        int harfImageResource = R.drawable.n; // Rasm resursi
        String harfInfoText = "N dan boshlanadigan hayvon - NINACHI";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.n);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallO(View view) {
        int harfImageResource = R.drawable.o; // Rasm resursi
        String harfInfoText = "O dan boshlanadigan hayvon - OQ QUSH";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.o);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallP(View view) {
        int harfImageResource = R.drawable.p; // Rasm resursi
        String harfInfoText = "P dan boshlanadigan hayvon - PANDA";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.p);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallQ(View view) {
        int harfImageResource = R.drawable.q; // Rasm resursi
        String harfInfoText = "Q dan boshlanadigan hayvon - QUYON";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.q);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallR(View view) {
        int harfImageResource = R.drawable.r; // Rasm resursi
        String harfInfoText = "R dan boshlanadigan hayvon - RABBIT";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.r);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallS(View view) {
        int harfImageResource = R.drawable.s; // Rasm resursi
        String harfInfoText = "S dan boshlanadigan hayvon - SIGIR";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.s);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }


    public void CallT(View view) {
        int harfImageResource = R.drawable.t; // Rasm resursi
        String harfInfoText = "A dan boshlanadigan hayvon - TOYCHOQ";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.t);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallU(View view) {
        int harfImageResource = R.drawable.u; // Rasm resursi
        String harfInfoText = "U dan boshlanadigan hayvon - UKKI";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.u);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallV(View view) {
        int harfImageResource = R.drawable.v; // Rasm resursi
        String harfInfoText = "V dan boshlanadigan buyum - VELOSIPED";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.v);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallW(View view) {
        int harfImageResource = R.drawable.w; // Rasm resursi
        String harfInfoText = "W dan boshlanadigan hayvon - WOLF";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.w);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallX(View view) {
        int harfImageResource = R.drawable.x; // Rasm resursi
        String harfInfoText = "X dan boshlanadigan hayvon - XO'ROZ";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.x);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallY(View view) {
        int harfImageResource = R.drawable.y; // Rasm resursi
        String harfInfoText = "Y dan boshlanadigan hayvon - YO'LBARS";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.y);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallZ(View view) {
        int harfImageResource = R.drawable.z; // Rasm resursi
        String harfInfoText = "Z dan boshlanadigan hayvon - ZEBRA";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.z);
        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallG2(View view) {
        int harfImageResource = R.drawable.g2; // Rasm resursi
        String harfInfoText = "G' dan boshlanadigan hayvon - G'oz";

//        final MediaPlayer mp = MediaPlayer.create(this, R.raw.z);
//        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();

    }

    public void CallO2(View view) {
        int harfImageResource = R.drawable.o2; // Rasm resursi
        String harfInfoText = "O' dan boshlanadigan hayvon - O'rdak";

//        final MediaPlayer mp = MediaPlayer.create(this, R.raw.z);
////        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallSH(View view) {
        int harfImageResource = R.drawable.sh; // Rasm resursi
        String harfInfoText = "SH dan boshlanadigan hayvon - Sher";

//        final MediaPlayer mp = MediaPlayer.create(this, R.raw.z);
//        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallCH(View view) {
        int harfImageResource = R.drawable.ch; // Rasm resursi
        String harfInfoText = "Ch dan boshlanadigan hayvon - Chivin";

//        final MediaPlayer mp = MediaPlayer.create(this, R.raw.z);
//        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallNg(View view) {
        int harfImageResource = R.drawable.ng; // Rasm resursi
        String harfInfoText = "ng qatnashgan harf - Bodring ";

//        final MediaPlayer mp = MediaPlayer.create(this, R.raw.z);
//        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }

    public void CallTutuqBelgi(View view) {
        int harfImageResource = R.drawable.tutuqbelgisi; // Rasm resursi
        String harfInfoText = "Tutuq belgisi";

//        final MediaPlayer mp = MediaPlayer.create(this, R.raw.z);
//        mp.start();

        HarfInfoDialog harfInfoDialog = new HarfInfoDialog(this, harfImageResource, harfInfoText);
        harfInfoDialog.show();
    }
}