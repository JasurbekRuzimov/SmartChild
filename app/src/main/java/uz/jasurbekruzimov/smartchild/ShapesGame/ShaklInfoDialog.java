package uz.jasurbekruzimov.smartchild.ShapesGame;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import uz.jasurbekruzimov.smartchild.R;

public class ShaklInfoDialog extends Dialog {

    private final int shaklInfoResource;
    private final String shaklInfoText;

    public ShaklInfoDialog(Context context, int shaklImageResource, String shaklInfoText) {
        super(context);
        this.shaklInfoResource = shaklImageResource;
        this.shaklInfoText = shaklInfoText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_shakl);

        ImageView shaklImageView = findViewById(R.id.shaklImageView);
        TextView shaklInfoTextView = findViewById(R.id.shaklInfoTextView);

        shaklImageView.setImageResource(shaklInfoResource);
        shaklInfoTextView.setText(shaklInfoText);
    }
}



