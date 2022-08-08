package com.example.android.p_project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class custom_adapter extends RecyclerView.Adapter<custom_adapter.listViewHolder> {


    private ArrayList name,date;
    Context context;
    listItemClick index;

     public interface listItemClick{
        void onClickIndex(int positions);
    }

    public custom_adapter(Context context,ArrayList name, ArrayList date,listItemClick index) {
        this.context=context;
        this.name=name;
        this.date=date;
        this.index=index;
    }
    

    @NonNull
    @Override
    public listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        listViewHolder list=new listViewHolder(view);
        return list;
    }

    @Override
    public void onBindViewHolder(@NonNull listViewHolder holder, int position) {

        holder.textView1.setText(String.valueOf(name.get(position)));
        holder.textView2.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class listViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView1,textView2;
        public listViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.nameText);
            textView2=itemView.findViewById(R.id.dateText);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            index.onClickIndex(position);
        }
    }
}
