package greeter

object folderLeftRight {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	val list: List[Int] = List(2,4,8)         //> list  : List[Int] = List(2, 4, 8)
	list.foldLeft(0)((b,a) => b+a)            //> res0: Int = 14
	list.foldLeft(1)((b,a) => b+a)            //> res1: Int = 15
	list.foldLeft(2)((b,a) => b+a)            //> res2: Int = 16
	list.foldLeft(0)((b,a) => b*a)            //> res3: Int = 0
	list.foldLeft(1)((b,a) => b*a)            //> res4: Int = 64
	list.foldLeft(2)((b,a) => b*a)            //> res5: Int = 128
	list.foldLeft(1)((b,a) => b/a)            //> res6: Int = 0

	(list foldRight (2)) ((b,a) => b+a)       //> res7: Int = 16
}