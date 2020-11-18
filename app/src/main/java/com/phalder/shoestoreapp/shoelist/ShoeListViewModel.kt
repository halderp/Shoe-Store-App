package com.phalder.shoestoreapp.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phalder.shoestoreapp.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()
    val shoeListLiveData : LiveData<List<Shoe>>
        get() = _shoeListLiveData
    // Constructor
    init {
        Log.i("ShoeListViewModel","ShoeListViewModel Created")
        seedDataInShoeList()
    }

    private fun seedDataInShoeList() {
        // Add some shoes
        var shoeList = mutableListOf<Shoe>()
        shoeList.add(Shoe(name = "Runner1",size= 10.0,company = "Nike",description = "Running shoe"))
        shoeList.add(Shoe(name = "Runner2",size= 11.0,company = "Addidas",description = "Walking shoe"))
        shoeList.add(Shoe(name = "Slider1",size= 11.0,company = "Reebok",description = "Sliding shoe"))
        _shoeListLiveData.value = shoeList;

    }

    // Destructor
    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListViewModel","ShoeListViewModel Destroyed")
    }
}