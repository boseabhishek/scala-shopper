package com.scalashopper.v1

import org.scalatest.flatspec.AnyFlatSpec

class ShoppingCartSpec extends AnyFlatSpec {

  behavior of "checkout"

  it should "throw NotImplementedError" in {
    val sc = new ShoppingCart()
    val basket = List()
    val exception = intercept[NotImplementedError] {
      sc.checkout(basket)
    }
    assert(exception.getMessage.equalsIgnoreCase("checkout not implemented"))
  }

  behavior of "onlyApplesOrOranges"

  it should "return empty list when basket is empty" in {
    val sc = new ShoppingCart()
    val items = List.empty[String]
    assert(sc.onlyApplesOrOranges(items) == Nil)
  }

  it should "ignore item(s) which are not apples or oranges" in {
    val sc = new ShoppingCart()
    val items = List("apple", "banana", "apple", "orange", "fig", "grape")
    assert(sc.onlyApplesOrOranges(items) == List("apple", "apple", "orange"))
  }

  it should "return empty list when no matching items found" in {
    val sc = new ShoppingCart()
    val items = List("banana", "fig", "grape")
    assert(sc.onlyApplesOrOranges(items) == Nil)
  }

}