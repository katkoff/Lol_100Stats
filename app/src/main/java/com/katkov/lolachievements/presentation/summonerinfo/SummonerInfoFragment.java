package com.katkov.lolachievements.presentation.summonerinfo;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.data.local.entity.Summoner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SummonerInfoFragment extends MvpAppCompatFragment {

    private static final String SUMMONER = "summoner";

    @BindView(R.id.textView_summonerName)
    TextView summonerNameTextView;
    @BindView(R.id.textView_summonerLevel)
    TextView summonerLevelTextView;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_summoner_info, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        fillSummonerInfo();
    }

    public static SummonerInfoFragment newInstance(Summoner summoner) {
        Bundle args = new Bundle();
        args.putSerializable(SUMMONER, summoner);
        SummonerInfoFragment fragment = new SummonerInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void fillSummonerInfo() {
        Summoner summoner = (Summoner) getArguments().getSerializable(SUMMONER);
        if (summoner != null) {
            if (summoner.getName() != null && !summoner.getName().isEmpty()) {
                summonerNameTextView.setText(summoner.getName());
            }
            summonerLevelTextView.setText(String.valueOf(summoner.getLevel()));
        }
    }
}
