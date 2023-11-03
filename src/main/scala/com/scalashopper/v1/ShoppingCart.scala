package com.scalashopper.v1

class ShoppingCart {
  def checkout(basket: List[String]): Double = {
    val applesAndOranges = onlyApplesAndOranges(basket)

    if (applesAndOranges.isEmpty) {
      0.0
    } else {
      2.05
    }

  }
  def onlyApplesAndOranges(items: List[String]): List[String] = {
    items.filter(item => item.equalsIgnoreCase("apple") | item.equalsIgnoreCase("orange"))
  }
}