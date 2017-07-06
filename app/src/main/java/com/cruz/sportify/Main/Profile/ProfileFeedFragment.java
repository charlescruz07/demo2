package com.cruz.sportify.Main.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cruz.sportify.Main.Feed.FeedAdapter;
import com.cruz.sportify.Models.Feed;
import com.cruz.sportify.R;

import java.util.ArrayList;

/**
 * Created by Acer on 04/07/2017.
 */

public class ProfileFeedFragment extends Fragment {

    private ArrayList<Feed> feeds;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_layout,container,false);

        feeds = new ArrayList<>();
        get(feeds);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FeedAdapter(rootView.getContext(),feeds);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void get(ArrayList<Feed> feeds){
        Feed feed1 = new Feed(R.drawable.charles,"Charles Cruz","10 mins ago",R.drawable.ic_angle_arrow_down,"Great fight! Ridiculous decision. #ROBBED",R.drawable.feed_image_content1);
        Feed feed2 = new Feed(R.drawable.charles,"Charles Cruz","1 hr ago",R.drawable.ic_angle_arrow_down,"This app is so revolutionary #SPORTIFY",0);
        Feed feed3 = new Feed(R.drawable.charles,"Charles Cruz","2 hrs ago",R.drawable.ic_angle_arrow_down,"Congratulations San Miguel Beermen 2017 PBA \n" +
                "Commissioner's Cup Champions!",R.drawable.feed_image_content2);
        Feed feed4 = new Feed(R.drawable.charles,"Charles Cruz","3 hrs ago",R.drawable.ic_angle_arrow_down,"Second month of high intensity training. Everyday, I am getting closer to my body goals #DailyGrind", R.drawable.feed_image_content4);
        Feed feed5 = new Feed(R.drawable.charles,"Charles Cruz","5 hrs ago",R.drawable.ic_angle_arrow_down,"Let's be clear the Lakers can add PG ..okay..They're still going 2 loose to the warriors..might as well go to Cleveland lol #NBA #sportstalk",0);
        Feed feed6 = new Feed(R.drawable.charles,"Charles Cruz","7 hrs ago",R.drawable.ic_angle_arrow_down,"Welcome to the Thunder, PG13!⚡ #nba #playoffs #okc #thunder",R.drawable.feed_image_content3);
        Feed feed7 = new Feed(R.drawable.charles,"Charles Cruz","8 hrs ago",R.drawable.ic_angle_arrow_down,"Anybody noticed how the Manny Pacquiao fight on #ESPN ended with 8 seconds still left on the clock?",0);
        Feed feed8 = new Feed(R.drawable.charles,"Charles Cruz","9 hrs ago",R.drawable.ic_angle_arrow_down,"Its good to see these young and talented kids putting in the work. Coaching is really a helluva job!",R.drawable.feed_image_content5);
        Feed feed9 = new Feed(R.drawable.charles,"Charles Cruz","12 hrs ago",R.drawable.ic_angle_arrow_down,"How did everyone get on this wl. And for all those who didn't qualify for next week get in touch and we can qualify you  #FIFA17 #FUTChamps",0);
        Feed feed10 = new Feed(R.drawable.charles,"Charles Cruz","15 hrs ago",R.drawable.ic_angle_arrow_down,"BREAKING: Jeremy Stephens vs. Gilbert Melendez at featherweight in the works for UFC 215 in Edmonton, Alberta, Canada on Sept 9. \n" +
                "#UFC",0);
        Feed feed11 = new Feed(R.drawable.charles,"Charles Cruz","21 hrs ago",R.drawable.ic_angle_arrow_down,"Gotta love b-ball! 2017 NBA Free Agency, Trades and Rumors: Kyle Lowry stays put in Toronto",0);

        feeds.add(feed1);
        feeds.add(feed2);
        feeds.add(feed3);
        feeds.add(feed4);
        feeds.add(feed5);
        feeds.add(feed6);
        feeds.add(feed7);
        feeds.add(feed8);
        feeds.add(feed9);
        feeds.add(feed10);
        feeds.add(feed11);
    }
}
