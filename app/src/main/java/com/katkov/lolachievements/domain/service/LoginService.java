package com.katkov.lolachievements.domain.service;

import android.content.SharedPreferences;

import com.katkov.lolachievements.utils.PreferenceKeysUtils;

import javax.inject.Inject;

public class LoginService {

    private final SharedPreferences sharedPreferences;

    @Inject
    public LoginService(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveSummonerNameToPref(String summonerName) {
        sharedPreferences.edit().putString(PreferenceKeysUtils.SUMMONER_NAME_PREF, summonerName).apply();
    }

    public void removeSummonerNameFromPref() {
        sharedPreferences.edit().remove(PreferenceKeysUtils.SUMMONER_NAME_PREF).apply();
    }
}
