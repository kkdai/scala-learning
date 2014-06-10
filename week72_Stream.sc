object week72_Stream {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	//stream2 = Stream.cons(1, Stream.cons(2, Stream.empty) )
	Stream(2,3,4)                             //> res0: scala.collection.immutable.Stream[Int] = Stream(2, ?)

	(10 to 15).toStream                       //> res1: scala.collection.immutable.Stream[Int] = Stream(10, ?)

	def streamRange(lo: Int, hi: Int): Stream[Int] = {
		if (lo > hi) Stream.empty
		else Stream.cons(lo, streamRange(lo+1, hi) )
	}                                         //> streamRange: (lo: Int, hi: Int)Stream[Int]

	1 #:: Stream(3,4)                         //> res2: scala.collection.immutable.Stream[Int] = Stream(1, ?)
	Stream(3,4)  #::: Stream(5)               //> res3: scala.collection.immutable.Stream[Int] = Stream(3, ?)
	
	// 1->2->3->Nil
	streamRange(1,10).take(3).toList          //> res4: List[Int] = List(1, 2, 3)
	List(2,3,5).take(1)                       //> res5: List[Int] = List(2)
}