package com.example.joean.theadventuredads.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.joean.theadventuredads.Models.Trip;
import com.example.joean.theadventuredads.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    Context context;
    private ArrayList<Trip> tripItems;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public ImageView tripImage;
        public TextView tripnameText;
        public TextView routeText;
        public TextView dateText;

        ViewHolder(View view) {
            super(view);

            tripImage = (ImageView) view.findViewById(R.id.tripImage);
            tripnameText = (TextView) view.findViewById(R.id.tripnameText);
            routeText = (TextView) view.findViewById(R.id.routeText);
            dateText = (TextView) view.findViewById(R.id.dateText);
        }
    }

    public TripAdapter(Context context, ArrayList<Trip> tripItems) {
        this.context = context;
        this.tripItems = tripItems;
    }

    @Override
    public int getItemCount() {
        return tripItems.size();
    }

    @Override
    public TripAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_trip_item, parent, false);
        return new TripAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final TripAdapter.ViewHolder holder, final int position) {
        // Load Picasso to make the images load in Async
        Picasso.get().load(tripItems.get(holder.getAdapterPosition()).tripImage).into(holder.tripImage);
        holder.tripnameText.setText(tripItems.get(holder.getAdapterPosition()).tripName);
        holder.routeText.setText(tripItems.get(holder.getAdapterPosition()).tripRoute);
        holder.dateText.setText(tripItems.get(holder.getAdapterPosition()).tripDate);
    }

}
