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
}