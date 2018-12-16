package com.katkov.lolachievements.presentation.summonerInfo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.katkov.lolachievements.R;

public class SummonerInfoFragment extends MvpAppCompatFragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_summoner_info, container, false);
        return rootView;
    }

    public static SummonerInfoFragment newInstance() {
        Bundle args = new Bundle();
        SummonerInfoFragment fragment = new SummonerInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
