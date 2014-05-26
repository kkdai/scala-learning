
package greeter
object hello extends App{
	println("Hello World");
	
	
	//For loop
	for (i <- 1 to 10) println ("test")
	
	//Get even number with for
	for {
	  i<- 1 to 10
	  if i % 2 == 0	  	
	} println(i)	
	
	//Another way lambda with get even
	1.to(10).withFilter(((i)=> i.$percent(2).$eq$eq(0))).foreach(((i)=>println(i)))
	
	
	//Double for loop
	for {
	  i <- 1 to 5
	  j <- 1 to 5	
	} println(s"i=$i, j=$j")
	
	//break
	//http://daily-scala.blogspot.tw/2010/04/breaks.html
	import util.control.Breaks._
	breakable {
		for (1 <- 1 to 10) 
			if (true)
				break
			else
				println("fail break")	    
	}
	println("break  work!")
	
	//ternary operator 
	// condA ? a : b
	var valueA = if (true) 1 else 2 //return could be ignore in scala
	println(if(true) 1 else 2)
	
	
	//switch case
	import scala.annotation.switch
	
	val switch_i = 6
	val result_x = (switch_i: @switch) match {
	  case 1=> "5"
	  case 2=> "3"
	  case _=> "other" 	  
	} 
	println (s"result of switch is $result_x")
	
	// Switch case by casting typing
	def getTyperAsString(x: Any): String = x match {
	  case s:String => s+"is a String"
	  case i:Int	=> "Int"
	  case f:Float	=> "Float"
	  case l:List[_]=> "List"
	  case _		=> "Unknown"
	  //case default 	=> "All case" //similar with default case. 
	}
	
	println("print out:" + getTyperAsString(List(4)))
	println("print out:" + getTyperAsString(5))
	
}