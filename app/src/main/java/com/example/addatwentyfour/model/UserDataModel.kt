package com.example.addatwentyfour.model
import com.google.gson.annotations.SerializedName



data class UserDataModel (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("email") val email : String,
	@SerializedName("gender") val gender : String,
	@SerializedName("status") val status : String,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("updated_at") val updated_at : String
)