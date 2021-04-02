package com.example.addatwentyfour.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.addatwentyfour.model.UserResponse
import com.example.addatwentyfour.retrofit.RetrofitApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel: ViewModel() {
    var userData: MutableLiveData<UserResponse> = MutableLiveData()


    init {
        getUserData()
    }

     private fun getUserData(){
        viewModelScope.launch(Dispatchers.IO) {
            val responseData: UserResponse? = RetrofitApi.initRetroFit().getUser().body()
             withContext(Dispatchers.Main){
                 userData.value = responseData
             }
        }
    }

}