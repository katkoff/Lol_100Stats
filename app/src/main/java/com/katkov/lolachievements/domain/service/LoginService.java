package com.katkov.lolachievements.domain.service;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class LoginService {

    public static final String SUMMONER_NAME_PREF = "summoner_name_pref";
    private final SharedPreferences sharedPreferences;

    @Inject
    public LoginService(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveSummonerNameToPref(String summonerName) {
        sharedPreferences.edit().putString(SUMMONER_NAME_PREF, summonerName).apply();
    }
}
