package com.example.sustainafridge3

import java.util.Date

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

    var expireDate: Int = 0

    var daysRemaining: Int = 0

    var owner: String = ""
        private set

    fun useItem(usedPortion: Remaining) {
        portion = usedPortion
    }

    fun assignOwnership(newOwner: String) {
        owner = newOwner
    }

}