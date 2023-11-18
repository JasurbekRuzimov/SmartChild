package uz.jasurbekruzimov.smartchild.ColorGame.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.jasurbekruzimov.smartchild.ColorGame.Models.SetsModels;
import uz.jasurbekruzimov.smartchild.ColorGame.QuestionActivity;
import uz.jasurbekruzimov.smartchild.R;
import uz.jasurbekruzimov.smartchild.databinding.ItemSetBinding;

public class SetAdapter extends RecyclerView.Adapter<SetAdapter.viewHolder> {

    Context context;
    ArrayList<SetsModels> list;

    public SetAdapter(Context context, ArrayList<SetsModels> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_set, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final SetsModels models = list.get(position);
        holder.binding.setName.setText(models.getSetName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, QuestionActivity.class);
            intent.putExtra("Bo'limlar ro'yxati", models.getSetName());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ItemSetBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemSetBinding.bind(itemView);
        }
    }

}
