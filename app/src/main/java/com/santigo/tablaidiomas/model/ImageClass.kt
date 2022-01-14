package com.santigo.tablaidiomas.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santigo.tablaidiomas.services.APIService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImageClass(): ViewModel() {

    var imagesList = listOf(
        ImageButton(
            "1",
            "imagen de prueba",
            "https://drive.google.com/file/d/1yr_nhMEmOLkbs_y_JlSxDyFWkntGaicY/view?usp=sharing",
        ),
        ImageButton(
            "2",
            "imagen de prueba",
            "https://drive.google.com/file/d/1y6ULoHiEvZp2Jt9pnqTHdNKF4UMF0cyV/view?usp=sharing",
        )
    )

    var imagesListMutable by mutableStateOf(imagesList)
    private val isLoading = MutableLiveData(false)
    fun isLoading(): LiveData<Boolean> = isLoading




//    fun getRandomImageApi() {
//        isLoading.postValue(true)
//
//        viewModelScope.launch() {
//            val env = System.getenv("config")
//
//            println(env)
//            val call = getRetrofit().create(APIService::class.java)
//                .getRandomImage("random?client_id=okTUdfxNZJjAmiu8sirizJSXu9_1hfOiEtNyaAbyqGk&count=${Constants.count}")
//            val imageAux = call.body()
//            if (call.isSuccessful) {
//
//                if (imageAux != null) {
//
//                    imagesListMutable = imageAux
//                    println("en la llamada a la api")
//                    isLoading.postValue(false)
//                    println(isLoading)
//                }
//            }
//        }
//    }

//    private fun getRetrofit(): Retrofit {
//
//        return Retrofit.Builder()
//            .baseUrl("https://api.unsplash.com/photos/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

}