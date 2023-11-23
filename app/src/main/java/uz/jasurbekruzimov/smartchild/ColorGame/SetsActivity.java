package uz.jasurbekruzimov.smartchild.ColorGame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Objects;

import uz.jasurbekruzimov.smartchild.ColorGame.Adapters.SetAdapter;
import uz.jasurbekruzimov.smartchild.ColorGame.Models.SetsModels;
import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.databinding.ActivitySetsBinding;

public class SetsActivity extends AppCompatActivity {
    ActivitySetsBinding binding;
    ArrayList<SetsModels> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.setsRecy.setLayoutManager(linearLayoutManager);

        list.add(new SetsModels("1 - bosqich"));
        list.add(new SetsModels("2 - bosqich"));
        list.add(new SetsModels("3 - bosqich"));
        list.add(new SetsModels("4 - bosqich"));
        list.add(new SetsModels("5 - bosqich"));
        list.add(new SetsModels("6 - bosqich"));
        list.add(new SetsModels("7 - bosqich"));
        list.add(new SetsModels("8 - bosqich"));
        list.add(new SetsModels("9 - bosqich"));
        list.add(new SetsModels("10 - bosqich"));
        list.add(new SetsModels("11 - bosqich"));
        list.add(new SetsModels("12 - bosqich"));
        list.add(new SetsModels("13 - bosqich"));
        list.add(new SetsModels("14 - bosqich"));
        list.add(new SetsModels("15 - bosqich"));
        list.add(new SetsModels("16 - bosqich"));
        list.add(new SetsModels("17 - bosqich"));
        list.add(new SetsModels("18 - bosqich"));
        list.add(new SetsModels("19 - bosqich"));
        list.add(new SetsModels("20 - bosqich"));

        SetAdapter adapter = new SetAdapter(this, list);
        binding.setsRecy.setAdapter(adapter);

        binding.backColorGame.setOnClickListener(v -> finish());

    }
}