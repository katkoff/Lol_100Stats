package com.katkov.lolachievements.di.provider

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.utils.ApiUtils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

class LolApiServiceProvider
@Inject
constructor(
    private val okHttpClient: OkHttpClient,
    private val rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
    private val gsonConverterFactory: GsonConverterFactory
) : Provider<ApiService> {

    override fun get(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiUtils.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}
