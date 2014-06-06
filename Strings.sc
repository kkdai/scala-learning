package greeter

object Strings {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet


	
	val str: String = "Robert"                //> str  : String = Robert
  var dicstr: String = "abcdefghijklmnopqrstuvwxyz"
                                                  //> dicstr  : String = abcdefghijklmnopqrstuvwxyz
  var low_str = str.toLowerCase.toCharArray()     //> low_str  : Array[Char] = Array(r, o, b, e, r, t)
  str.contains('s')                               //> res0: Boolean = false
 	val list = low_str map( x => x )          //> list  : Array[Char] = Array(r, o, b, e, r, t)

	var w: String = "Welcome to the Scala worksheet"
                                                  //> w  : String = Welcome to the Scala worksheet
	//Using groupBy to tranform string to map
	var strmap = w.toLowerCase.groupBy( (c: Char) => c )
                                                  //> strmap  : scala.collection.immutable.Map[Char,String] = Map(e -> eeeee, s ->
                                                  //|  ss, t -> ttt, a -> aa, m -> m,   -> "    ", l -> ll, c -> cc, h -> hh, r ->
                                                  //|  r, w -> ww, k -> k, o -> ooo)
	// map can using map transform for string.length
	var strpair = strmap map ( kv => (kv._1, kv._2.length) )
                                                  //> strpair  : scala.collection.immutable.Map[Char,Int] = Map(e -> 5, s -> 2, t 
                                                  //| -> 3, a -> 2, m -> 1,   -> 4, l -> 2, c -> 2, h -> 2, r -> 1, w -> 2, k -> 1
                                                  //| , o -> 3)
	//ret:Map(e -> 5, s -> 2, t -> 3, a -> 2, m -> 1,   -> 4, l -> 2, c -> 2, h -> 2, r -> 1, w -> 2, k -> 1....)
	
	
	//sortBy is build-in map sort method
	//filter(x => x._1 >= 'a') to filter 'space'
	strpair.toList filter(x => x._1 >= 'a') sortBy ( _._1 )
                                                  //> res1: List[(Char, Int)] = List((a,2), (c,2), (e,5), (h,2), (k,1), (l,2), (m,
                                                  //| 1), (o,3), (r,1), (s,2), (t,3), (w,2))
	//ret:List[(Char, Int)] = List((a,2), (c,2), (e,5), (h,2), (k,1), .....
	
}