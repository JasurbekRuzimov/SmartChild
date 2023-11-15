package uz.jasurbekruzimov.smartchild.Game;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import uz.jasurbekruzimov.smartchild.Dashboard.Alifbe_Activity;
import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.ShapesGame.PlayingGame;


public class  HarfInfoDialog extends Dialog {

    private final int harfImageResource;
    private final String harfInfoText;

    public HarfInfoDialog(Alifbe_Activity context, int harfImageResource, String harfInfoText) {
        super(context);
        this.harfImageResource = harfImageResource;
        this.harfInfoText = harfInfoText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_harf);

        ImageView harfRasmImageView = findViewById(R.id.harfRasmImageView);
        TextView harfInfoTextView = findViewById(R.id.harfInfoTextView);

        harfRasmImageView.setImageResource(harfImageResource);
        harfInfoTextView.setText(harfInfoText);
    }
}
