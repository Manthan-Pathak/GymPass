package com.example.activity_signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class MyAdapter extends FirebaseRecyclerAdapter<model,MyAdapter.myviewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MyAdapter(@NonNull @NotNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {


        holder.Name.setText(model.getName());
        holder.Repet.setText(model.getRep());
        holder.Desc.setText(model.getDesc());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_workout,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        // ImageView img;
        TextView Name,Repet,Desc;
        Context context;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            Name = (TextView)itemView.findViewById(R.id.exerciseName);
            Repet = (TextView)itemView.findViewById(R.id.reps);
            Desc = (TextView)itemView.findViewById(R.id.txt_Desc);


        }
    }
}
