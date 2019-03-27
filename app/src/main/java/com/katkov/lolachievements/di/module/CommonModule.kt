package com.katkov.lolachievements.di.module

import android.content.Context
import android.content.SharedPreferences
import com.github.pwittchen.prefser.library.rx2.Prefser
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.di.provider.*
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import toothpick.config.Module

class CommonModule(context: Context) : Module() {

    init {
        bind(Context::class.java).toInstance(context)

        bind(SharedPreferences::class.java)
                .toInstance(context.getSharedPreferences(LOL_PREFERENCE, Context.MODE_PRIVATE))

        bind(OkHttpClient::class.java)
                .toProvider(OkHttpClientProvider::class.java)
                .providesSingletonInScope()

        bind(Gson::class.java).toInstance(GsonBuilder().create())

        bind(GsonConverterFactory::class.java)
                .toInstance(GsonConverterFactory.create())

        bind(RxJava2CallAdapterFactory::class.java)
                .toInstance(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))

        bind(Interceptor::class.java)
                .withName("logInterceptor")
                .toProvider(LoggingInterceptorProvider::class.java)

        bind(ApiService::class.java)
                .toProvider(LolApiServiceProvider::class.java)
                .providesSingletonInScope()

        bind(Prefser::class.java)
                .toProvider(PrefserProvider::class.java)
                .singletonInScope()

        bind(Interceptor::class.java)
                .withName("serverNameInterceptor")
                .toProvider(ServerNameInterceptorProvider::class.java)
    }

    companion object {

        const val LOL_PREFERENCE = "lol_preference"
    }
}