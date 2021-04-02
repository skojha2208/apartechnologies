package com.example.addatwentyfour.retrofit

import com.example.addatwentyfour.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterFace {

    @GET("public-api/users/")
    suspend fun getUser(): Response<UserResponse>


}