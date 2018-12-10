package com.katkov.lolachievements.presentation.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katkov.lolachievements.R;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    // наверное, это тоже зависимость...
    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void showFirstFragment(boolean isThisFirstEntry) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (isThisFirstEntry) {
            mainPresenter.startChoiceServerFragment(fragmentManager, R.id.fragmentContainer);
        } else {
            mainPresenter.startPlayerInfoFragment(fragmentManager, R.id.fragmentContainer);
        }
    }
}
