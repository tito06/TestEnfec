package com.example.testapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataVm:ViewModel() {

   var data: List<MyDataItem> by mutableStateOf(listOf())



    fun getData(){

        val apiService:ApiService = ApiService.getInstance()


        viewModelScope.launch {
            try {
                val dataarticle = apiService.getArticleData()
                if (dataarticle.isSuccessful){
                    data = dataarticle.body()!!
                }else{

                    print("")
                }
            }catch (e:Exception){

            }
        }

    }

}