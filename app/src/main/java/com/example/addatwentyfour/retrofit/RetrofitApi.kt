package com.example.addatwentyfour.retrofit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApi {

    companion object {

        fun initRetroFit(): ApiInterFace {

            // For logging request & response (Optional)
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.apply {
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }

            val interceptor = Interceptor { chain: Interceptor.Chain ->
                val request = chain.request()
                val newRequest =
                        request.newBuilder() //.addHeader("Authorization", Global.ACCESS_TOKEN)
                                .build()
                chain.proceed(newRequest)
            }
            val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            builder.networkInterceptors().add(interceptor)
            val client: OkHttpClient = builder.addInterceptor(loggingInterceptor)
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl("https://gorest.co.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit.create(ApiInterFace::class.java)
        }

    }
}