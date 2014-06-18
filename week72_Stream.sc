object week72_Stream {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	//stream2 = Stream.cons(1, Stream.cons(2, Stream.empty) )
	Stream(2,3,4)                             //> res0: scala.collection.immutable.Stream[Int] = Stream(2, ?)

	(10 to 15).toStream                       //> res1: scala.collection.immutable.Stream[Int] = Stream(10, ?)

	Stream(Nil)                               //> res2: scala.collection.immutable.Stream[scala.collection.immutable.Nil.type]
                                                  //|  = Stream(List(), ?)
	Stream(None)                              //> res3: scala.collection.immutable.Stream[None.type] = Stream(None, ?)
	Stream.Empty                              //> res4: Stream.Empty.type = Stream()
	Stream()                                  //> res5: scala.collection.immutable.Stream[Nothing] = Stream()
	
	def streamRange(lo: Int, hi: Int): Stream[Int] = {
		if (lo > hi) Stream.empty
		else Stream.cons(lo, streamRange(lo+1, hi) )
	}                                         //> streamRange: (lo: Int, hi: Int)Stream[Int]

	1 #:: Stream(3,4)                         //> res6: scala.collection.immutable.Stream[Int] = Stream(1, ?)
	Stream(3,4)  #::: Stream(5)               //> res7: scala.collection.immutable.Stream[Int] = Stream(3, ?)
	
	(Stream(3,4)  #::: Stream(5)).take(3).toList
                                                  //> res8: List[Int] = List(3, 4, 5)
	(Stream(3,4)  #::: Stream(5)).take(5).toList.length
                                                  //> res9: Int = 3
	// 1->2->3->Nil
	streamRange(1,10).take(3).toList          //> res10: List[Int] = List(1, 2, 3)
	List(2,3,5).take(1)                       //> res11: List[Int] = List(2)
	
	/*
	*   List all Stream operation of "+"
	*/
	//Basic #:::
	Stream(3) #::: Stream(4,5)                //> res12: scala.collection.immutable.Stream[Int] = Stream(3, ?)
	//++ equal to #:::
	Stream(3,4) ++ Stream(5)                  //> res13: scala.collection.immutable.Stream[Int] = Stream(3, ?)
	//++ equal to #:: without type operator
	3 #:: Stream(4, 5)                        //> res14: scala.collection.immutable.Stream[Int] = Stream(3, ?)
	//using stream cons
	Stream.cons(3, Stream(4, 5))              //> res15: Stream.Cons[Int] = Stream(3, ?)
	
}