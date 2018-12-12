package com.katkov.lolachievements.presentation.choiceServer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.katkov.lolachievements.R;

public class ChoiceServerFragment extends MvpAppCompatFragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_choice_server, container, false);
        return rootView;
    }

    public static ChoiceServerFragment newInstance() {
        Bundle args = new Bundle();
        ChoiceServerFragment fragment = new ChoiceServerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
