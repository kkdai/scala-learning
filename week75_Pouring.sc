package greeter

object week75_Pouring {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet


	class Pouring(capacity: Vector[Int]){
		
		//state
		type State = Vector[Int]
		val initialState = capacity map (x=> 0)
		
		//move
		trait Move
		case class Empty(glass: Int) extends Move
		case class Fill(glass: Int) extends Move
		case class Pour(from: Int, to: Int) extends Move
		
		val glasses = 0 until capacity.length
		
		
		val moves =
			(for (g<-glasses) yield Empty(g)) ++
			(for (g<-glasses) yield Fill(g) ) ++
			(for (from<-glasses; to <-glasses if from != to) yield Pour(from, to) )
	}

	val st = new Pouring( Vector(4,7) )       //> st  : greeter.week75_Pouring.Pouring = greeter.week75_Pouring$$anonfun$main$
                                                  //| 1$Pouring$1@2df6df4c
  st.glasses                                      //> res0: scala.collection.immutable.Range = Range(0, 1)
	st.moves                                  //> res1: scala.collection.immutable.IndexedSeq[Product with Serializable with g
                                                  //| reeter.week75_Pouring.st.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1)
                                                  //| , Pour(0,1), Pour(1,0))
}