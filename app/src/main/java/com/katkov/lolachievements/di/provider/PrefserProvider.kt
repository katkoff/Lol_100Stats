package com.katkov.lolachievements.di.provider

import android.content.SharedPreferences

import com.github.pwittchen.prefser.library.rx2.Prefser

import javax.inject.Inject
import javax.inject.Provider

class PrefserProvider
@Inject
constructor(private val sharedPreferences: SharedPreferences) : Provider<Prefser> {

    override fun get(): Prefser = Prefser(sharedPreferences)
}