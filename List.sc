package greeter

object Lists {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  var num = List(1,2,3,4)                         //> num  : List[Int] = List(1, 2, 3, 4)
  var fruit = List("Apple", "Orange", "other")    //> fruit  : List[String] = List(Apple, Orange, other)
  var other_num = 1 :: 2 :: 3 :: 4 :: Nil         //> other_num  : List[Int] = List(1, 2, 3, 4)
  
  
  def isort(xs: List[Int]): List[Int]= xs match {
	case List() => List()
	case  y::ys  => insert(y, isort(ys))
	}                                         //> isort: (xs: List[Int])List[Int]

	def insert(x: Int, xs: List[Int] ): List[Int] = xs match {
		case List() => List(x)
		case y::ys	=> if (x <= y ) x::xs else y::insert(x, ys)
	}                                         //> insert: (x: Int, xs: List[Int])List[Int]

 isort(List(3,5,2,9,11,6,7))                      //> res0: List[Int] = List(2, 3, 5, 6, 7, 9, 11)
}