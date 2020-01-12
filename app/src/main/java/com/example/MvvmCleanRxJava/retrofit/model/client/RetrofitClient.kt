package com.example.MvvmCleanRxJava.retrofit.model.client

import android.annotation.SuppressLint
import android.app.Activity
import com.example.MvvmCleanRxJava.BuildConfig
import com.example.MvvmCleanRxJava.retrofit.model.ApiList
import com.example.MvvmCleanRxJava.retrofit.model.config.ApiConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException

fun Retrofit.getApiList(): ApiList = this.create(ApiList::class.java)

object RetrofitClient {

    fun getConnect(activity: Activity? = null) = getClient(activity).getApiList()

    private fun getClient(activity: Activity? = null): Retrofit {
        val header = getOkHTTP()
        return Retrofit.Builder()
            .baseUrl(ApiConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(header)
            .build()
    }

    private fun getOkHTTP(): OkHttpClient {
        val client: OkHttpClient.Builder = OkHttpClient.Builder()
        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
            ApiConfig.HEADER.forEach { map ->
                request.addHeader(map.key, map.value)
            }
            chain.proceed(request.build())
        }

        setOkHTTPSettings(client, interceptor)
        setSllConfig(client)
        return client.build()
    }

    private fun setOkHTTPSettings(
        client: OkHttpClient.Builder,
        interceptorWithHeaders: Interceptor
    ) {
        client.addInterceptor(interceptorWithHeaders)
        client.connectTimeout(ApiConfig.TIMER_OUT_MINUTE.toLong(), TimeUnit.MINUTES)
        client.writeTimeout(ApiConfig.TIMER_OUT_MINUTE.toLong(), TimeUnit.MINUTES)
        client.readTimeout(ApiConfig.TIMER_OUT_MINUTE.toLong(), TimeUnit.MINUTES)

        val log = HttpLoggingInterceptor()
        when (BuildConfig.DEBUG) {
            true -> log.level = HttpLoggingInterceptor.Level.BODY
            false -> log.level = HttpLoggingInterceptor.Level.NONE
        }
        client.addInterceptor(log)
    }

    private fun setSllConfig(client: OkHttpClient.Builder) {
        try {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return emptyArray()
                }

                @SuppressLint("TrustAllX509TrustManager")
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                @SuppressLint("TrustAllX509TrustManager")
                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }
            })

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory

            client.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            client.hostnameVerifier { _, _ -> true }
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}