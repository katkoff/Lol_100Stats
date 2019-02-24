package com.katkov.lolachievements.di.provider;

import com.katkov.lolachievements.data.intercepter.ServerNameInterceptor;
import com.katkov.lolachievements.prefser.EntryInfoHolder;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.Interceptor;

public final class ServerNameInterceptorProvider implements Provider<Interceptor> {

    private final EntryInfoHolder entryInfoHolder;

    @Inject
    ServerNameInterceptorProvider(EntryInfoHolder entryInfoHolder) {
        this.entryInfoHolder = entryInfoHolder;
    }

    @Override
    public Interceptor get() {
        return new ServerNameInterceptor(entryInfoHolder);
    }
}
