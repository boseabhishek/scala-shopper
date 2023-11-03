package com.scalashopper.v1

class ShoppingCart {
  def checkout(basket: List[String]): Double = {
    val applesAndOranges = onlyApplesAndOranges(basket)

    val unitApplePrice: Double = 0.60
    val unitOrangePrice: Double = 0.25

    val totalApplePrice = applesAndOranges.count(x => x.equalsIgnoreCase("apple")) * unitApplePrice
    val totalOrangePrice = applesAndOranges.count(x => x.equalsIgnoreCase("orange")) * unitOrangePrice

    totalApplePrice + totalOrangePrice

  }

  def onlyApplesAndOranges(items: List[String]): List[String] = {
    items.filter(item => item.equalsIgnoreCase("apple") | item.equalsIgnoreCase("orange"))
  }
}