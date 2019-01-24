package com.katkov.lolachievements.presentation.firstentry;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.utils.TextInputUtils;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Toothpick;

public class FirstEntryFragment extends MvpAppCompatFragment implements FirstEntryView {

    @BindView(R.id.inputLayout_summonerName)
    TextInputLayout summonerNameInputLayout;
    @BindView(R.id.button_login)
    Button loginButton;

    @Inject
    Provider<FirstEntryPresenter> presenterProvider;
    @ProvidePresenter
    FirstEntryPresenter providePresenter() {
        return presenterProvider.get() ;
    }
    @InjectPresenter
    FirstEntryPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE));
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_entry, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    public static FirstEntryFragment newInstance() {
        Bundle args = new Bundle();
        FirstEntryFragment fragment = new FirstEntryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.button_login)
    void loginButtonPressed() {
        presenter.onLoginButtonPressed(TextInputUtils.getText(summonerNameInputLayout));
    }
}
