package com.example.sustainafridge3

class Expire() {
    // maps common foods to the number of days after purchasing that they will expire
    val ExpireList = mapOf<String, Int>("milk" to 7, "eggs" to 21, "deli meat" to 5, "ground meat" to 2, "steak" to 4,
        "blackberries" to 4, "grapes" to 7, "pineapple" to 5, "strawberries" to 3, "watermelon" to 4, "buttermilk" to 14,
        "butter" to 90, "shrimp" to 4, "chicken" to 2, "fish" to 2, "salad" to 3, "bacon" to 7, "turkey" to 2, "asparagus" to 3,
        "bell pepper" to 9, "broccoli" to 4, "cauliflower" to 4, "brussels sprouts" to 4, "cabbage" to 10,
        "carrots" to 14, "celery" to 10, "parsnip" to 14, "cucumber" to 5, "eggplant" to 5, "kale" to 4, "spinach" to 5,
        "zucchini" to 7, "peach" to 4, "nectarine" to 4, "plum" to 4, "pear" to 4, "mango" to 7, "cherries" to 4,
        "shredded cheese" to 21, "sliced cheese" to 21, "yogurt" to 10, "cream cheese" to 14, "apple" to 14, "bok choy" to 3, "mushrooms" to 5,
        "onions" to 30, "tomato" to 7, "lettuce" to 7, "sour cream" to 14, "heavy whipping cream" to 21, "green beans" to 7,
        "avocado" to 7,"peas" to 8, "jalapenos" to 7, "corn" to 5, "honeydew melon" to 10)

    // checks if given key is found in the map
    // otherwise we can have the user input an expiration date?
    fun InList(food: String): Boolean{
        return ExpireList.containsKey(food)
    }

    //getter for value from map from key(food type)
    // returns int of # of days until it expires
    // also i fr don't know why i needed that '?' by the return type
    fun DaysToExpire(food: String): Int {
        val daysLeft = ExpireList[food]


        if(daysLeft != null){
            return daysLeft
        } else {
            return -1
        }
    }
}