package com.example.activity_signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class fragment_workout extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    RecyclerView RecWorkout;
    Workout_Adapter adapter;



    public fragment_workout() {
        // Required empty public constructor
    }


    public static fragment_workout newInstance(String param1, String param2) {
        fragment_workout fragment = new fragment_workout();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        RecWorkout = (RecyclerView) view.findViewById(R.id.recyclerWorkout);
        RecWorkout.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<workout_model> options =
                new FirebaseRecyclerOptions.Builder<workout_model>().setQuery(FirebaseDatabase.getInstance().getReference().child("Workout"), workout_model.class).build();

        adapter = new Workout_Adapter(options);
        RecWorkout.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}