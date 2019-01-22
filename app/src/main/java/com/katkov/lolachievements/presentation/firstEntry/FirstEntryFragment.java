package com.katkov.lolachievements.presentation.firstEntry;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.katkov.lolachievements.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstEntryFragment extends MvpAppCompatFragment {

    @BindView(R.id.inputLayout_summonerName)
    TextInputLayout summonerNameInputLayout;
    @BindView(R.id.button_login)
    Button loginButton;

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
}
