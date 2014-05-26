package greeter
package idealized.scala

object idealize {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}



abstract class Boolean_T {
  	def ifThenElse[T](t: => T, e: => T): T
  	
  	def && 	(x: => Boolean): Boolean = ifThenElse(x, false)
  	def ||	(x: => Boolean): Boolean = ifThenElse(true, x)
  	def unary_! (x: => Boolean): Boolean = ifThenElse(false, true)
  	def == 	(x: => Boolean): Boolean = ifThenElse(x, x.unary_!)
  	def != 	(x: => Boolean): Boolean = ifThenElse(x.unary_!, x)
  	def < 	(x: => Boolean): Boolean = ifThenElse(false, x)
  }