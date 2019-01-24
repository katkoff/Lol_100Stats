package com.katkov.lolachievements.di.common;

import android.content.Context;
import android.content.SharedPreferences;

import toothpick.config.Module;

public class CommonModule extends Module {

    public static final String LOL_PREFERENCE = "lol_preference";

    public CommonModule(Context context) {
        bind(Context.class).toInstance(context);
        bind(SharedPreferences.class).toInstance(context.getSharedPreferences(LOL_PREFERENCE, Context.MODE_PRIVATE));
    }
}