package com.katkov.lolachievements.presentation.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katkov.lolachievements.LolApp;
import com.katkov.lolachievements.R;
import com.katkov.lolachievements.presentation.choiceServer.ChoiceServerFragment;
import com.katkov.lolachievements.presentation.playerInfo.PlayerInfoFragment;
import com.katkov.lolachievements.utils.CiceroneKeys;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    private Navigator navigator = new SupportFragmentNavigator(
            getSupportFragmentManager(), R.id.fragmentContainer) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case CiceroneKeys.CHOICE_SERVER_FRAGMENT:
                    return ChoiceServerFragment.newInstance();
                case CiceroneKeys.PLAYER_INFO_FRAGMENT:
                    return PlayerInfoFragment.newInstance();
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };


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

    //    @Override
//    public void showFirstFragment(boolean isThisFirstEntry) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        if (isThisFirstEntry) {
//            mainPresenter.startChoiceServerFragment(fragmentManager, R.id.fragmentContainer);
//        } else {
//            mainPresenter.startPlayerInfoFragment(fragmentManager, R.id.fragmentContainer);
//        }
//    }
}
