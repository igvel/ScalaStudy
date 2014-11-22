// Peano numbers
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false

  def predecessor: Nat = n
  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat = {
    if(that.isZero) this
    else this.successor + that.predecessor
  }

  def -(that: Nat): Nat = {
    if(that.isZero) this
    else this.predecessor - that.predecessor
  }

  override def toString: String = {
    def loop(cur: Nat, acc: Int): Int = {
      if(cur.isZero) acc
      else loop(cur.predecessor, acc + 1)
    }
    loop(this, 0).toString
  }
}


object Zero extends Nat {
  def isZero: Boolean = true

  def predecessor: Nat = throw new IllegalStateException("Zero is lowest Natural.")
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if(that.isZero) this else throw new IllegalStateException("Can subtract from zero.")

  override def toString: String = "0"
}

val one = new Succ(Zero)
val two = new Succ(one)
val three = one + two
val five = two + three
val four = five - one
println(Zero)
println(one)
println(two)
println(three)
println(four)
println(five)


