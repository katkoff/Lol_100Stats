package com.katkov.lolachievements.presentation.main;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.di.Scopes;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import toothpick.Toothpick;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @Inject
    NavigatorHolder navigatorHolder;

    @InjectPresenter
    MainPresenter mainPresenter;

    private Navigator navigator = new SupportAppNavigator(this, R.id.fragmentContainer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE));
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
