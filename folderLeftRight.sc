package greeter

object folderLeftRight {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	val list: List[Int] = List(2,3,5)         //> list  : List[Int] = List(2, 3, 5)
	list.foldLeft(1)((b,a) => b+a)            //> res0: Int = 11
	list.foldLeft(0)((b,a) => b*a)            //> res1: Int = 0

}