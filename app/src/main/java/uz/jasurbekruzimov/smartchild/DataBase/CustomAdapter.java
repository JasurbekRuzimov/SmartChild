package uz.jasurbekruzimov.smartchild.DataBase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

import uz.jasurbekruzimov.smartchild.R;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final Context context;
    Activity activity;
    private final ArrayList<String> user_id;
    private ArrayList<String> ismi;
    private ArrayList<String> familiyasi;
    int position;
    Animation translate_anim;



    public CustomAdapter(Activity activity, Context context, ArrayList<String> user_id, ArrayList<String> ismi, ArrayList<String> familiyasi) {
        this.activity = activity;
        this.context = context;
        this.user_id = user_id;
        this.ismi = ismi;
        this.familiyasi = familiyasi;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.position = position;
        holder.user_id_txt.setText(String.valueOf(user_id.get(position)));
        holder.ism_txt.setText(String.valueOf(ismi.get(position)));
        holder.familiya_txt.setText(String.valueOf(familiyasi.get(position)));


        holder.mainLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, Update_Activity.class);
            intent.putExtra("id", String.valueOf(user_id.get(position)));
            intent.putExtra("ismi", String.valueOf(ismi.get(position)));
            intent.putExtra("familiyasi", String.valueOf(familiyasi.get(position)));
            activity.startActivityForResult(intent, 1);
        });

    }

    @Override
    public int getItemCount() {
        return user_id.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_id_txt, ism_txt, familiya_txt;
        LinearLayout mainLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            user_id_txt = itemView.findViewById(R.id.userId);
            ism_txt = itemView.findViewById(R.id.loginName_txt);
            familiya_txt = itemView.findViewById(R.id.familiya_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            // Animation
            translate_anim = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);

        }
    }
}
