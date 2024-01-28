package com.example.sustainafridge3

class Fridge (invList: MutableList<Item>){

    var inventoryList : MutableList<Item> = invList

    fun addItem(item: Item) {
          inventoryList.add(item)
    }

    fun nameList(): MutableList<String>{
        val sortedItemsList : List<Item> = this.inventoryList.sortedBy{it.daysRemaining}
        var namesList : MutableList<String> = mutableListOf()

        for( element in sortedItemsList){

            namesList.add(element.name + "  -  " + element.daysRemaining.toString() + " days until expired")

        }

        return namesList
    }
    private fun addItemCam(){

    }

    fun remove(index: Int){
        val sortedItemsList : List<Item> = this.inventoryList.sortedBy{it.daysRemaining}
        val toRemove = sortedItemsList.elementAt(index)
        this.inventoryList.remove(toRemove)
    }

}