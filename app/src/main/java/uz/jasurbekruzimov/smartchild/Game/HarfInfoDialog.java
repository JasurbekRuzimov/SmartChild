package uz.jasurbekruzimov.smartchild.Game;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import uz.jasurbekruzimov.smartchild.R;


public class HarfInfoDialog extends Dialog {

    private ImageView harfRasmImageView;
    private TextView harfInfoTextView;
    private int harfImageResource;
    private String harfInfoText;

    public HarfInfoDialog(Context context, int harfImageResource, String harfInfoText) {
        super(context);
        this.harfImageResource = harfImageResource;
        this.harfInfoText = harfInfoText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_harf);

        harfRasmImageView = findViewById(R.id.harfRasmImageView);
        harfInfoTextView = findViewById(R.id.harfInfoTextView);

        harfRasmImageView.setImageResource(harfImageResource);
        harfInfoTextView.setText(harfInfoText);
    }
}
