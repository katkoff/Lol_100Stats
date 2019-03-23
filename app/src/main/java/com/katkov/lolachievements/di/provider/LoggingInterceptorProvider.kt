package com.katkov.lolachievements.di.provider

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject
import javax.inject.Provider

class LoggingInterceptorProvider
@Inject
internal constructor() : Provider<Interceptor> {

    override fun get(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}
