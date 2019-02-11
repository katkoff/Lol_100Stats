package com.katkov.lolachievements;

import com.katkov.lolachievements.presentation.checkentryinfo.CheckEntryInfoFragment;
import com.katkov.lolachievements.presentation.firstentry.FirstEntryFragment;
import com.katkov.lolachievements.presentation.summonerinfo.SummonerInfoFragment;

import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {


    public static class FirstEntryScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return FirstEntryFragment.newInstance();
        }
    }

    public static class CheckFirstEntryInfoScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return CheckEntryInfoFragment.newInstance();
        }
    }

    public static class SummonerInfoScreen extends SupportAppScreen {

        @Override
        public Fragment getFragment() {
            return SummonerInfoFragment.newInstance();
        }
    }
}
