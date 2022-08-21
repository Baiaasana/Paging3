package com.example.apiwithpaging3.network

import com.example.apiwithpaging3.models.PersonModel
import retrofit2.http.GET
import retrofit2.http.Query


interface PersonApi {

    @GET("users")
    suspend fun getPersonData(@Query("page") page: Int): PersonModel

}


