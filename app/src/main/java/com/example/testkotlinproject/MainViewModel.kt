package com.example.testkotlinproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _liveData = MutableLiveData<Model>()
    val liveData: LiveData<Model> = _liveData

    private val _detailLiveData = MutableLiveData<Model>()
    val detailLiveData: LiveData<Model> = _detailLiveData

    fun postUserInformation(title: String, description: String){
        _liveData.value = Model(title = title, description = description)

    }

    fun postDetailInfo(model: Model){
        _detailLiveData.value = model
    }


}