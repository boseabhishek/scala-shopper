package com.scalashopper.v1

import org.scalatest.flatspec.AnyFlatSpec

class ShoppingCartSpec extends AnyFlatSpec {

  behavior of "checkout"

  it should "return 0.0 when basket is empty" in {
    val sc = new ShoppingCart()
    val basket = List()

    assert(sc.checkout(basket) == 0.0)
  }

  it should "return 2.05 when basket has 3 apples and one orange" in {
    val sc = new ShoppingCart()
    val basket = List("apple", "apple", "apple", "orange")

    assert(sc.checkout(basket) == 2.05)
  }

  it should "return 0.85 when basket has one apple and one orange" in {
    val sc = new ShoppingCart()
    val basket = List("apple", "orange")

    assert(sc.checkout(basket) == 0.85)
  }

  behavior of "onlyApplesOrOranges"

  it should "return empty list when basket is empty" in {
    val sc = new ShoppingCart()
    val items = List.empty[String]
    assert(sc.onlyApplesAndOranges(items) == Nil)
  }

  it should "ignore item(s) which are not apples or oranges" in {
    val sc = new ShoppingCart()
    val items = List("apple", "banana", "apple", "orange", "fig", "grape")
    assert(sc.onlyApplesAndOranges(items) == List("apple", "apple", "orange"))
  }

  it should "return empty list when no matching items found" in {
    val sc = new ShoppingCart()
    val items = List("banana", "fig", "grape")
    assert(sc.onlyApplesAndOranges(items) == Nil)
  }

}