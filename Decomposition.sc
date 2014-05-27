package greeter

object Decomposition {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	def eval(e: Expr): Int = {
		if (e.isNum) e.valueOfNum
		else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
		else throw new Error("No handle")
	}                                         //> eval: (e: greeter.Expr)Int
	
	// Merge two list by two loop using decomposition
	def two_for_loop(i: List[Int], j: List[Int]): List[Int] = i match {
		case List()	=> List()
		case x::xs	=> List(x) ::: two_for_loop(xs, List()) ::: two_for_loop_j(List(), j)
	}                                         //> two_for_loop: (i: List[Int], j: List[Int])List[Int]

	def two_for_loop_j(i: List[Int], j: List[Int]): List[Int] = j match {
		case List()	=> List()
		case y::ys	=> List(y) ::: two_for_loop_j(List(), ys)
	}                                         //> two_for_loop_j: (i: List[Int], j: List[Int])List[Int]

  two_for_loop(List(1,3,5), List(2,4))            //> res0: List[Int] = List(1, 3, 5, 2, 4)
  //List(1, 3, 5, 2, 4)
}

trait Expr {
	def isNum: Boolean
	def isSum: Boolean
	def valueOfNum: Int
	def leftOp: Expr
	def rightOp: Expr
}

class Num(n: Int) extends Expr {
	def isNum = true
	def isSum = false
	def valueOfNum = n
	def leftOp = throw new Error("No left Op")
	def rightOp = throw new Error("No right Op")
}

class Sum(left: Expr, right: Expr) extends Expr {
	def isNum = false
	def isSum = true
	def valueOfNum = throw new Error("No value of Sum")
	def leftOp = left
	def rightOp = left
}