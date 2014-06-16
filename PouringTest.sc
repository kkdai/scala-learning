package greeter

object PouringTest {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	lazy val problems = new Pouring( Vector(4,9) )
                                                  //> problems: => greeter.Pouring
	problems.initExtend.toList mkString ", "  //> res0: String = Empty(0)-->Vector(0, 0), Empty(1)-->Vector(0, 0), Fill(0)-->V
                                                  //| ector(4, 0), Fill(1)-->Vector(0, 9), Pour(0,1)-->Vector(0, 0), Pour(1,0)-->V
                                                  //| ector(0, 0)
	problems.moves                            //> res1: scala.collection.immutable.IndexedSeq[Product with Serializable with g
                                                  //| reeter.PouringTest.problems.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill
                                                  //| (1), Pour(0,1), Pour(1,0))
  problems.pathSets.toList.length                 //> res2: Int = 13
	problems.solutions(7)                     //> res3: Stream[greeter.PouringTest.problems.Path] = Stream(Fill(0) Pour(0,1) F
                                                  //| ill(0) Pour(0,1) Fill(0) Pour(0,1) Empty(1) Pour(0,1) Fill(0) Pour(0,1)-->Ve
                                                  //| ctor(0, 7), ?)
	//val Path_i = new Path(pour_moves.toList)
	//path_i.endState
}