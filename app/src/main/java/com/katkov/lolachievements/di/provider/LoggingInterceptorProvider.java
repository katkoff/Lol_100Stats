package com.katkov.lolachievements.di.provider;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

public final class LoggingInterceptorProvider implements Provider<Interceptor> {

    @Inject
    LoggingInterceptorProvider() {
    }

    @Override
    public Interceptor get() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
