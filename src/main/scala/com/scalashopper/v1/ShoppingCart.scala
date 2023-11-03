package com.scalashopper.v1

class ShoppingCart {
  def checkout(basket: List[Item]): Double = {
    val apples = basket.collect { case a: Apple => a }
    val oranges = basket.collect { case o: Orange => o }

    val unitApplePrice: Double = 0.60
    val unitOrangePrice: Double = 0.25

    val totalApplePrice = apples.size * unitApplePrice
    val totalOrangePrice = oranges.size * unitOrangePrice

    totalApplePrice + totalOrangePrice

  }

}