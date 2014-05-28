package greeter

object Lists {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  var num = List(1,2,3,4)                         //> num  : List[Int] = List(1, 2, 3, 4)
  var fruit = List("Apple", "Orange", "other")    //> fruit  : List[String] = List(Apple, Orange, other)
  var other_num = 1 :: 2 :: 3 :: 4 :: Nil         //> other_num  : List[Int] = List(1, 2, 3, 4)
  //it is equal to
  var another_num = List(1):::List(2):::List(3):::List(4):::Nil
                                                  //> another_num  : List[Int] = List(1, 2, 3, 4)
  
  def isort(xs: List[Int]): List[Int]= xs match {
	case List() => List()
	case  y::ys  => insert(y, isort(ys))
	}                                         //> isort: (xs: List[Int])List[Int]

	def insert(x: Int, xs: List[Int] ): List[Int] = xs match {
		case List() => List(x)
		case y::ys	=> if (x <= y ) x::xs else y::insert(x, ys)
	}                                         //> insert: (x: Int, xs: List[Int])List[Int]

 isort(List(3,5,2,9,11,6,7))                      //> res0: List[Int] = List(2, 3, 5, 6, 7, 9, 11)
 var list_a = List('A') ::: List('B')             //> list_a  : List[Char] = List(A, B)
 list_a(0)                                        //> res1: Char = A
 //a
 list_a(1)                                        //> res2: Char = B
 //b
 ( List(1):::List(2) )(0)                         //> res3: Int = 1
 //0->1  1->2
 "ab".toList                                      //> res4: List[Char] = List(a, b)
 "babba".toList                                   //> res5: List[Char] = List(b, a, b, b, a)
	//res5: List[Char] = List(b, a, b, b, a)
	List(0,0,1,0,1,1)                         //> res6: List[Int] = List(0, 0, 1, 0, 1, 1)
	'a' > 'b'                                 //> res7: Boolean(false) = false
	//false
	//Empty handle in list about null,List()
	(List(1):::List())                        //> res8: List[Int] = List(1)
	//List(1)
	List(null)                                //> res9: List[Null] = List(null)
	//List(null)
  //error on List(1):::null  //null don't have member for :::
	List(1):::List(null)                      //> res10: List[Any] = List(1, null)
	// List(1, null)
}