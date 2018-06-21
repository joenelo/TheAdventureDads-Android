package com.example.joean.theadventuredads.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joean.theadventuredads.Models.Video;
import com.example.joean.theadventuredads.R;
import com.jaedongchicken.ytplayer.YoutubePlayerView;
import java.util.ArrayList;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Video> videoItems;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case

        public YoutubePlayerView youtubePlayerView;
        public TextView videoName;


        ViewHolder(View view) {
            super(view);

            youtubePlayerView = (YoutubePlayerView) view.findViewById(R.id.youtubePlayerView);
            videoName = (TextView) view.findViewById(R.id.videoTitle);
            videoName.setSelected(true);
        }
    }

    public VideoAdapter(Context context, ArrayList<Video> videoItems) {
        this.context = context;
        this.videoItems = videoItems;
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_video_item, parent, false);
        return new VideoAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final VideoAdapter.ViewHolder holder, final int position) {


        // TODO: Fill views with Array data.

        // make auto height of youtube. if you want to use 'wrap_content'
        holder.youtubePlayerView.setAutoPlayerHeight(context);


        // initialize YoutubePlayerCallBackListener and VideoID
        holder.youtubePlayerView.initialize(videoItems.get(holder.getAdapterPosition()).videoID, new YoutubePlayerView.YouTubeListener() {


            @Override
            public void onReady() {
                // when player is ready.
            }

            @Override
            public void onStateChange(YoutubePlayerView.STATE state) {
                /**
                 * YoutubePlayerView.STATE
                 *
                 * UNSTARTED, ENDED, PLAYING, PAUSED, BUFFERING, CUED, NONE
                 *
                 */
            }

            @Override
            public void onPlaybackQualityChange(String arg) {
            }

            @Override
            public void onPlaybackRateChange(String arg) {
            }

            @Override
            public void onError(String error) {
            }

            @Override
            public void onApiChange(String arg) {
            }

            @Override
            public void onCurrentSecond(double second) {
                // currentTime callback
            }

            @Override
            public void onDuration(double duration) {
                // total duration
            }

            @Override
            public void logs(String log) {
                // javascript debug log. you don't need to use it.
            }
        });
        holder.videoName.setText(videoItems.get(holder.getAdapterPosition()).videoTitle);

    }
}


