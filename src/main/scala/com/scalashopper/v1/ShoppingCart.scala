package com.scalashopper.v1

class ShoppingCart {
  def checkout(basket: List[String]): Double = {
    throw new NotImplementedError("checkout not implemented")
  }
  def onlyApplesOrOranges(items: List[String]): List[String] = {
    items.filter(item => item.equalsIgnoreCase("apple") | item.equalsIgnoreCase("orange"))
  }
}