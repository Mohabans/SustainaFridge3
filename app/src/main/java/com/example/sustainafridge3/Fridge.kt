package com.example.sustainafridge3

class Fridge (invList: MutableList<Item>){

    var inventoryList : MutableList<Item> = invList

    fun addItem(item: Item) {
          inventoryList.add(item)
    }

    fun nameList(): MutableList<String>{

        var namesList : MutableList<String> = mutableListOf()

        for( element in this.inventoryList){

            namesList.add(element.name + "  -  " + element.daysRemaining.toString() + " days until expired")

        }

        return namesList
    }
    private fun addItemCam(){

    }

    private fun remove(){

    }

}