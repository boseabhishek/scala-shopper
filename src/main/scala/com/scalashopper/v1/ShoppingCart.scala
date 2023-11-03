package com.scalashopper.v1

class ShoppingCart {
  def checkout(items: List[Item]): Double = {
    val apples = items.collect { case a: Apple => a }
    val oranges = items.collect { case o: Orange => o }

    // Ruling out invalid or no offers
    val costOfOrangesNotOnOffer: Double = oranges.
      filter(o => o.offer.isEmpty || !o.offer.contains(ThreeForTwo)).
      foldLeft(0.0)((acc: Double, o: Orange) => acc + o.price)

    // Ruling out invalid or no offers
    val costOfApplesNotOnOffer: Double = apples.
      filter(a => a.offer.isEmpty || !a.offer.contains(BuyOneGetOne)).
      foldLeft(0.0)((acc: Double, a: Apple) => acc + a.price)

    // ONLY considering 3 for the price of 2 on Oranges
    // ONLY considering unit price for oranges as 25p
    // Other price/offers might not be participating in this offer.
    val oranges3for2Count: Int = oranges.count { o =>
      o.offer.contains(ThreeForTwo) && o.price == 0.25
    }

    val costOfOrangesAfterOffer: Double = ((oranges3for2Count / 3) * 2 + oranges3for2Count % 3) * 0.25

    // ONLY considering buy one, get one free on Apples
    // ONLY considering unit price for oranges as 60p
    // Other price/offers might not be participating in this offer.
    val applesBuy1Get1Count: Int = apples.count { a =>
      a.offer.contains(BuyOneGetOne) && a.price == 0.60
    }

    val costOfApplesAfterOffer: Double = (applesBuy1Get1Count / 2 + applesBuy1Get1Count % 2) * 0.60

    costOfApplesAfterOffer + costOfApplesNotOnOffer + costOfOrangesAfterOffer + costOfOrangesNotOnOffer

  }

}