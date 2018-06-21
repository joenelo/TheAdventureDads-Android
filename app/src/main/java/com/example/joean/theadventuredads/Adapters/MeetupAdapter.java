package com.example.joean.theadventuredads.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joean.theadventuredads.Models.Meetup;
import com.example.joean.theadventuredads.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MeetupAdapter extends RecyclerView.Adapter<MeetupAdapter.ViewHolder> {

    Context context;
    private ArrayList<Meetup> meetupItems;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public ImageView meetupImage;
        public TextView meetupnameText;
        public TextView meetupDate;
        public TextView meetupLocation;

        ViewHolder(View view) {
            super(view);

            meetupImage = (ImageView) view.findViewById(R.id.meetupImage);
            meetupnameText = (TextView) view.findViewById(R.id.meetupName);
            meetupDate = (TextView) view.findViewById(R.id.meetupDate);
            meetupLocation = (TextView) view.findViewById(R.id.meetupLocation);
        }
    }

    public MeetupAdapter(Context context, ArrayList<Meetup> meetupItems) {
        this.context = context;
        this.meetupItems = meetupItems;
    }

    @Override
    public int getItemCount() {
        return meetupItems.size();
    }

    @Override
    public MeetupAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_meetup_item, parent, false);
        return new MeetupAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MeetupAdapter.ViewHolder holder, final int position) {
        // Load Picasso to make the images load in Async
        Picasso.get().load(meetupItems.get(holder.getAdapterPosition()).meetupImage).into(holder.meetupImage);
        holder.meetupnameText.setText(meetupItems.get(holder.getAdapterPosition()).meetupName);
        holder.meetupDate.setText(meetupItems.get(holder.getAdapterPosition()).meetupDate);
        holder.meetupLocation.setText(meetupItems.get(holder.getAdapterPosition()).meetupLocation);
    }
}
