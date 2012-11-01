package com.ivel.scala.school

// class
class Calc {
  val brand: String = "HP"
  def add(m: Int, n: Int) = m + n
}

// class with constructor
class ColorCalc(brand: String) {
  val color: String = if (brand == "HP") {
    "blue"
  } else {
    "black"
  }

  def add(m: Int, n: Int) = m + n
}

// inheritance
class SciCalc(brand: String) extends ColorCalc(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

// abstract
abstract class Shape {
  def getArea(): Double // subclass should define this
}

// inherits
class Circle(r: Double) extends Shape {
  def getArea(): Double = { r * r * math.Pi }
}


// trait
trait Car {
  val brand: String
  def start { 
    println("Starting " + brand) 
  }
}

trait Shiny {
  val shine: Int
  def shining { 
    println("Shining " + shine) 
  }
}

class BMW extends Car with Shiny {
  val brand = "BMW"
  val shine = 12
} 

// generic types in classes
trait Cache[K, V] {
  def get(key: K): V
  def put(key: K, value: V)
  def delete(key: K)
  // and in methods
  def remove[K](key: K)
}


// singleton object
object First {
  // variable
  var a = 2
  // immutable value
  val b = 3
  // function
  def addOne(m: Int): Int = m + 1
  // no args
  def three() = 1 + 2

  // return value
  def timesTwo(i: Int): Int = {
    println
    i * 2
  }

  def adder(m: Int, n: Int) = m + n

  // currying functions
  def multiply(m: Int)(n: Int) = m * n

  // var args
  def capitalize(args: String*) = {
    args.map { arg =>
      arg.capitalize
    }
  }

  def main(args: Array[String]) {
    println(addOne(4))
    println(three)
    println(timesTwo(5))

    // anonymous function assigned
    val twice = { i: Int =>
      println("hello world")
      i * 2
    }

    // another anonymous function assigned
    val thrise = (i: Int) => i * 3

    println(twice(4))
    println(thrise(5))

    // partial application
    val add2 = adder(_: Int, 2)
    println(add2(5))

    // calling curried function
    // 1. at once
    println(multiply(2)(3))
    // 2. at two sites
    var timesThree = multiply(3) _
    println(timesThree(3))

    // any function can be curried
    var curAdder = (adder _).curried
    println(curAdder(2)(9))

    println(capitalize("igor", "elkin"))

    val calc = new Calc
    println(calc.add(1, 2))

    val ccalc = new ColorCalc("HP")
    println(ccalc.color + " " + ccalc.add(2, 3))

    val scalc = new SciCalc("TP")
    println(scalc.color + " " + scalc.log(100, 10))
    
    val circle = new Circle(1)
    println(circle.getArea())
    
    val bmw = new BMW
    
    bmw.start
    bmw.shining
  }

}