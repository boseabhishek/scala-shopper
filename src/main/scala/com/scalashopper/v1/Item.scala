package com.scalashopper.v1

trait Item {
  val price: Double
  val offer: Option[Offer]
}

// allowing one offer per item
sealed trait Offer
case object BuyOneGetOne extends Offer
case object ThreeForTwo extends Offer
case class Invalid(price: Double = 0.0, offer: Option[Offer] = None) extends Item

// Fruits can have their own properties for later.
trait Fruit extends Item

// price for individual apples and oranges can be different as scanned via barcodes
// offer is added on individual apples and oranges as some barcode doesn't allow offers :(
// <happens so many times in a supermarket! smh>
case class Apple(price: Double = 0.6, offer: Option[Offer] = None) extends Fruit
case class Orange(price: Double = 0.25, offer: Option[Offer] = None) extends Fruit