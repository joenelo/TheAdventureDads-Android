//package com.example.joean.theadventuredads.Adapters;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.joean.theadventuredads.Models.Feed;
//import com.example.joean.theadventuredads.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
///**
// * Created by joean on 2018-06-18.
// */
//
//public class VideoAdapter {
//
//    private ArrayList<Feed> videoItems;
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        // each data item is just a string in this case
//        //public YouTubePlayerView  videoView;
//
//
//        ViewHolder(View view) {
//            super(view);
//
//           // feedImage = (ImageView) view.findViewById(R.id.feedImage);
//
//        }
//    }
//
//
//    public FeedAdapter(ArrayList<Feed> feedItems) {
//        this.feedItems = feedItems;
//    }
//
//    @Override
//    public int getItemCount() {
//        return feedItems.size();
//    }
//
//    @Override
//    public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feed_item, parent, false);
//        return new FeedAdapter.ViewHolder(view);
//    }
//
//
//    @Override
//    public void onBindViewHolder(final FeedAdapter.ViewHolder holder, final int position) {
//
//
//        // TODO: Fill views with Array data.
//        holder.feedUsername.setText(feedItems.get(holder.getAdapterPosition()).username);
//        Picasso.get().load(feedItems.get(holder.getAdapterPosition()).url).into(holder.feedImage);
//        holder.feedCaption.setText(feedItems.get(holder.getAdapterPosition()).caption);
//    }
//
//}
