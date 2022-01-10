package com.mehmetboluk.spacexapp.service

import com.mehmetboluk.spacexapp.service.model.LaunchModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://api.spacexdata.com/v2/launches


    @GET("launches/")
    suspend fun getSpaceXApiFilter(
        @Query("launch_year")
        launch_year : Int? = null) : LaunchModel


}