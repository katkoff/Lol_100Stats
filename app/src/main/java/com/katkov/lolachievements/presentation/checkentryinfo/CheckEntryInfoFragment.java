package com.katkov.lolachievements.presentation.checkentryinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.presentation.base.BaseFragmentAndroidX;
import com.katkov.lolachievements.utils.TextInputUtils;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Scope;
import toothpick.Toothpick;

public class CheckEntryInfoFragment extends BaseFragmentAndroidX implements CheckEntryInfoView {

    @BindView(R.id.textView_summonerName)
    TextView summonerNameTextView;
    @BindView(R.id.button_logout)
    Button logoutButton;
    @BindView(R.id.button_summonerInfo)
    Button showSummonerInfoButton;

    @Inject
    Provider<CheckEntryInfoPresenter> presenterProvider;
    @ProvidePresenter
    CheckEntryInfoPresenter providePresenter() {
        return presenterProvider.get();
    }
    @InjectPresenter
    CheckEntryInfoPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.USER_SCOPE));
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
    public void fillInfo(String summonerName) {
        TextInputUtils.setText(summonerNameTextView, summonerName);
    }

    @OnClick(R.id.button_logout)
    void logoutButtonClicked() {
        presenter.onLogoutButtonClicked();
    }

    @OnClick(R.id.button_summonerInfo)
    void onSummonerInfoButtonClick() {
        presenter.onSummonerInfoButtonClicked(summonerNameTextView.getText().toString());
    }
}
