package com.example.joean.theadventuredads.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.joean.theadventuredads.Adapters.MeetupAdapter;
import com.example.joean.theadventuredads.Adapters.TripAdapter;
import com.example.joean.theadventuredads.Models.Meetup;
import com.example.joean.theadventuredads.Models.Trip;
import com.example.joean.theadventuredads.R;

import java.util.ArrayList;

/**
 * Created by joean on 2018-06-21.
 */

public class MeetupFragment extends Fragment {
    private ArrayList<Meetup> meetupItems = new ArrayList<>();
    private RecyclerView meetupRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meetup, container, false);
        initRecyclerView(view);
        return view;
    }




    private void initRecyclerView(View view) {
        // Setup recyclerview data.
        meetupItems.add(new Meetup(R.drawable.thecheif,"Family take over the Chief","August 31, 2018","The Chief, Squamish BC"));
        meetupItems.add(new Meetup(R.drawable.flemming,"Climb with your kids","September 7, 2018","Flemming Beach Victoria BC"));
        meetupItems.add(new Meetup(R.drawable.squam,"Family 1st of the season","June 20, 2019","Chekamus Canyon, Squamish BC"));
        meetupItems.add(new Meetup(R.drawable.mtcurrie,"Hike Mt Currie","July 31, 2019","Mt Currie, Pemberton BC"));
        meetupItems.add(new Meetup(R.drawable.triplepeak,"Step it up on a mountain","August 31, 2019","Alberni Inlet, Port Alberni BC"));

        // Setup recyclerview.
        meetupRecyclerView = (RecyclerView) view.findViewById(R.id.meetupRecyclerView);
        meetupRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        meetupRecyclerView.setLayoutManager(mLayoutManager);

        MeetupAdapter adapter = new MeetupAdapter(getActivity(), meetupItems);
        meetupRecyclerView.setAdapter(adapter);
    }
}
