package com.example.joean.theadventuredads.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.example.joean.theadventuredads.Adapters.VideoAdapter;
import com.example.joean.theadventuredads.Models.Video;
import com.example.joean.theadventuredads.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class VideoFragment extends Fragment {
    private ArrayList<Video> videoItems = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        initRecyclerView(view);
        youtubeAPICall();
        return view;
    }


    private void initRecyclerView(final View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.videoRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new VideoAdapter(getActivity(), videoItems);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void youtubeAPICall() {

        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLdxn7s5TKRAjhnwliI5guf6yfJ10KaiAg&key=AIzaSyCiErgUhkZUyMHnQLvV8YTGuAiBVBxP_kU";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        System.out.println(response);
                        try {
                            JSONArray itemArray = response.getJSONArray("items");

                            for (int i = 0; i < itemArray.length(); i++) {

                                JSONObject itemObject = itemArray.getJSONObject(i);
                                JSONObject snippet = itemObject.getJSONObject("snippet");
                                JSONObject resourceId = snippet.getJSONObject("resourceId");

                                String videoID = resourceId.getString("videoId");

                                // Parse Json to get the video title from Youtube
                                String videoTitle = snippet.getString("title");

                                // TODO: Add item to array.
                                videoItems.add(new Video(videoID, videoTitle));

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
