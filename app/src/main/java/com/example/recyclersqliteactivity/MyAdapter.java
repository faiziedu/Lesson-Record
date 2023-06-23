package com.example.recyclersqliteactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    private Context context;
    private ArrayList id_id, name_id,Class_id,age_id,sabaq_id,sabaqi_id, manzil_id;

    public MyAdapter(Context context, ArrayList id_id, ArrayList name_id,ArrayList Class_id, ArrayList age_id,  ArrayList sabaq_id,  ArrayList sabaqi_id,  ArrayList manzil_id)
    {
        this.context = context;
        this.id_id=id_id;
        this.name_id = name_id;
        this.Class_id = Class_id;
        this.age_id = age_id;
        this.sabaq_id = sabaq_id;
        this.sabaqi_id = sabaqi_id;
        this.manzil_id = manzil_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View  v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.id_id.setText(String.valueOf(id_id.get(position)));
       holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.Class_id.setText(String.valueOf(Class_id.get(position)));
        holder.age_id.setText(String.valueOf(age_id.get(position)));
        holder.sabaq_id.setText(String.valueOf(sabaq_id.get(position)));
        holder.sabaqi_id.setText(String.valueOf(sabaqi_id.get(position)));
        holder.manzil_id.setText(String.valueOf(manzil_id.get(position)));
    }

    @Override
    public int getItemCount()
    {
        return id_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id_id, name_id, Class_id, age_id,sabaq_id, sabaqi_id, manzil_id;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            id_id=itemView.findViewById(R.id.textid);
            name_id=itemView.findViewById(R.id.textname);
            Class_id=itemView.findViewById(R.id.textClass);
            age_id=itemView.findViewById(R.id.textage);
            sabaq_id=itemView.findViewById(R.id.textsabaq);
            sabaqi_id=itemView.findViewById(R.id.textsabaqi);
            manzil_id=itemView.findViewById(R.id.textmanzil);
        }
    }
}
