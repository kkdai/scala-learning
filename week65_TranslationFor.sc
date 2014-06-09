package greeter

object week65_TranslationFor {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	case class Book(title: String, arthor: List[String])
	
	val Books:List[Book] = List(
		Book(title="title1", arthor=List("Paul, John","Tom, Wang") ),
		Book(title="title2", arthor=List("Tom, Wang","Ivy, Lin") ),
		Book(title="title3", arthor=List("Paul, John","Nick, Chen") ),
		Book(title="title4", arthor=List("Wood","Trick", "Sum") ),
		Book(title="title5", arthor=List("Paul, John","arthor7") )
		)                                 //> Books  : List[greeter.week65_TranslationFor.Book] = List(Book(title1,List(Pa
                                                  //| ul, John, Tom, Wang)), Book(title2,List(Tom, Wang, Ivy, Lin)), Book(title3,L
                                                  //| ist(Paul, John, Nick, Chen)), Book(title4,List(Wood, Trick, Sum)), Book(titl
                                                  //| e5,List(Paul, John, arthor7)))
		
	for ( b<-Books; a <-b.arthor if a startsWith "Paul") yield b.title
                                                  //> res0: List[String] = List(title1, title3, title5)
	Books flatMap( b => for (a<-b.arthor if a startsWith "Paul") yield b.title )
                                                  //> res1: List[String] = List(title1, title3, title5)

	(for {
			b1 <- Books
			b2 <- Books
			if b1.title < b2.title
			
			a1 <- b1.arthor
			a2 <- b2.arthor
			if a1 == a2
			} yield a1
		).distinct                        //> res2: List[String] = List(Tom, Wang, Paul, John)

	Books flatMap (b1 => for {
			b2 <- Books
			if b1.title < b2.title
			
			a1 <- b1.arthor
			a2 <- b2.arthor
			if a1 == a2
			} yield a1
	)                                         //> res3: List[String] = List(Tom, Wang, Paul, John, Paul, John, Paul, John)
}