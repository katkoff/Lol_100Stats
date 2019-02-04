package com.katkov.lolachievements.di.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.katkov.lolachievements.data.cloud.api.LolApiService;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
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

        bind(LolApiService.class)
                .toProvider(LolApiServiceProvider.class)
                .providesSingletonInScope();
    }

    /**
     * OKHTTP
     */

    public static final class OkHttpClientProvider implements Provider<OkHttpClient> {

        @Override
        public OkHttpClient get() {
            return new OkHttpClient.Builder()
                    .build();
        }
    }

    /**
     * RETROFIT
     */
    public static final class LolApiServiceProvider implements Provider<LolApiService> {

        private final OkHttpClient okHttpClient;

        @Inject
        public LolApiServiceProvider(OkHttpClient okHttpClient) {
            this.okHttpClient = okHttpClient;
        }

        @Override
        public LolApiService get() {
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .build();
            return retrofit.create(LolApiService.class);
        }
    }
}