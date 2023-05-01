package com.example.marvel_hub.util

import com.example.marvel_hub.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {

    private val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
    private const val HASH_ALGORITHM = "MD5"
    private const val RADIX = 16
    private const val SIG_NUM = 1
    private const val LENGTH = 1
    private const val PAD_CHAR = '0'
    fun toHash(): String {
        val input = "$timeStamp${BuildConfig.PRIVATE_API_KEY}${BuildConfig.PUBLIC_API_KEY}"
        val messageDigest = MessageDigest.getInstance(HASH_ALGORITHM)
        return BigInteger(
            SIG_NUM, messageDigest
                .digest(input.toByteArray())
        )
            .toString(RADIX)
            .padStart(LENGTH, PAD_CHAR)
    }
}