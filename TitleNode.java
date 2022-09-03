
public class TitleNode {
	
	// variable declaration for id, title, author, next
	int id;
	String title; 
	String author; 
	TitleNode next; 
	
	// set the following variables to i, t, a, and r
	TitleNode(int i, String t, String a, TitleNode r) {
		id = i; 
		title = t;
		author = a;
		next = r; 
	} // end of TitleNode method 

} // end of TitleNode class 
