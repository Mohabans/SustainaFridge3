package com.example.sustainafridge3

enum class Remaining {
    FULL,
    SEVENTYFIVE,
    FIFTY,
    TWENTYFIVE,
    EMPTY
}


class Item(var name: String) {
    var portion: Remaining = Remaining.FULL
        private set

    //var expirationDate :

    var owner: String = ""
        private set

    fun useItem(usedPortion: Remaining) {
        portion = usedPortion
    }

    fun assignOwnership(newOwner: String) {
        owner = newOwner
    }

}