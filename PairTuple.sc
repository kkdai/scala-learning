package greeter

object PairTuple {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
  	case (List(),List()) 		=> List()
  	case (x::xs, List())		=> List(x) ::: merge(xs, List())
  	case (List(), y::ys)		=> List(y) ::: merge(List(), ys)
  	case (x::xs, y::ys)	  	=> List(x,y) ::: merge(xs, ys)
  }                                               //> merge: (xs: List[Int], ys: List[Int])List[Int]
  
  merge(List(1,3,5), List(2,4))                   //> res0: List[Int] = List(1, 2, 3, 4, 5)
}