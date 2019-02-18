package com.katkov.lolachievements.di.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.pwittchen.prefser.library.rx2.Prefser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.katkov.lolachievements.data.cloud.api.ApiService;
import com.katkov.lolachievements.data.cloud.utils.ApiUrlUtils;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import toothpick.config.Module;

public class CommonModule extends Module {

    public static final String LOL_PREFERENCE = "lol_preference";

    public CommonModule(Context context) {
        bind(Context.class).toInstance(context);
        bind(SharedPreferences.class)
                .toInstance(context.getSharedPreferences(LOL_PREFERENCE, Context.MODE_PRIVATE));

        bind(OkHttpClient.class)
                .toProvider(OkHttpClientProvider.class)
                .providesSingletonInScope();

        bind(Gson.class).toInstance(new GsonBuilder().create());

        bind(GsonConverterFactory.class)
                .toInstance(GsonConverterFactory.create());

        bind(RxJava2CallAdapterFactory.class)
                .toInstance(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()));

        bind(Interceptor.class)
                .toProvider(LoggingInterceptorProvider.class)
                .providesSingletonInScope();

        bind(ApiService.class)
                .toProvider(LolApiServiceProvider.class)
                .providesSingletonInScope();

        bind(Prefser.class)
                .toProvider(PrefserProvider.class)
                .singletonInScope();
    }

    /**
     * PREFSER
     */

    public static final class PrefserProvider implements Provider<Prefser> {

        private final SharedPreferences sharedPreferences;

        @Inject
        public PrefserProvider(SharedPreferences sharedPreferences) {
            this.sharedPreferences = sharedPreferences;
        }

        @Override
        public Prefser get() {
            return new Prefser(sharedPreferences);
        }
    }

    /**
     * OKHTTP
     */

    public static final class OkHttpClientProvider implements Provider<OkHttpClient> {

        private final Interceptor interceptor;

        @Inject
        public OkHttpClientProvider(Interceptor interceptor) {
            this.interceptor = interceptor;
        }


        @Override
        public OkHttpClient get() {
            return new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
        }
    }

    /**
     * RETROFIT
     */
    public static final class LolApiServiceProvider implements Provider<ApiService> {

        private final OkHttpClient okHttpClient;
        private final RxJava2CallAdapterFactory rxJava2CallAdapterFactory;
        private final GsonConverterFactory gsonConverterFactory;

        @Inject
        public LolApiServiceProvider(OkHttpClient okHttpClient, RxJava2CallAdapterFactory rxJava2CallAdapterFactory, GsonConverterFactory gsonConverterFactory) {
            this.okHttpClient = okHttpClient;
            this.rxJava2CallAdapterFactory = rxJava2CallAdapterFactory;
            this.gsonConverterFactory = gsonConverterFactory;
        }

        @Override
        public ApiService get() {
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUrlUtils.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJava2CallAdapterFactory)
                    .build();
            return retrofit.create(ApiService.class);
        }
    }

    /**
     * LOGGING INTERCEPTER
     */

    public static final class LoggingInterceptorProvider implements Provider<Interceptor> {

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
}