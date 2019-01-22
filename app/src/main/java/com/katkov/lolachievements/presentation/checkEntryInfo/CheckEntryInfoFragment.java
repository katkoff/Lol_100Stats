package com.katkov.lolachievements.presentation.checkEntryInfo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.katkov.lolachievements.R;

public class CheckEntryInfoFragment extends MvpAppCompatFragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_check_entry_info, container, false);
        return rootView;
    }

    public static CheckEntryInfoFragment newInstance() {
        Bundle args = new Bundle();
        CheckEntryInfoFragment fragment = new CheckEntryInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
