package com.example.marvel_hub.data.util

import com.example.marvel_hub.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest

class ApiKeyHashGenerator {

    fun getHash(timeStamp: String): String {
        val apiKey =
            "$timeStamp${BuildConfig.PRIVATE_API_KEY}${BuildConfig.PUBLIC_API_KEY}"
        val messageDigest = MessageDigest.getInstance(HASH_ALGORITHM_TYPE)

        return BigInteger(
            SIG_NUM,
            messageDigest.digest(apiKey.toByteArray())
        ).toString(RADIX)
            .padStart(LENGTH, PAD_CHAR)
    }

    companion object {
        private const val HASH_ALGORITHM_TYPE = "MD5"
        private const val RADIX = 16
        private const val SIG_NUM = 1
        private const val LENGTH = 1
        private const val PAD_CHAR = '0'
    }
}