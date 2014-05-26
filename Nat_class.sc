//Peano Numbers
package greeter

object Nat_class {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}

abstract class Nat {
	def isZero: Boolean
	def predecessor: Nat
	def succesor = new Succ(this)
	def +(that: Nat): Nat
	def -(that: Nat): Nat
}

object Zero extends Nat {
	def isZero = true
	def predecessor: Nat = throw new Error("Zero predecessor")
	def +(that: Nat): Nat = that
	def -(that: Nat): Nat = if (isZero) this else throw new Error("Negtive")
}

class Succ(n: Nat) extends Nat {
	def isZero = false
	def predecessor = n
	def +(that: Nat): Nat = new Succ(n + that)
	def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor //the same diff a-b => (a-1) - (b-1)
}