package greeter

object Decomposition {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	def eval(e: Expr): Int = {
		if (e.isNum) e.valueOfNum
		else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
		else throw new Error("No handle")
	}                                         //> eval: (e: greeter.Expr)Int
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