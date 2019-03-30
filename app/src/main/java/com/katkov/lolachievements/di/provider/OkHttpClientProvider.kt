package com.katkov.lolachievements.di.provider

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class OkHttpClientProvider
@Inject
constructor(
    @param:Named("logInterceptor")
    private val loggingInterceptor: Interceptor,
    @param:Named("serverNameInterceptor")
    private val serverNameInterceptor: Interceptor
) : Provider<OkHttpClient> {

    override fun get(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(serverNameInterceptor)
            .build()
    }
}
