package com.katkov.lolachievements.di.provider;

import com.katkov.lolachievements.data.cloud.api.ApiService;
import com.katkov.lolachievements.data.cloud.utils.ApiUtils;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class LolApiServiceProvider implements Provider<ApiService> {

    private final OkHttpClient okHttpClient;
    private final RxJava2CallAdapterFactory rxJava2CallAdapterFactory;
    private final GsonConverterFactory gsonConverterFactory;

    @Inject
    public LolApiServiceProvider(
            OkHttpClient okHttpClient,
            RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
            GsonConverterFactory gsonConverterFactory) {
        this.okHttpClient = okHttpClient;
        this.rxJava2CallAdapterFactory = rxJava2CallAdapterFactory;
        this.gsonConverterFactory = gsonConverterFactory;
    }

    @Override
    public ApiService get() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUtils.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
        return retrofit.create(ApiService.class);
    }
}
