package com.katkov.lolachievements.presentation.firstentry;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.google.android.material.textfield.TextInputLayout;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.model.EntryInfoModel;
import com.katkov.lolachievements.presentation.base.BaseFragmentAndroidX;
import com.katkov.lolachievements.utils.ServerNamesHandler;
import com.katkov.lolachievements.utils.TextInputUtils;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import toothpick.Toothpick;

public class FirstEntryFragment extends BaseFragmentAndroidX implements FirstEntryView {

    private static final int DEFAULT_SERVER_NAME_INDEX = 0;

    @BindView(R.id.inputLayout_summonerName)
    TextInputLayout summonerNameInputLayout;
    @BindView(R.id.inputLayout_serverName)
    TextInputLayout serverNameInputLayout;
    @BindView(R.id.button_login)
    Button loginButton;
    
    private int lastSelectedIndex;

    @Inject
    Provider<FirstEntryPresenter> presenterProvider;

    @ProvidePresenter
    FirstEntryPresenter providePresenter() {
        return presenterProvider.get();
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

    @OnClick(R.id.inputEditText_serverName)
    void serverNameButtonClick() {
        presenter.onServerNameClicked();
    }

    @Override
    public void showServerChoiceDialog() {
        String[] serverNames = ServerNamesHandler.getServerNames();
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        dialogBuilder.setTitle("Choose server name")
                .setSingleChoiceItems(serverNames, DEFAULT_SERVER_NAME_INDEX, (dialogInterface, i) -> {
                    this.lastSelectedIndex = i;
                })
                .setPositiveButton("Ok", (dialogInterface, selectedIndex) -> {
                    TextInputUtils.setText(serverNameInputLayout, serverNames[lastSelectedIndex]);
                    dialogInterface.dismiss();
                })
                .create()
                .show();
    }

    @OnClick(R.id.button_login)
    void loginButtonClick() {
        String serverCode = ServerNamesHandler.getCodeByIndex(lastSelectedIndex);

        EntryInfoModel entryInfoModel = new EntryInfoModel(
                TextInputUtils.getText(summonerNameInputLayout),
                serverCode);
        presenter.onLoginButtonClicked(entryInfoModel);
    }
}
