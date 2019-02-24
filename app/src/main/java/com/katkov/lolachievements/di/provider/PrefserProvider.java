package com.katkov.lolachievements.di.provider;

import android.content.SharedPreferences;

import com.github.pwittchen.prefser.library.rx2.Prefser;

import javax.inject.Inject;
import javax.inject.Provider;

public final class PrefserProvider implements Provider<Prefser> {

    private final SharedPreferences sharedPreferences;

    @Inject
    public PrefserProvider(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Prefser get() {
        return new Prefser(sharedPreferences);
    }
}