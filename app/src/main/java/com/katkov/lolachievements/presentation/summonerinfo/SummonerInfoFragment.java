package com.katkov.lolachievements.presentation.summonerinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.data.local.entity.Summoner;
import com.katkov.lolachievements.di.Scopes;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import toothpick.Toothpick;

public class SummonerInfoFragment extends MvpAppCompatFragment {

    @BindView(R.id.textView_summonerName)
    TextView summonerNameTextView;
    @BindView(R.id.textView_summonerLevel)
    TextView summonerLevelTextView;

    @Inject
    Provider<SummonerInfoPresenter> presenterProvider;
    @ProvidePresenter
    SummonerInfoPresenter providePresenter() {
        return presenterProvider.get();
    }
    @InjectPresenter
    SummonerInfoPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.USER_SCOPE));
        super.onCreate(savedInstanceState);
    }

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
    }

    public static SummonerInfoFragment newInstance() {
        Bundle args = new Bundle();
        SummonerInfoFragment fragment = new SummonerInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void fillSummonerInfo(Summoner summoner) {
//        Summoner summoner = (Summoner) getArguments().getSerializable(SUMMONER);
//        if (summoner != null) {
//            if (summoner.getName() != null && !summoner.getName().isEmpty()) {
//                summonerNameTextView.setText(summoner.getName());
//            }
//            summonerLevelTextView.setText(String.valueOf(summoner.getLevel()));
//        }
    }
}
