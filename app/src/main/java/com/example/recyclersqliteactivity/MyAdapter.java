package com.example.recyclersqliteactivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    private Context context;
    private ArrayList name_id,email_id,age_id;

    public MyAdapter(Context context, ArrayList name_id,ArrayList email_id, ArrayList age_id)
    {
        this.context = context;
        this.name_id = name_id;
        this.email_id = email_id;
        this.age_id = age_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
