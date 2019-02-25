package com.katkov.lolachievements.application.ui.summonerinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.application.base.BaseFragmentAndroidX;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.model.SummonerDTO;
import com.katkov.lolachievements.utils.CommonStringUtils;
import com.katkov.lolachievements.utils.TextInputUtils;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import toothpick.Toothpick;

public class SummonerInfoFragment extends BaseFragmentAndroidX implements SummonerInfoView {

    @BindView(R.id.textView_summonerName)
    TextView summonerNameTextView;
    @BindView(R.id.textView_summonerLevel)
    TextView summonerLevelTextView;
    @BindView(R.id.textView_chestCount)
    TextView chestCountTextView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

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
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE));
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

    @Override
    public void fillSummonerInfo(SummonerDTO summonerDTO) {
        if (summonerDTO.getSummonerName() != null) {
            summonerNameTextView.setText(summonerDTO.getSummonerName());
        } else {
            summonerNameTextView.setText(CommonStringUtils.UNKNOWN_VALUE);
        }

        summonerLevelTextView.setText(String.valueOf(summonerDTO.getSummonerLevel()));
    }

    @Override
    public void fillChestCount(int chestCount) {
        TextInputUtils.setText(chestCountTextView, String.valueOf(chestCount));
    }
//
//    @Override
//    public void showProgressBar() {
//        progressBar.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void hideProgressBar() {
//        progressBar.setVisibility(View.GONE);
//    }

    @Override
    public void setProgressEnable(boolean isEnable) {
        if (isEnable) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
