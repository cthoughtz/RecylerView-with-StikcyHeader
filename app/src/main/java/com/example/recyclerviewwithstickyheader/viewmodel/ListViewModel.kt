package com.example.recyclerviewwithstickyheader.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewwithstickyheader.model.AnimalNames

class ListViewModel : ViewModel() {

    var animalInfo = MutableLiveData<ArrayList<AnimalNames>>()
    var plainInfo = ArrayList<AnimalNames>()


    fun fetchData(){

        var mockData = arrayListOf(
            AnimalNames("Abyssinian"),
            AnimalNames("Penguin"),
            AnimalNames("Affenpinscher"),
            AnimalNames("Afghan Hound"),
            AnimalNames("African Bush Elephan"),
            AnimalNames("Ant"),
            AnimalNames("Zebra"),
            AnimalNames("Ostrich"),
            AnimalNames("Yo Momma"),
            AnimalNames("Eagle"),
            AnimalNames("Elephant"),
            AnimalNames("Dove"),
            AnimalNames("Spider"),
            AnimalNames("Ant"),
            AnimalNames("Gorilla"),
            AnimalNames("Lion"),
            AnimalNames("Tiger"),
            AnimalNames("Liger"),
            AnimalNames("Cheetah"),
            AnimalNames("Jaguar"),
            AnimalNames("Mouse"),
            AnimalNames("Monkey"),
            AnimalNames("Bat"),
            AnimalNames("Bengal"),
            AnimalNames("Falcon"),
            AnimalNames("Tasmanian Devil"),
            AnimalNames("Shark"),
            AnimalNames("Sea Weed"),
            AnimalNames("Frog"),
            AnimalNames("Centipede"),
            AnimalNames("Human"),
            AnimalNames("Orangatan"),
            AnimalNames("GrassHopper"),
            AnimalNames("Preying Mantis"),
            AnimalNames("Bee"),
            AnimalNames("Wasp"),
            AnimalNames("dodo bird"),
            AnimalNames("Angel Fish"),
            AnimalNames("Ant Eater"),
            AnimalNames("Giant Hornet"),
            AnimalNames("Wolf"),
            AnimalNames("Hare"),
            AnimalNames("Fox"),
            AnimalNames("Baboon"),
            AnimalNames("Bacteria"),
            AnimalNames("Camel"),
            AnimalNames("Badger"),
            AnimalNames("Barb"),
            AnimalNames("Bison"),
            AnimalNames("Abyssinian"),
            AnimalNames("Abyssinian"),
            AnimalNames("Abyssinian"),
            AnimalNames("Abyssinian"),
            AnimalNames("Abyssinian"),
            AnimalNames("Abyssinian")

        ).apply {sortBy { it.name } }

        animalInfo.value = mockData
        plainInfo = mockData
    }
}