package greeter

object week71_LazyEval {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	def expr = {
		val x ={ print("x"); 1}
		lazy val y ={ print("y"); 2}
		val w ={ print("w"); 4}
		def z ={ print("z"); 3}
		z+y+x+z+y+x
	}                                         //> expr: => Int
	expr                                      //> xwzyzres0: Int = 12
}