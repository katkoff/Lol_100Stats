package com.katkov.lolachievements.data.cloud.intercepter

import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class ServerNameInterceptor
@Inject
constructor(private val entryInfoHolder: EntryInfoHolder) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val originalUrl = request.url()

        val serverCode = entryInfoHolder.getEntryInfo()!!.serverCode
        val newHost = serverCode + "." + originalUrl.host()
        val newUrl = request.url().newBuilder()
                .host(newHost)
                .build()

        request = request.newBuilder()
                .url(newUrl)
                .build()

        return chain.proceed(request)
    }
}
