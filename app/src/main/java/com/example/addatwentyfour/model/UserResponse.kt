package com.example.addatwentyfour.model

import com.google.gson.annotations.SerializedName


data class UserResponse (

	@SerializedName("code") val code : Int,
	@SerializedName("meta") val meta : Meta,
	@SerializedName("data") val data : List<UserDataModel>
)