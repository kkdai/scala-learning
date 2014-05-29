package greeter

object Subtype {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	//Define a trait of List which has follow methods.
	trait List[T] {
		def isEmpty: Boolean
		def head: T
		def tail: List[T]
	}
	
	class Cons[T](val head: T, val tail: List[T]) extends List[T] {
		def isEmpty = false
	}
	
	object Nil extends List[Nothing] {
		def isEmpty  = true
		def head = throw new NoSuchElementException("Nil in head")
		def	tail = throw new NoSuchElementException("Nil in head")
	}

	// val x: List[String] = Nil , error Nothing is subtype of String but List[Nothing] is not subtype of List[String]


	trait List2[+T] {  //make T as convariant
		def isEmpty: Boolean
		def head: T
		def tail: List2[T]
	}
	
	class Cons2[T](val head: T, val tail: List2[T]) extends List2[T] {
		def isEmpty = false
	}
	
	object Nil2 extends List2[Nothing] {
		def isEmpty  = true
		def head = throw new NoSuchElementException("Nil in head")
		def	tail = throw new NoSuchElementException("Nil in head")
	}
	
	val x2: List2[String] = Nil2              //> x2  : greeter.Subtype.List2[String] = greeter.Subtype$$anonfun$main$1$Nil2$
                                                  //| 2$@851052d
	//So it works not
}