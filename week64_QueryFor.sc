package greeter

object week64_QueryFor {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	case class Book(title: String, arthor: List[String])
	
	val Books:List[Book] = List(
		Book(title="title1", arthor=List("arthor1","arthor2") ),
		Book(title="title2", arthor=List("arthor2","arthor4") ),
		Book(title="title3", arthor=List("arthor1","arthor3") ),
		Book(title="title4", arthor=List("arthor5","arthor6", "arthor7") ),
		Book(title="title5", arthor=List("arthor1","arthor7") )
		)                                 //> Books  : List[greeter.week64_QueryFor.Book] = List(Book(title1,List(arthor1,
                                                  //|  arthor2)), Book(title2,List(arthor2, arthor4)), Book(title3,List(arthor1, a
                                                  //| rthor3)), Book(title4,List(arthor5, arthor6, arthor7)), Book(title5,List(art
                                                  //| hor1, arthor7)))
		
		List("arthor1","arthor2") contains "arthor2"
                                                  //> res0: Boolean = true
		//using contains
		for (b<-Books; t<-b.arthor ; if t contains "arthor3" ) yield b.title
                                                  //> res1: List[String] = List(title3)
		
	
		for {
			b1 <- Books
			b2 <- Books
			if b1 != b2
			
			a1 <- b1.arthor
			a2 <- b2.arthor
			if a1 == a2
		} yield a1                        //> res2: List[String] = List(arthor2, arthor1, arthor1, arthor2, arthor1, artho
                                                  //| r1, arthor7, arthor1, arthor1, arthor7)
			

		
		(for {
			b1 <- Books
			b2 <- Books
			if b1.title < b2.title
			
			a1 <- b1.arthor
			a2 <- b2.arthor
			if a1 == a2
			} yield a1
		).distinct                        //> res3: List[String] = List(arthor2, arthor1, arthor7)
}