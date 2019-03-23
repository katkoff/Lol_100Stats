package com.katkov.lolachievements.di.provider

import com.katkov.lolachievements.data.cloud.intercepter.ServerNameInterceptor
import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder
import okhttp3.Interceptor
import javax.inject.Inject
import javax.inject.Provider

class ServerNameInterceptorProvider
@Inject
internal constructor(private val entryInfoHolder: EntryInfoHolder) : Provider<Interceptor> {

    override fun get(): Interceptor {
        return ServerNameInterceptor(entryInfoHolder)
    }
}
