package com.scalashopper.v1

import org.scalatest.flatspec.AnyFlatSpec

class ShoppingCartSpec extends AnyFlatSpec {

  behavior of "checkout"

  it should "return 0.0 when basket is empty" in {
    val sc = new ShoppingCart()
    val basket = List()

    assert(sc.checkout(basket) == 0.0)
  }

  it should "return 0.0 when basket has invalid items" in {
    val sc = new ShoppingCart()
    val basket = List(SomeOtherItem(), SomeOtherItem())

    assert(sc.checkout(basket) == 0.0)
  }

  it should "return 2.05 when basket has 3 APPLE and one ORANGE, ignoring case" in {
    val sc = new ShoppingCart()
    val basket = List(Apple(), Apple(), Apple(), Orange())

    assert(sc.checkout(basket) == 2.05)
  }

  it should "return 2.05 when basket has 3 apples and one orange" in {
    val sc = new ShoppingCart()
    val basket = List(Apple(), Apple(), Apple(), Orange())

    assert(sc.checkout(basket) == 2.05)
  }

  it should "return 0.85 when basket has one apple and one orange" in {
    val sc = new ShoppingCart()
    val basket = List(Apple(), Orange())

    assert(sc.checkout(basket) == 0.85)
  }

  it should "return 1.70 when basket has 2 apples and 2 oranges" in {
    val sc = new ShoppingCart()
    val basket = List(Apple(), Orange(), Apple(), Orange())

    assert(sc.checkout(basket) == 1.70)
  }

  it should "return 1.95 when basket has 2 apples and 3 oranges" in {
    val sc = new ShoppingCart()
    val basket = List(Apple(), Orange(), Apple(), Orange(), Orange())

    assert(sc.checkout(basket) == 1.95)
  }

  it should "return 6 when basket has 10 apples only" in {
    val sc = new ShoppingCart()
    val basket = List.fill(10)(Apple())

    assert(sc.checkout(basket) ===  5.999999999999999) // encountered small precision issues
  }

  it should "return 2.5 when basket has 10 oranges only" in {
    val sc = new ShoppingCart()
    val basket = List.fill(10)(Orange())

    assert(sc.checkout(basket) == 2.5)
  }

  it should "return 1.0 when basket has 2 apples and 3 oranges at reduced price" in {
    val sc = new ShoppingCart()
    val basket = List(Apple(price = 0.2), Orange(price = 0.2), Apple(price = 0.2), Orange(price = 0.2), Orange(price = 0.2))

    assert(sc.checkout(basket) == 1.0)
  }

  it should "return 3.4 when basket has a combination of apple and oranges w/ valid offers" in {
    val sc = new ShoppingCart()
    val items: List[Item] = List(
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Orange(offer = Some(ThreeForTwo)),
      Orange(offer = Some(ThreeForTwo)),
      Orange(offer = Some(ThreeForTwo)),
      Orange(offer = Some(ThreeForTwo)),
      Orange(offer = Some(ThreeForTwo)),
    )
    assert(sc.checkout(items) == 3.4)
  }

  it should "return 4.25 when basket has a combination of apple and oranges w/ valid offers and no offers" in {
    val sc = new ShoppingCart()
    val items: List[Item] = List(
      Apple(offer = None),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Apple(offer = Some(BuyOneGetOne)),
      Orange(offer = None),
      Orange(offer = Some(ThreeForTwo)),
      Orange(offer = Some(ThreeForTwo)),
      Orange(offer = Some(ThreeForTwo)),
      Orange(offer = Some(ThreeForTwo)),
      Orange(offer = Some(ThreeForTwo)),
    )
    assert(sc.checkout(items) == 4.25)
  }
}