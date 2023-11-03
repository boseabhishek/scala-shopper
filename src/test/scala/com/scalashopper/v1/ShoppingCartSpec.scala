package com.scalashopper.v1

import org.scalatest.flatspec.AnyFlatSpec

class ShoppingCartSpec extends AnyFlatSpec {

  behavior of "checkout"

  it should "return 0.0 when basket is empty" in {
    val sc = new ShoppingCart()
    val basket = List()

    assert(sc.checkout(basket) == 0.0)
  }

  it should "return 0.0 when basket has invalid types" in {
    val sc = new ShoppingCart()
    val basket = List(new Invalid, new Invalid)

    assert(sc.checkout(basket) == 0.0)
  }

  it should "return 2.05 when basket has 3 APPLE and one ORANGE, ignoring case" in {
    val sc = new ShoppingCart()
    val basket = List(new Apple, new Apple, new Apple, new Orange)

    assert(sc.checkout(basket) == 2.05)
  }

  it should "return 2.05 when basket has 3 apples and one orange" in {
    val sc = new ShoppingCart()
    val basket = List(new Apple, new Apple, new Apple, new Orange)

    assert(sc.checkout(basket) == 2.05)
  }

  it should "return 0.85 when basket has one apple and one orange" in {
    val sc = new ShoppingCart()
    val basket = List(new Apple, new Orange)

    assert(sc.checkout(basket) == 0.85)
  }

  it should "return 1.70 when basket has 2 apples and 2 oranges" in {
    val sc = new ShoppingCart()
    val basket = List(new Apple, new Orange, new Apple, new Orange)

    assert(sc.checkout(basket) == 1.70)
  }

  it should "return 1.95 when basket has 2 apples and 3 oranges" in {
    val sc = new ShoppingCart()
    val basket = List(new Apple, new Orange, new Apple, new Orange, new Orange)

    assert(sc.checkout(basket) == 1.95)
  }

  it should "return 6 when basket has 10 apples" in {
    val sc = new ShoppingCart()
    val basket = List.fill(10)(new Apple)

    assert(sc.checkout(basket) == 6)
  }

  it should "return 2.5 when basket has 10 oranges" in {
    val sc = new ShoppingCart()
    val basket = List.fill(10)(new Orange)

    assert(sc.checkout(basket) == 2.5)
  }

}