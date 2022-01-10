package com.mehmetboluk.spacexapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehmetboluk.spacexapp.repository.MainRepository
import com.mehmetboluk.spacexapp.service.model.LaunchModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel(){

    private val _apiResponse = MutableLiveData<LaunchModel>()
    val apiResponse : LiveData<LaunchModel> get()=_apiResponse


    fun makeApiCallFilter(date : Int? = null) = viewModelScope.launch {
        _apiResponse.postValue(
            mainRepository.makeApiCallFilter(date)
        )
    }

}