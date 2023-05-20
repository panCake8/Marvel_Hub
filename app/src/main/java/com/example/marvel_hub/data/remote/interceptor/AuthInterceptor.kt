package com.example.marvel_hub.data.remote.interceptor

import com.example.marvel_hub.BuildConfig
import com.example.marvel_hub.data.util.ApiKeyHashGenerator
import com.example.marvel_hub.data.util.CurrentTimeStamp
import okhttp3.Interceptor
import okhttp3.Response


class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val timeStamp = CurrentTimeStamp().now()
        val url = original.url.newBuilder()
            .addQueryParameter("ts", timeStamp)
            .addQueryParameter("apikey", BuildConfig.PUBLIC_API_KEY)
            .addQueryParameter("hash", ApiKeyHashGenerator().getHash(timeStamp))
            .build()

        val request = original.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}