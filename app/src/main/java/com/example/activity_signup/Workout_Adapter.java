package com.example.activity_signup;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


import org.w3c.dom.Text;

public class Workout_Adapter extends FirebaseRecyclerAdapter<workout_model,Workout_Adapter.myviewholder>
{
    public Workout_Adapter(@NonNull FirebaseRecyclerOptions<workout_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull workout_model model) {
        holder.Name.setText(model.getName());
        holder.Repet.setText(model.getRepet());
    }

    @NonNull

    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_workout, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView Name;
        TextView Repet;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            Name = (TextView)itemView.findViewById(R.id.exerciseName);
            Repet = (TextView)itemView.findViewById(R.id.reps);
        }
    }

}
