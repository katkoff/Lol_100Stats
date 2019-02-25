package com.katkov.lolachievements.application.ui.firstentry;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.application.navigation.Screens;
import com.katkov.lolachievements.domain.model.EntryInfoModel;
import com.katkov.lolachievements.domain.usecase.LoginUseCase;
import com.katkov.lolachievements.utils.ServerNamesHandler;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class FirstEntryPresenter extends MvpPresenter<FirstEntryView> {

    private final LoginUseCase loginUseCase;
    private final Router router;
    private int selectedNameIndex;

    @Inject
    FirstEntryPresenter(LoginUseCase loginUseCase, Router router) {
        this.loginUseCase = loginUseCase;
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onLoginButtonClicked(String summonerName) {
        EntryInfoModel entryInfoModel = new EntryInfoModel(
                summonerName,
                ServerNamesHandler.getCodeByIndex(selectedNameIndex));

        loginUseCase.saveEntryInfo(entryInfoModel);
        router.navigateTo(new Screens.CheckFirstEntryInfoScreen());
    }

    public void onServerNameClicked() {
        getViewState().showServerChoiceDialog();
    }

    public void onServerNameSelected(int selectedIndex) {
        this.selectedNameIndex = selectedIndex;
        String selectedName = ServerNamesHandler.getNameByIndex(selectedIndex);
        getViewState().showSelectedName(selectedName);
    }
}
