package com.katkov.lolachievements.di.provider;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public final class OkHttpClientProvider implements Provider<OkHttpClient> {

    private final Interceptor loggingInterceptor;
    private final Interceptor serverNameInterceptor;

    @Inject
    public OkHttpClientProvider(
            @Named("logInterceptor") Interceptor loggingInterceptor,
            @Named("serverNameInterceptor") Interceptor serverNameInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
        this.serverNameInterceptor = serverNameInterceptor;
    }

    @Override
    public OkHttpClient get() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(serverNameInterceptor)
                .build();
    }
}
