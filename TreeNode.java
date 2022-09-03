import java.util.*;
class ArticleData {
	
	// variable declaration 
    int id;
    String title;
    String author;
    ArrayList<String> keywords; // create ArrayList
    
    // set id, title, author to this.
    ArticleData(int id, String title, String author, int keywordCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        
        // ArrayList object 
        keywords = new ArrayList<String> (keywordCount); 
        
    } // ArticleData method 
    
    // add keywords into ArrayList 
    void addKeyword(String keyword) {
        keywords.add(keyword);
    } // end of addKeyword method 
    
} // end of ArticleData class 
