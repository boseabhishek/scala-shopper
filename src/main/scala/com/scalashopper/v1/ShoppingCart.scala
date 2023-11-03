package com.scalashopper.v1

class ShoppingCart {
  def checkout(items: List[Item]): Double = {
    val apples = items.collect { case a: Apple => a }
    val oranges = items.collect { case o: Orange => o }

    val oranges3for2Count: Int = oranges.count { o =>
      o.offer.contains(ThreeForTwo) && o.price == 0.25
    }

    val costOfOrangesAfterOffer: Double = ((oranges3for2Count / 3) * 2 + oranges3for2Count % 3) * 0.25

    val applesBuy1Get1Count: Int = apples.count { a =>
      a.offer.contains(BuyOneGetOne) && a.price == 0.60
    }

    val costOfApplesAfterOffer: Double = (applesBuy1Get1Count / 2 + applesBuy1Get1Count % 2) * 0.60

    costOfApplesAfterOffer + costOfOrangesAfterOffer
  }

}