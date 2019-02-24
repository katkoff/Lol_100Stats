package com.katkov.lolachievements.data.intercepter;

import com.katkov.lolachievements.prefser.EntryInfoHolder;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ServerNameInterceptor implements Interceptor {

    private final EntryInfoHolder entryInfoHolder;

    @Inject
    public ServerNameInterceptor(EntryInfoHolder entryInfoHolder) {
        this.entryInfoHolder = entryInfoHolder;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl originalUrl = request.url();

        String serverCode = entryInfoHolder.getEntryInfoModel().getServerCode();
        String newHost = serverCode + "." + originalUrl.host();
        HttpUrl newUrl = request.url().newBuilder()
                .host(newHost)
                .build();

        request = request.newBuilder()
                .url(newUrl)
                .build();

        return chain.proceed(request);
    }
}
