package com.example.itemlist;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private ArrayList<Model> list;
    private Context context;
    private final LayoutInflater layoutInflater;
    private Dialog dialog;

    public ListAdapter(Context context,ArrayList<Model> list) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        ListHolder listHolder = new ListHolder(itemView);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.popup);


        listHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialogTitle = (TextView) dialog.findViewById(R.id.popup_title);
                TextView dialogDescription = (TextView) dialog.findViewById(R.id.popup_description);
                ImageView imageView = dialog.findViewById(R.id.pop_image);
                dialogTitle.setText(list.get(listHolder.getAdapterPosition()).getTitle());
                dialogDescription.setText(list.get(listHolder.getAdapterPosition()).getDescription());
                imageView.setImageResource(list.get(listHolder.getAdapterPosition()).getImage());
                dialog.show();
            }
        });

        return listHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.description.setText(list.get(position).getDescription());
        holder.image.setImageResource(list.get(position).getImage());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder{

        private TextView title,description;
        private ImageView image;
        public ListHolder(@NonNull  View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_textView);
            description = itemView.findViewById(R.id.description_textView2);
            image = itemView.findViewById(R.id.image);
        }
    }
}
