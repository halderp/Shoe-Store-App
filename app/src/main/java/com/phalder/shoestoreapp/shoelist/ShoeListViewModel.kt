package com.phalder.shoestoreapp.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phalder.shoestoreapp.models.Shoe

class ShoeListViewModel : ViewModel() {

    private var isLoggedIn: Boolean = false
    val isLoggedInLiveData = MutableLiveData<Boolean>()

    private lateinit var shoeList: MutableList<Shoe>
    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()
    val shoeListLiveData : LiveData<List<Shoe>>
        get() = _shoeListLiveData
    // Constructor
    init {
        Log.i("ShoeListViewModel","ShoeListViewModel Created")
        isLoggedInLiveData.value = isLoggedIn
        seedDataInShoeList()
    }



    private fun seedDataInShoeList() {
        // Add some shoes
        shoeList = mutableListOf<Shoe>()
        shoeList.add(Shoe(name = "Air Jordan 1 Mid SE",size= 10.0,company = "Nike",description = "One of history's most iconic sneakers takes on new colors and materials to give it fresh distinction. The Air Jordan 1 Mid SE offers a mix of colors and textures, highlighted by the stitch outline Swoosh design."))
        shoeList.add(Shoe(name = "Nike Air Max 90",size= 11.0,company = "Nike",description = "The Nike Air Max 90 stays true to its OG roots with the iconic Waffle outsole, stitched overlays and classic TPU accents. Fresh colors give a modern look while Max Air cushioning adds comfort to your journey."))
        shoeList.add(Shoe(name = "Nike Air Max Up",size= 11.0,company = "Nike",description = "Inspired by the lifted look of the Air Max Dia, the large, visible Air in the Nike Air Max Up boosts you above the noise. Get into it with the fun leopard print that can be dressed up or down. The platform is yours."))
        shoeList.add(Shoe(name = "Zoom Freak 2",size= 11.0,company = "Nike",description = "Giannis possesses a freakish combination of height, length and speed rarely seen in the league. The Zoom Freak 2 harnesses his power and helps enable him to generate force to help drive him down the court. A molded overlay caps the outer toe area to help contain Giannis' devastating Euro step move."))
        shoeList.add(Shoe(name = "Nike Air Max 1 N7",size= 11.0,company = "Nike",description = "Celebrating the proud history of Native Americans and Indigenous peoples in North America, the Nike Air Max 1 N7 brings the revolutionary track silhouette into a new realm. The raised haptic graphic honors the vibrant patterns of certain Native artwork while paying tribute to the gifts given at the Standing Rock Sioux Tribe's traditional naming ceremonies. The rubber Waffle outsole and soft suede upper finish off the iconic look."))
        shoeList.add(Shoe(name = "Kyrie 7 \"Sisterhood\"",size= 11.0,company = "Nike",description = "Kyrie made headlines with his generous, outspoken support of female ballers. Nike is joining him with the special “Sisterhood” colorway of the Kyrie 7, which aims to empower and unify the support of women athletes everywhere. The eye-grabbing aesthetic is highlighted by a detailed floral graphic underneath the pop of its yellow-outlined Swoosh logo. On or off the court, show your support for women athletes in style."))

        _shoeListLiveData.value = shoeList;

    }

    fun addShoeToList(newShoe:Shoe){
        // this should update the Live Data of Shoe List and UI will get updated accordingly
        shoeList.add(newShoe)

    }

    // Destructor
    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListViewModel","ShoeListViewModel Destroyed")
    }

    fun logInCompleted(){
        isLoggedIn = true
        isLoggedInLiveData.value = isLoggedIn
    }
}