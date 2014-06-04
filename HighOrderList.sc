package greeter

object HighOrderList {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val num:List[Int] = List(2,3,4,5,6,7,8,9,10)    //> num  : List[Int] = List(2, 3, 4, 5, 6, 7, 8, 9, 10)
  
  num filter (x => x>5)                           //> res0: List[Int] = List(6, 7, 8, 9, 10)
  num filterNot (x => x>5)                        //> res1: List[Int] = List(2, 3, 4, 5)
  num partition (x => x >5)                       //> res2: (List[Int], List[Int]) = (List(6, 7, 8, 9, 10),List(2, 3, 4, 5))
	num takeWhile (x => x >5)                 //> res3: List[Int] = List()
	num dropWhile (x => x >5)                 //> res4: List[Int] = List(2, 3, 4, 5, 6, 7, 8, 9, 10)
	num span (x => x >5)                      //> res5: (List[Int], List[Int]) = (List(),List(2, 3, 4, 5, 6, 7, 8, 9, 10))

	val str:List[Char] = List('a','a','b','b','b','c','c')
                                                  //> str  : List[Char] = List(a, a, b, b, b, c, c)
  str takeWhile (x => x=='a')                     //> res6: List[Char] = List(a, a)
	
	
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil		=> Nil
		case y::ys	=> List(List(y)::: ys takeWhile(x => x==y)) ::: pack(ys dropWhile(x => x==y))
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	pack(str)                                 //> res7: List[List[Char]] = List(List(a, a), List(b, b, b), List(c, c))

  
  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (x => (x.head, x.length) )
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
	encode(str)                               //> res8: List[(Char, Int)] = List((a,2), (b,3), (c,2))
	//List[(Char, Int)] = List((a,2), (b,3), (c,2))
}