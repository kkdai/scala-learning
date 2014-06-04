package greeter

object Maps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def squreList(xs: List[Int]): List[Int] = xs match {
  	case Nil		=> List()
  	case y::ys	=> y*y :: squreList(ys)
  }                                               //> squreList: (xs: List[Int])List[Int]
 
 	def squreList2(xs: List[Int]): List[Int] = xs map (y=> y*y)
                                                  //> squreList2: (xs: List[Int])List[Int]
  
  squreList(List(1,3,5,7,9))                      //> res0: List[Int] = List(1, 9, 25, 49, 81)
  squreList(Nil)                                  //> res1: List[Int] = List()
  squreList2(List(1,3,5,7,9))                     //> res2: List[Int] = List(1, 9, 25, 49, 81)
  squreList2(Nil)                                 //> res3: List[Int] = List()
 
    
}