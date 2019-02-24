package com.katkov.lolachievements.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.pwittchen.prefser.library.rx2.Prefser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.katkov.lolachievements.data.cloud.api.ApiService;
import com.katkov.lolachievements.di.provider.LoggingInterceptorProvider;
import com.katkov.lolachievements.di.provider.LolApiServiceProvider;
import com.katkov.lolachievements.di.provider.OkHttpClientProvider;
import com.katkov.lolachievements.di.provider.PrefserProvider;
import com.katkov.lolachievements.di.provider.ServerNameInterceptorProvider;

import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import toothpick.config.Module;

public class CommonModule extends Module {

    public static final String LOL_PREFERENCE = "lol_preference";

    public CommonModule(Context context) {
        bind(Context.class).toInstance(context);
        bind(SharedPreferences.class)
                .toInstance(context.getSharedPreferences(LOL_PREFERENCE, Context.MODE_PRIVATE));

        bind(OkHttpClient.class)
                .toProvider(OkHttpClientProvider.class)
                .providesSingletonInScope();

        bind(Gson.class).toInstance(new GsonBuilder().create());

        bind(GsonConverterFactory.class)
                .toInstance(GsonConverterFactory.create());

        bind(RxJava2CallAdapterFactory.class)
                .toInstance(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()));

        bind(Interceptor.class)
                .withName("logInterceptor")
                .toProvider(LoggingInterceptorProvider.class);

        bind(ApiService.class)
                .toProvider(LolApiServiceProvider.class)
                .providesSingletonInScope();

        bind(Prefser.class)
                .toProvider(PrefserProvider.class)
                .singletonInScope();

        bind(Interceptor.class)
                .withName("serverNameInterceptor")
                .toProvider(ServerNameInterceptorProvider.class);
    }
}