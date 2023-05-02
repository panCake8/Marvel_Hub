package com.example.marvel_hub.data.api.interceptor

import com.example.marvel_hub.BuildConfig
import com.example.marvel_hub.data.api.util.ApiKeyHashGenerator
import okhttp3.Interceptor
import okhttp3.Response


class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val url = original.url.newBuilder()
            .addQueryParameter("ts", ApiKeyHashGenerator().getTimeStamp())
            .addQueryParameter("apikey", BuildConfig.PUBLIC_API_KEY)
            .addQueryParameter("hash", ApiKeyHashGenerator().getHash())
            .build()

        val request = original.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}