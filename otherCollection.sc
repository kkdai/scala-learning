package greeter

object otherCollection {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  type Word = String
  
  // array map operation
  val xs = Array(1,2,3,4)                         //> xs  : Array[Int] = Array(1, 2, 3, 4)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 8)
  //Array(2, 4, 6, 8)
  
  val s:Word = "I am the lengend"                 //> s  : greeter.otherCollection.Word = I am the lengend
  s filter (x => x.isUpper)                       //> res1: String = I
  //String = I
  s exists (x => x.isLower)                       //> res2: Boolean = true
  //True
  s forall (x => x.isLower)                       //> res3: Boolean = false
  //False
  
  val pairs = s zip List(1,2,3)                   //> pairs  : scala.collection.immutable.IndexedSeq[(Char, Int)] = Vector((I,1), 
                                                  //| ( ,2), (a,3))
  // (I, 1) (_,2) (a, 3)
  pairs.unzip                                     //> res4: (scala.collection.immutable.IndexedSeq[Char], scala.collection.immutab
                                                  //| le.IndexedSeq[Int]) = (Vector(I,  , a),Vector(1, 2, 3))
  //(I, _ , a) (1,2,3)
  
  //using recursive
  def isPrime(n: Int): Boolean = {
     def isPrimeAcc(num: Int, inx: Int):Boolean = {
				if (inx < 2)  true
				else if (num % inx == 0) false
				else isPrimeAcc(num, inx-1)
     }
     isPrimeAcc(n,n-1)
  }                                               //> isPrime: (n: Int)Boolean
  
  isPrime(5)                                      //> res5: Boolean = true
  isPrime(4)                                      //> res6: Boolean = false
	isPrime(11)                               //> res7: Boolean = true
	
	//using forall and until
	def isPrime2(n: Int): Boolean = (2 until n) forall (x => n % x != 0)
                                                  //> isPrime2: (n: Int)Boolean
  isPrime2(5)                                     //> res8: Boolean = true
  isPrime2(4)                                     //> res9: Boolean = false
	isPrime2(11)                              //> res10: Boolean = true
}