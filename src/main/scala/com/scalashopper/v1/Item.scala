package com.scalashopper.v1

trait Item {
  val price: Double
}
case class Invalid(price: Double = 0.0) extends Item

// Fruits can have their own properties for later.
trait Fruit extends Item

// price for individual apples and oranges can be different as scanned via barcodes
case class Apple(price: Double = 0.6) extends Fruit
case class Orange(price: Double = 0.25) extends Fruit