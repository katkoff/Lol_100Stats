package com.katkov.lolachievements.application.ui.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.application.navigation.Screens;
import com.katkov.lolachievements.domain.model.EntryInfoModel;
import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.Screen;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private final Router router;
    private final EntryInfoHolder entryInfoHolder;

    @Inject
    MainPresenter(Router router, EntryInfoHolder entryInfoHolder) {
        this.router = router;
        this.entryInfoHolder = entryInfoHolder;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        checkAlreadyLogged();
    }

    private void checkAlreadyLogged() {
        EntryInfoModel entryInfoModel = entryInfoHolder.getEntryInfoModel();
        router.newRootScreen(getFirstScreen(entryInfoModel));
    }

    private Screen getFirstScreen(EntryInfoModel entryInfoModel) {
        if (entryInfoModel == null) {
            return new Screens.FirstEntryScreen();
        } else {
            return new Screens.CheckFirstEntryInfoScreen();
        }
    }
}
