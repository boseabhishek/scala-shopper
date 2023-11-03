package com.scalashopper.v1

class ShoppingCart {
  def checkout(basket: List[String]): Double = {
    val applesAndOranges = onlyApplesAndOranges(basket)

    val totalApplePrice = applesAndOranges.count(x => x.equalsIgnoreCase("apple")) * 0.60
    val totalOrangePrice = applesAndOranges.count(x => x.equalsIgnoreCase("orange")) * 0.25

    totalApplePrice + totalOrangePrice

  }

  def onlyApplesAndOranges(items: List[String]): List[String] = {
    items.filter(item => item.equalsIgnoreCase("apple") | item.equalsIgnoreCase("orange"))
  }
}