package uz.jasurbekruzimov.smartchild.ShapesGame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import uz.jasurbekruzimov.smartchild.Dashboard.Alifbe_Activity;
import uz.jasurbekruzimov.smartchild.Game.HarfInfoDialog;
import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.databinding.FragmentPlayingGameBinding;

public class PlayingGame extends Fragment {

    private FragmentPlayingGameBinding binding;
    private final ArrayList<ImageView> shapes = new ArrayList<>();
    private final HashMap<String, Integer> shapesMap = new HashMap<>();

    public PlayingGame() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlayingGameBinding.inflate(inflater, container, false);

        shapesMap.put("circle", R.drawable.circle);
        shapesMap.put("polygon", R.drawable.polygon);
        shapesMap.put("triangle", R.drawable.triangle);
        shapesMap.put("rectangle", R.drawable.rectangle);
        shapesMap.put("star", R.drawable.star);
        shapesMap.put("pentagon", R.drawable.pentagon);

        binding.btnNext.setOnClickListener(v -> generateShapes());

        NavOptions navOptions = new NavOptions.Builder()
                .setEnterAnim(R.anim.enter)
                .setExitAnim(R.anim.exit)
                .setPopEnterAnim(R.anim.pop_enter)
                .setPopExitAnim(R.anim.pop_exit)
                .build();

        binding.btnBackGame.setOnClickListener(v -> {
            Navigation.findNavController(container).navigate(R.id.beginGame, null, navOptions);
            requireActivity().finish();
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

    @SuppressLint("SetTextI18n")
    private void switchMethod(ImageView shape, Integer random) {
        switch (random) {
            case 0:
                shape.setImageResource(shapesMap.get("circle"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("Aylana");
                    final MediaPlayer mp = MediaPlayer.create(requireContext(), R.raw.aylana);
                    mp.start();
                });
                break;

            case 1:
                shape.setImageResource(shapesMap.get("polygon"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("oltiburchak");
                    final MediaPlayer mp = MediaPlayer.create(requireContext(), R.raw.oltiburchak);
                    mp.start();
                });
                break;
            case 2:
                shape.setImageResource(shapesMap.get("triangle"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("uchburchak");
                    final MediaPlayer mp = MediaPlayer.create(requireContext(), R.raw.uchburchak);
                    mp.start();
                });
                break;
            case 3:
                shape.setImageResource(shapesMap.get("rectangle"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("to'rtburchak");
                    final MediaPlayer mp = MediaPlayer.create(requireContext(), R.raw.tortburchak);
                    mp.start();
                });
                break;
            case 4:
                shape.setImageResource(shapesMap.get("star"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("yulduzcha");
                    final MediaPlayer mp = MediaPlayer.create(requireContext(), R.raw.yulduzcha);
                    mp.start();
                });
                break;
            case 5:
                shape.setImageResource(shapesMap.get("pentagon"));
                shape.setOnClickListener(v -> {
                    binding.tvAnswer.setText("beshburchak");
                    final MediaPlayer mp = MediaPlayer.create(requireContext(), R.raw.beshburchak);
                    mp.start();
                });
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
