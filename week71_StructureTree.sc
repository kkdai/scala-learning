package greeter

object week71_StructureTree {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  abstract class IntSet {
  	def incl(x: Int): IntSet
  	def contains(x: Int): Boolean
  }
  
   object Empty extends IntSet {
  	def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
  	def contains(x: Int): Boolean = false
  }
  
  case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  	def incl(x: Int): IntSet =
  		if (x < elem) NonEmpty(elem, left incl x, right)
  		else if (x > elem) NonEmpty(elem, left, right incl x)
  		else this
  
  	def contains(x: Int): Boolean =
  		if (x < elem) right contains x
  		else if (x > elem) left contains x
  		else x == elem
  }
  
  //Proposition 1: Empty contains x == false
  //Original definition Empty don't contains any element
  
  //Proposition 2: (s incl x) contains x == true
  
  // (Empty incl x) contains x
  // -> NonEmpty(x, Empty, Empty) contains x -> true
  
  // NonEmpty
}