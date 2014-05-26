package greeter

object Currying_test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def sum(f: Int=> Int): (Int, Int) => Int= {
  	def sumF(a: Int, b: Int): Int = {
  		if (a>b) 0
  		else f(a) + sumF(a+1, b)
  	}
  	sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int
  def sum2(f: Int => Int) (a:Int, b:Int): Int = {
  	if (a>b) 0 else sum(f) (a+1, b)
  }                                               //> sum2: (f: Int => Int)(a: Int, b: Int)Int
  def sumInt = sum(x=>x)                          //> sumInt: => (Int, Int) => Int
  def sumSqure = sum(x => x*x)                    //> sumSqure: => (Int, Int) => Int
  sumInt(1, 3)                                    //> res0: Int = 6
  sumSqure(1, 3)                                  //> res1: Int = 14
  
  sum2(x=>x)(5,6)                                 //> res2: Int = 6
}