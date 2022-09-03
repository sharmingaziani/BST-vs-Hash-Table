import java.util.*;
import java.io.*;

public class Project2Testing {

	// read file datafile.txt
	BufferedReader fileReader;
	// create binarysearchtree
	BinarySearchTree bst; 
	
	// read datafile.txt and print bst (test)
	public static void main(String[] args) {
		Project2Testing test = new Project2Testing("datafile.txt");
		test.bst.print();
	} // end of main method 
	
	// read in file using try catch
	Project2Testing(String filename) {
		try {
			bst = new BinarySearchTree(); // create binary search tree object 
			fileReader = new BufferedReader(new FileReader(filename)); // read in the file name
			
			ArticleData article; // article object 
			
			// add to bst while reading 
			while ((article = readNextRecord()) != null) {
				bst.addArticle(article);
				
			}
		}
		// if file is not read, it creates object e
		catch(IOException e) {
			e.printStackTrace(); 
		}
	} // end of Project2Testing 
	
	
	// method to return article data 
	public ArticleData readNextRecord() {
		// if the file was not read, output error to user 
		if (fileReader == null) {
			System.out.println("Error: You must open the file first.");
			return null;
		}
		
		else { // article object 
			ArticleData article; 
			
			try {
				// read in each line from the file 
				String data = fileReader.readLine();
				
				// if data is null, file is done being read 
				if (data == null)
					return null;
				
				//put data values into titleId
				int titleId = Integer.parseInt(data);
				
				// put line data from file into title, author, and numKeys
				String title = fileReader.readLine();
				String author = fileReader.readLine();
				int numKeys = Integer.parseInt(fileReader.readLine());
				
				// new article object 
				article = new ArticleData(titleId, title, author, numKeys); 
				
				String keyword;
				
				// add keywords into article 
				for (int i=0; i<numKeys; i++) {
					keyword = fileReader.readLine();
					article.addKeyword(keyword);
				}
				fileReader.readLine();
				
				
			} // catching error statements 
			catch(NumberFormatException e) {
				System.out.println("Error: Number expected!");
				return null;
			}
			catch(Exception e) {
				System.out.println("Fatal Error: " + e);
				return null;
			}
			return article;
		}
	} // end of ArticleData 
	
} // end of Project2Testing class 
