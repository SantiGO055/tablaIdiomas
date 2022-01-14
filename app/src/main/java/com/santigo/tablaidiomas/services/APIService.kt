package com.santigo.tablaidiomas.services

import com.santigo.tablaidiomas.model.ImageButton
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getRandomImage(@Url url: String): Response<List<ImageButton>>
}