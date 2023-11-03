package com.scalashopper.v1

class ShoppingCart {
  def checkout(basket: List[Item]): Double = {
    val apples = basket.collect { case a: Apple => a }
    val oranges = basket.collect { case o: Orange => o }

    val totalApplePrice = apples.foldLeft(0.0)((acc: Double, a: Apple) => acc + a.price)
    val totalOrangePrice = oranges.foldLeft(0.0)((acc: Double, o: Orange) => acc + o.price)

    totalApplePrice + totalOrangePrice

  }

}