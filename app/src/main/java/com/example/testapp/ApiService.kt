package com.example.testapp

import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory


interface ApiService {


    @GET("photos")
    suspend fun getArticleData():Response<List<MyDataItem>>

       companion object {



           var apiService:ApiService? = null

           fun getInstance() : ApiService {

               if(apiService == null){
                   val retrofit = Retrofit.Builder()
                       .baseUrl("https://jsonplaceholder.typicode.com/")
                       .addConverterFactory(GsonConverterFactory.create())
                       .build()

                   apiService = retrofit.create(ApiService::class.java)
               }

               return apiService!!
           }

       }
}