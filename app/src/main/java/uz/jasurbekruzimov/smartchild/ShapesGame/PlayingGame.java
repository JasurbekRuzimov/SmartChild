package uz.jasurbekruzimov.smartchild.ShapesGame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.databinding.FragmentPlayingGameBinding;

public class PlayingGame extends Fragment {

    public PlayingGame() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private FragmentPlayingGameBinding binding;

    ArrayList<ImageView> shapes = new ArrayList<>();
    HashMap<String, Integer> shapesMap = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPlayingGameBinding.inflate(inflater, container, false);

        shapesMap.put("circle", R.drawable.circle);
        shapesMap.put("polygon", R.drawable.polygon);
        shapesMap.put("triangle", R.drawable.triangle);
        shapesMap.put("rectangle", R.drawable.rectangle);
        shapesMap.put("star", R.drawable.star);
        shapesMap.put("pentagon", R.drawable.pentagon);

        binding.btnNext.setOnClickListener(v -> {
            generateShapes();
        });

        shapes.add(binding.ivShape1);
        shapes.add(binding.ivShape2);
        shapes.add(binding.ivShape3);
        generateShapes();

        return binding.getRoot();

    }

    private void generateShapes() {
        Set<Integer> randomContainer = new HashSet<>();

        for (ImageView shape : shapes) {
            int random = (int) (Math.random() * 6);
            while (!randomContainer.add(random)) {
                random = (int) (Math.random() * 6);
            }
            switchMethod(shape, random);
        }

        randomContainer.clear();
    }


    private void switchMethod(ImageView shape, Integer random) {
        switch (random) {
            case 0:
                shape.setImageResource(shapesMap.get("circle"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("Aylana");
                });
                break;

            case 1:
                shape.setImageResource(shapesMap.get("polygon"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("oltiburchak");
                });
                break;
            case 2:
                shape.setImageResource(shapesMap.get("triangle"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("uchburchak");
                });
                break;
            case 3:
                shape.setImageResource(shapesMap.get("rectangle"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("to'rtburchak");
                });
                break;
            case 4:
                shape.setImageResource(shapesMap.get("star"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("yulduzcha");
                });
                break;
            case 5:
                shape.setImageResource(shapesMap.get("pentagon"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("beshburchak");
                });
        }
    }

    // we had better write these codes for onDestroyView
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}