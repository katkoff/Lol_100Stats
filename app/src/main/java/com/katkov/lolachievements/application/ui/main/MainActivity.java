package com.katkov.lolachievements.application.ui.main;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.application.base.BaseActivityAndroidX;

import javax.inject.Inject;
import javax.inject.Provider;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import toothpick.Toothpick;

public class MainActivity extends BaseActivityAndroidX implements MainView {

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    Provider<MainPresenter> presenterProvider;
    @ProvidePresenter
    MainPresenter presenterProvide() {
        return presenterProvider.get();
    }
    @InjectPresenter
    MainPresenter presenter;

    private Navigator navigator = new SupportAppNavigator(this, R.id.fragmentContainer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }
}
