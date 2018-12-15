package com.katkov.lolachievements;

import android.support.v4.app.Fragment;

import com.katkov.lolachievements.presentation.choiceServer.ChoiceServerFragment;
import com.katkov.lolachievements.presentation.summonerInfo.PlayerInfoFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static class ServerChoiceScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return ChoiceServerFragment.newInstance();
        }
    }

    public static class PlayerInfoScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return PlayerInfoFragment.newInstance();
        }
    }
}
