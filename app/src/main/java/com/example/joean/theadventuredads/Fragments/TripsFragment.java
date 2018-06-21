package com.example.joean.theadventuredads.Fragments;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.joean.theadventuredads.Adapters.TripAdapter;
import com.example.joean.theadventuredads.Models.Trip;
import com.example.joean.theadventuredads.R;
import java.util.ArrayList;

public class TripsFragment extends Fragment {
    private ArrayList<Trip> tripItems = new ArrayList<>();
    private RecyclerView tripsRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trips, container, false);
        initRecyclerView(view);
        return view;
    }




    private void initRecyclerView(View view) {
        // Setup recyclerview data.
        tripItems.add(new Trip(R.drawable.mtassiniboine,"Mt. Assiniboine","North Ridge","July 15, 2018"));
        tripItems.add(new Trip(R.drawable.mtcurrie,"Mt. Currie","Mt. Currie Trail","July 31, 2018"));
        tripItems.add(new Trip(R.drawable.alcoholictraverse,"Alcoholics Traverse","Full Traverse","August 15, 2018"));
        tripItems.add(new Trip(R.drawable.mountrobson,"Mt. Robson","Wishbone Arete","June 21, 2019"));
        tripItems.add(new Trip(R.drawable.mtwaddington,"Mt. Waddington","South Face","July 17, 2019"));

        // Setup recyclerview.
        tripsRecyclerView = (RecyclerView) view.findViewById(R.id.tripsRecyclerView);
        tripsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        tripsRecyclerView.setLayoutManager(mLayoutManager);

        TripAdapter adapter = new TripAdapter(getActivity(), tripItems);
        tripsRecyclerView.setAdapter(adapter);
    }
}

