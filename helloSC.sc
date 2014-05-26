package greeter
//package idealized.scala

object helloSC {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = 5                                       //> x  : Int = 5
  def increase(i: Int) = i + 1                    //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 6
  
  var t1 = new NonEmpty(3, new Empty, new Empty)  //> t1  : greeter.NonEmpty = {.3.}
  var t2 = t1 incl 5                              //> t2  : greeter.IntSet = {.3{.5.}}
  var t3 = t2 incl 1                              //> t3  : greeter.IntSet = {{.1.}3{.5.}}
  var t4 = t3 incl 7                              //> t4  : greeter.IntSet = {{.1.}3{.5{.7.}}}
  var t5 =  t3 union t4                           //> t5  : greeter.IntSet = {{.1.}3{.5{.7.}}}
  
  if (true) 1 else false                          //> res1: AnyVal = 1
  
  	def apply[T](x1: T, x2:T): List[T] = {
  		new Cons(x1, new Cons(x2, new Nil))
  	}                                         //> apply: [T](x1: T, x2: T)greeter.List[T]
    def apply2[T]() = new Nil                     //> apply2: [T]()greeter.Nil[Nothing]
  }
  
  abstract class Base {
  	def foo = 1
  	def bar: Int
  }
  
  class Sub extends Base {
  	override def foo = 2
  	def bar =3
  }
  
  //Video Lecture 3
  abstract class IntSet {
  	def contains(x: Int): Boolean
  	def incl(x: Int): IntSet
  	def union(other: IntSet): IntSet
  }
  
   class Empty extends IntSet {
  	def contains(x: Int): Boolean = false
  	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  	def union(other: IntSet): IntSet = other
  	override def toString = "."
  }

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  	def contains(x: Int): Boolean =
  			if (x < elem) left contains x
  			else if (x > elem) right contains x
  			else true
  			
  	def incl(x: Int): IntSet =
  			if (x < elem) new NonEmpty(elem, left incl x, right)
  			else if (x > elem) new NonEmpty(elem, left, right incl x)
  			else this
  	def union(other: IntSet): IntSet =
  		(left union right union other) incl elem
  	override def toString = "{" + left + elem + right + "}"
  }
  
  //Video Lecture4
  trait List[T] {
  	def isEmpty: Boolean
  	def head: T
  	def tail: List[T]
  }
  
  class Cons[T](var head: T, var tail: List[T]) extends List[T] {
  	def isEmpty = false
  }
  
  class Nil[T] extends  List[T] {
  	def isEmpty = true
  	def head: Nothing = throw new NoSuchElementException("Nil head")
  	def tail: Nothing = throw new NoSuchElementException("Nil tail")
  }
  