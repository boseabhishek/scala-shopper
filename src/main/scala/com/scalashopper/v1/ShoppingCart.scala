package com.scalashopper.v1

class ShoppingCart {
  def checkout(basket: List[String]): Double = {
    val applesAndOranges = onlyApplesAndOranges(basket)

    if (applesAndOranges.isEmpty) {
      0.0
    } else {
      val appleCount = applesAndOranges.count(x => x.equalsIgnoreCase("apple"))
      val orangeCount = applesAndOranges.count(x => x.equalsIgnoreCase("orange"))

      if (appleCount == 1 && orangeCount == 1) {
        0.85
      } else {
        2.05
      }
    }

  }

  def onlyApplesAndOranges(items: List[String]): List[String] = {
    items.filter(item => item.equalsIgnoreCase("apple") | item.equalsIgnoreCase("orange"))
  }
}