package com.example.joean.theadventuredads.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.joean.theadventuredads.Adapters.FeedAdapter;
import com.example.joean.theadventuredads.Models.Feed;
import com.example.joean.theadventuredads.R;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FeedFragment extends Fragment {
    private ArrayList<Feed> feedItems = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        instaAPICall();

        initRecyclerView(view);
        return view;
    }


    private void initRecyclerView(final View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.feedRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new FeedAdapter(feedItems);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void instaAPICall() {

        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://api.instagram.com/v1/users/self/media/recent/?access_token=7309771784.8bca4b4.8699a750c408415282a19a5214953605";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        System.out.println(response);
                        try {
                            JSONArray dataArray = response.getJSONArray("data");

                            for (int i = 0; i < dataArray.length(); i++) {

                                JSONObject dataObject = dataArray.getJSONObject(i);
                                JSONObject images = dataObject.getJSONObject("images");
                                JSONObject standard_resolution = images.getJSONObject("standard_resolution");
                                String url = standard_resolution.getString("url");

                                JSONObject caption = dataObject.getJSONObject("caption");
                                String text = caption.getString("text");


                                JSONObject from = caption.getJSONObject("from");
                                String username = from.getString("username");

                                // TODO: Add item to array.
                                feedItems.add(new Feed(username, url, text));
                            }

                            // Refresh RecyclerView
                            mAdapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        System.out.println(error);
                    }
                });

        // queue object was instantiated in pt#3
        queue.add(jsObjRequest);
    }
}