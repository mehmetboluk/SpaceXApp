package com.mehmetboluk.spacexapp.repository

import com.mehmetboluk.spacexapp.service.ApiService
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val apiService: ApiService
){
    suspend fun makeApiCallFilter(date : Int? = null) = apiService.getSpaceXApiFilter(date)

}