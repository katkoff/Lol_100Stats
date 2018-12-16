package com.katkov.lolachievements;

import android.support.v4.app.Fragment;

import com.katkov.lolachievements.data.local.entity.Summoner;
import com.katkov.lolachievements.presentation.choiceServer.ChoiceServerFragment;
import com.katkov.lolachievements.presentation.summonerInfo.SummonerInfoFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {


    public static class ServerChoiceScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return ChoiceServerFragment.newInstance();
        }
    }

    public static class PlayerInfoScreen extends SupportAppScreen {

        public Summoner summoner;

        public PlayerInfoScreen(Summoner summoner) {
            this.summoner = summoner;
        }

        @Override
        public Fragment getFragment() {
            return SummonerInfoFragment.newInstance(summoner);
        }
    }
}
