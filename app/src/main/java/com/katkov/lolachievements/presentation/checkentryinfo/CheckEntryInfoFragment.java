package com.katkov.lolachievements.presentation.checkentryinfo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.service.LoginService;
import com.katkov.lolachievements.utils.TextInputUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import toothpick.Toothpick;

public class CheckEntryInfoFragment extends MvpAppCompatFragment implements CheckEntryInfoView {

    @BindView(R.id.textView_summonerName)
    TextView summonerNameTextView;

    @InjectPresenter
    CheckEntryInfoPresenter presenter;

    @Inject
    SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE));
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_check_entry_info, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    public static CheckEntryInfoFragment newInstance() {
        Bundle args = new Bundle();
        CheckEntryInfoFragment fragment = new CheckEntryInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void fillInfo() {
        String summoner = preferences.getString(LoginService.SUMMONER_NAME_PREF, "unknown name");
        TextInputUtils.setText(summonerNameTextView, summoner);
    }
}
