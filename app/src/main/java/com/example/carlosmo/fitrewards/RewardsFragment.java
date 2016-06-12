package com.example.carlosmo.fitrewards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RewardsFragment extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.rewards_fragment, container, false);

        // Get the list of goals
        List<Reward> dummyData = new ArrayList<Reward>();
        dummyData.add(new Reward("McDonald's","My Description","http://cliparts.co/cliparts/yck/r4d/yckr4d7oi.png",479));
        dummyData.add(new Reward("Starbucks","My Description","http://cliparts.co/cliparts/yck/r4d/yckr4d7oi.png",550));
        dummyData.add(new Reward("Tim Hortons","My Description","http://cliparts.co/cliparts/yck/r4d/yckr4d7oi.png", 300));

        // Configure the adapter and listview
        CustomRewardsAdapter adapter = new CustomRewardsAdapter(getActivity(), R.layout.custom_reward_item, dummyData);

        ListView lv = (ListView) rootView.findViewById(R.id.rewardsList);
        lv.setAdapter(adapter);


        return rootView;
    }
}