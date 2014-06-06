package greeter

object week66_Maps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val string_list :List[String] = List("Tom", "Paul", "Thomas", "Jane")
                                                  //> string_list  : List[String] = List(Tom, Paul, Thomas, Jane)
  //Sort by alphabet
  string_list.sorted                              //> res0: List[String] = List(Jane, Paul, Thomas, Tom)
	//Sort by length
  string_list sortWith(_.length > _.length)       //> res1: List[String] = List(Thomas, Paul, Jane, Tom)
  string_list sortWith(_.head < _.head)           //> res2: List[String] = List(Jane, Paul, Tom, Thomas)

	val pair_list :List[(Char, Int)] = List( ('c',3), ('a',5), ('b',1), ('d', 3) )
                                                  //> pair_list  : List[(Char, Int)] = List((c,3), (a,5), (b,1), (d,3))
	val pair_list2 :List[(Char, Int)] = List( ('c',2), ('d', 1) )
                                                  //> pair_list2  : List[(Char, Int)] = List((c,2), (d,1))
	pair_list.sorted                          //> res3: List[(Char, Int)] = List((a,5), (b,1), (c,3), (d,3))
	//List((a,5), (b,1), (c,3))
	
	pair_list sortWith(_._2 > _._2)           //> res4: List[(Char, Int)] = List((a,5), (c,3), (d,3), (b,1))
	//List((a,5), (c,3), (b,1))

	pair_list contains ('c',2)                //> res5: Boolean = false
	//false
	
	pair_list.toMap get('c')                  //> res6: Option[Int] = Some(3)
	//Some(3)
	pair_list.toMap apply('c')                //> res7: Int = 3
	//Int: 3
	
	
	class Poly(terms0: Map[Int, Double]) {
		val terms = terms0 withDefaultValue 0.0
		def this(bindings: (Int, Double)*) = this(bindings.toMap)
		def + (other: Poly) = new Poly( (other.terms foldLeft terms) (addTerm) )
		def addTerm(terms: Map[Int, Double], term:(Int, Double) ): Map[Int, Double] = {
			val (x, y) = term
			terms + ( x -> (y + terms(x) ) )
		}

		def - (other: Poly) = new Poly( (other.terms foldLeft terms) (minusTerm) )
		def minusTerm(terms: Map[Int, Double], term:(Int, Double) ): Map[Int, Double] = {
			val (x, y) = term
			terms + ( x -> (terms(x) - y ) )
		}
		
		override def toString =
			(for ( (x, y) <- terms.toList.sorted) yield x+"->"+y) mkString " , "
	}
	
	val P1 = new Poly( 1 -> 2.0, 2->3.2, 3->1.1 )
                                                  //> P1  : greeter.week66_Maps.Poly = 1->2.0 , 2->3.2 , 3->1.1
	val P2 = new Poly( 1 -> 1.0, 3->0.2  )    //> P2  : greeter.week66_Maps.Poly = 1->1.0 , 3->0.2
	P1 + P2                                   //> res8: greeter.week66_Maps.Poly = 1->3.0 , 2->3.2 , 3->1.3
	P1 - P2                                   //> res9: greeter.week66_Maps.Poly = 1->1.0 , 2->3.2 , 3->0.9000000000000001
	P1.terms apply 5                          //> res10: Double = 0.0

	class Occu(terms0: Map[Char, Int]) {
		val terms = terms0 withDefaultValue 0
		def this(bindings: (Char, Int)*) = this(bindings.toMap)

		def - (other: Occu) = new Occu( (other.terms foldLeft terms) (minusTerm) )
		def minusTerm(terms: Map[Char, Int], term:(Char, Int) ): Map[Char, Int] = {
			val (x, y) = term
			terms + ( x -> ((terms apply x) - y ) )
		}
		def toList = terms0.toList
		override def toString =
			(for ( (x, y) <- terms.toList.sorted) yield x+"->"+y) mkString " , "
	}

	val O1 = new Occu( 'a' -> 2, 'b'->3, 'c'->1 )
                                                  //> O1  : greeter.week66_Maps.Occu = a->2 , b->3 , c->1
	val O2 = new Occu( 'a' -> 1, 'c'->1  )    //> O2  : greeter.week66_Maps.Occu = a->1 , c->1
	O1 - O2                                   //> res11: greeter.week66_Maps.Occu = a->1 , b->3 , c->0
	(new Occu(pair_list.toMap) - new Occu(pair_list2.toMap)).toList
                                                  //> res12: List[(Char, Int)] = List((c,1), (a,5), (b,1), (d,2))
   val lard: List[(Char, Int)] = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> lard  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
   val r: List[(Char, Int)] = List(('r', 1))      //> r  : List[(Char, Int)] = List((r,1))
}