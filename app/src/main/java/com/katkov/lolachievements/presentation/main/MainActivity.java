package com.katkov.lolachievements.presentation.main;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katkov.lolachievements.LolApp;
import com.katkov.lolachievements.R;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    private Navigator navigator = new SupportAppNavigator(this, R.id.fragmentContainer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        LolApp.INSTANCE.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LolApp.INSTANCE.getNavigatorHolder().removeNavigator();
    }
}
