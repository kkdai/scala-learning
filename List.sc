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
	
	//5.1
	//
	def remoteAt[T](n: Int, xs: List[T]): List[T] =  xs match {
			case List() 	=> throw new Error("Non remove")
			case y::ys	  => if (n-1<=0) ys else List(y):::remoteAt(n-1,ys)
	}                                         //> remoteAt: [T](n: Int, xs: List[T])List[T]
	
	var ret = remoteAt(1, List('A', 'B', 'C'))//> ret  : List[Char] = List(B, C)
	def remoteAt2[T](n: Int, xs: List[T]): List[T] =  (xs take n) ::: (xs drop n+1)
                                                  //> remoteAt2: [T](n: Int, xs: List[T])List[T]
	var ret2 = remoteAt2(1, List('A', 'B', 'C'))
                                                  //> ret2  : List[Char] = List(A, C)

	//http://aperiodic.net/phil/scala/s-99/
	//1. also sample from 5.1
	//last
	def last[T](listx: List[T]): T = listx match {
		case List() 	=> throw new Error("Non last")
		case List(x)	=> x
		case x::xs		=> last(xs)
	}                                         //> last: [T](listx: List[T])T
	last(List(0,0,1,0,1,1) )                  //> res11: Int = 1
	// Int=1
	last("Welcome to the Scala worksheet".toList)
                                                  //> res12: Char = t
	// Char=t
	last(List("Welcome to the Scala worksheet".toList))
                                                  //> res13: List[Char] = List(W, e, l, c, o, m, e,  , t, o,  , t, h, e,  , S, c,
                                                  //|  a, l, a,  , w, o, r, k, s, h, e, e, t)
	// List('W', 'e',.....)
	
	//2.
	//penultimate(List(1, 1, 2, 3, 5, 8)) => Int = 5
	def penultimate[T](listx: List[T]): T = listx match {
		case List()				=> throw new Error("Non penultimate")
		case x1::x2::Nil	=> x1 //#2
		case x::xs				=> penultimate(xs) //#3
		//Note the pattern match ordering is important, if switch #2 and #3 this method will failed into non-stop recursive.
	}                                         //> penultimate: [T](listx: List[T])T
	penultimate(List(1, 1, 2, 3, 5, 8))       //> res14: Int = 5
	
	//3.
	//nth(2, List(1, 1, 2, 3, 5, 8))
	def nth[A](n: Int, listx: List[A]): A = listx match {
		case  x::xs		=> if (n==0) x else nth(n-1, xs)
		case List()		=> throw new Error("Non nth")
	}                                         //> nth: [A](n: Int, listx: List[A])A
	nth(2, List(1, 1, 2, 3, 5, 8))            //> res15: Int = 2
	
	//4.
	//length(List(1, 1, 2, 3, 5, 8))
	/*def length[T](listx: List[T]): Int = lengthACC(0, listx)

	def lengthACC[T](total: Int, listx: List[T]): Int = listx match {
		case List()	=> total
		case x::xs	=> lengthACC(total+1, xs)
	}
	*/
	def length[T](listx: List[T]): Int = listx match {
		case List()	=> 0
		case x::xs	=> 1+length(xs)
	}                                         //> length: [T](listx: List[T])Int
	length(List(1, 1, 2, 3, 5, 8))            //> res16: Int = 6

	//5.
	//reverse(List(1, 1, 2, 3, 5, 8))
	def reverse[T](listx: List[T]): List[T] = listx match {
		case List()	=> List()
		case x::xs	=> reverse(xs):::List(x)
	}                                         //> reverse: [T](listx: List[T])List[T]
	reverse(List(1, 1, 2, 3, 5, 8))           //> res17: List[Int] = List(8, 5, 3, 2, 1, 1)
	//6.
	//isPalindrome(List(1, 2, 3, 2, 1))
	def isPalindrome[T](listx: List[T]): Boolean =  listx==reverse(listx)
                                                  //> isPalindrome: [T](listx: List[T])Boolean
	isPalindrome(List(1, 2, 3, 2, 1))         //> res18: Boolean = true
	
	//7.
	//flatten(List(List(1, 1), 2, List(3, List(5, 8))))
	//(a) Must use with [Any] with Any class
	def flatten(ls: List[Any]): List[Any] = ls flatMap {
		case ms: List[xs]  => flatten(ms)
		case e						 => List(e)
	}                                         //> flatten: (ls: List[Any])List[Any]
	flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res19: List[Any] = List(1, 1, 2, 3, 5, 8)
	
	//8.
	//compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	
	
}