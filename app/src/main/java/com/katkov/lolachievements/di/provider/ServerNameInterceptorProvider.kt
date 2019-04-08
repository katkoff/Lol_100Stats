package com.katkov.lolachievements.di.provider

import com.katkov.lolachievements.data.cloud.intercepter.ServerNameInterceptor
import com.katkov.lolachievements.data.local.prefser.LoginModelHolder
import okhttp3.Interceptor
import javax.inject.Inject
import javax.inject.Provider

class ServerNameInterceptorProvider
@Inject
internal constructor(private val loginModelHolder: LoginModelHolder) : Provider<Interceptor> {

    override fun get(): Interceptor = ServerNameInterceptor(loginModelHolder)
}
