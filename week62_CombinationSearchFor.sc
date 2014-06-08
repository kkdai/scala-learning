package greeter

object week62_CombinationSearchFor {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //
  // To calculator all i+j <= limited and find all possbility prime when i+j
  //
  // upper bond
  val limted:Int = 7                              //> limted  : Int = 7
  
  def isPrime(n: Int):Boolean = (2 until n) forall (x=> n % x != 0)
                                                  //> isPrime: (n: Int)Boolean
  
  
  
  var source_vector = ( (1 until limted) map ( i =>
  	 										(1 until i) map (j => (i, j) ) ) )
                                                  //> source_vector  : scala.collection.immutable.IndexedSeq[scala.collection.immu
                                                  //| table.IndexedSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1)
                                                  //| , (3,2)), Vector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), V
                                                  //| ector((6,1), (6,2), (6,3), (6,4), (6,5)))
	//flatten to flat it
	source_vector.flatten                     //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))
	
	//
	source_vector.flatten filter(x => isPrime(x._1+x._2) )
                                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
	// Using for-comprehesion is more clear is readable
	for {
		i <- 1 to limted
		j <- 1 to i
		if isPrime(i+j)
	} yield (i, j)                            //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (2,1
                                                  //| ), (3,2), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6))
  
  
  def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
  		(for( (x,y) <- xs zip ys ) yield x*y).sum
  }                                               //> scalarProduct: (xs: List[Double], ys: List[Double])Double
  scalarProduct( List(0.3,0.5,0.8,0.9) , List(0.3,0.5,0.8,0.9)  )
                                                  //> res3: Double = 1.79
  List(0.3,0.5,0.8,0.9) zip List(0.3,0.5,0.8,0.9) //> res4: List[(Double, Double)] = List((0.3,0.3), (0.5,0.5), (0.8,0.8), (0.9,0.
                                                  //| 9))
	List(1,2,3,4) zip List(1,2,3,4)           //> res5: List[(Int, Int)] = List((1,1), (2,2), (3,3), (4,4))
	
	
	for {
		i <- List(1,2,3)
		j <- List(1,2,3)
		if (i != j)
	} yield (i, j)                            //> res6: List[(Int, Int)] = List((1,2), (1,3), (2,1), (2,3), (3,1), (3,2))
 for (i <- List(1,2,3) ) yield i                  //> res7: List[Int] = List(1, 2, 3)
 val q_list = List(0, 1,2,3,4,5)                  //> q_list  : List[Int] = List(0, 1, 2, 3, 4, 5)
 for {
 	i <- q_list:::Nil
 	j <- q_list:::Nil
 	k <- q_list:::Nil
 	if (i+j+k==6) && i!=j && j!=k && i!=k
 } yield (i,j,k)                                  //> res8: List[(Int, Int, Int)] = List((0,1,5), (0,2,4), (0,4,2), (0,5,1), (1,0
                                                  //| ,5), (1,2,3), (1,3,2), (1,5,0), (2,0,4), (2,1,3), (2,3,1), (2,4,0), (3,1,2)
                                                  //| , (3,2,1), (4,0,2), (4,2,0), (5,0,1), (5,1,0))
 
 
 
 //Set(1,2,3).subsets foreach println

	def combine(in: List[Char]): Seq[String] =
    for {
        len <- 1 to in.length
        combinations <- in combinations len
    } yield combinations.mkString                 //> combine: (in: List[Char])Seq[String]


}