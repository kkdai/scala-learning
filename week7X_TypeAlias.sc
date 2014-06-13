package greeter

object week7X_TypeAlias {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	// Int => Boolean
  def listFunc(list: List[Int]): Int => Boolean =  (x: Int) => list contains x
                                                  //> listFunc: (list: List[Int])Int => Boolean
	listFunc(List(1,3,5)) (4)                 //> res0: Boolean = false
	
	// devide it into detail
	type MyType = Int => Boolean
	val greaterThan5: MyType = (x: Int) => x > 5
                                                  //> greaterThan5  : Int => Boolean = <function1>
	greaterThan5(7)                           //> res1: Boolean = true

	val vec_x : Vector[Vector[Int]] = Vector( Vector(1,3), Vector(2,4), Vector(5,7), Vector(8,6) )
                                                  //> vec_x  : Vector[Vector[Int]] = Vector(Vector(1, 3), Vector(2, 4), Vector(5, 
                                                  //| 7), Vector(8, 6))
	vec_x(2)(0)                               //> res2: Int = 5
	vec_x(0).length                           //> res3: Int = 2
	vec_x.length                              //> res4: Int = 4
}