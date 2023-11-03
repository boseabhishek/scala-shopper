package com.scalashopper.v1

import org.scalatest.flatspec.AnyFlatSpec

class ShoppingCartSpec extends AnyFlatSpec {

  "checkout" should "throw NotImplementedError" in {
    val sc = new ShoppingCart()
    val basket = List()
    val exception = intercept[NotImplementedError] {
      sc.checkout(basket)
    }
    assert(exception.getMessage.equalsIgnoreCase("checkout not implemented"))
  }

  "onlyApplesOrOranges" should "return empty list when basket is empty" in {
    val sc = new ShoppingCart()
    val items = List.empty[String]
    assert(sc.onlyApplesOrOranges(items) == Nil)
  }

  "onlyApplesOrOranges" should "return empty list when no matching items found is basket" in {
    val sc = new ShoppingCart()
    val items = List("banana", "fig", "grape")
    assert(sc.onlyApplesOrOranges(items) == Nil)
  }

  "onlyApplesOrOranges" should "ignore item(s) when basket has items which are not apples or oranges" in {
    val sc = new ShoppingCart()
    val items = List("apple", "banana", "apple", "orange", "fig", "grape")
    assert(sc.onlyApplesOrOranges(items) == List("apple", "apple", "orange"))
  }


}