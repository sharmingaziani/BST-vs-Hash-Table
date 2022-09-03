
public class BinarySearchTree {

	// create root 
	TreeNode root;
	
	public void addArticle(ArticleData article) {
		
		// TitleNode object
		TitleNode newTitleNode;
		
		// true or false if keyword gets inserted
		boolean inserted;
		
		for (String key:article.keywords) {
			// TitleNode object with id, title, author nodes
			newTitleNode = new TitleNode(article.id, article.title, article.author, null);
			
			// insert the title node with the keyword
			inserted = insertTreeNode(key, newTitleNode);
		
		// if the node isn't inserted, append TitleNode to the end
		if (!inserted) {
			appendTitleNode(key, newTitleNode); 
			}
		
		}
	} // end of addArticle
	
	
	public void appendTitleNode(String keyword, TitleNode newTitleNode) {
		// set the current node to the root 
		TreeNode current = root;
		
		// if the current node isn't null
		while (current != null) {
			// if its less than 0, add to leftChild
			if (keyword.compareTo(current.keyword) < 0) {
				current = current.leftChild;
			}
			// if greater than 0, add to rightChild
			else if (keyword.compareTo(current.keyword) > 0) {
				current = current.rightChild;
		}
			else {
				// if equal to 0, current becomes the head
				newTitleNode.next = current.head;
				current.head = newTitleNode; // the current head is the newTitleNode node 
				return;
			}
		
		} // end of while loop
	} // end of appendTitleNode
	
	
	public boolean insertTreeNode(String keyword, TitleNode newTitleNode) {
		
		// if there is no root, the root is now TreeNode 
		if (root == null) {
			root = new TreeNode(keyword, newTitleNode);
			return true;
		}
		
		else {
			TreeNode parent = null; // parent node is null 
			TreeNode current = root; // set current node equal to root 
			
			// while current is not null
			while (current != null) {
				
				// if current node is less than 0, set to left child
				if (keyword.compareTo(current.keyword)< 0) {
					parent = current;
					current = current.leftChild;
				}
				// if current is greater than 0, set to rightChild
				else if (keyword.compareTo(current.keyword)>0) {
					parent = current;
					current = current.rightChild;
				}
				// if equal to current, do not insert 
				else if (keyword.compareTo(current.keyword) == 0) {
					return false; // false means did not insert 
				}
			}
			// if parent is less than 0, insert leftChild TreeNode
			if (keyword.compareTo(parent.keyword)< 0) {
				parent.leftChild = new TreeNode(keyword, newTitleNode);
			}
			
			// if parent is greater than 0, insert rightChild TreeNode 
			else if (keyword.compareTo(parent.keyword)>0) {
				parent.rightChild = new TreeNode(keyword, newTitleNode);
				
			}
		}
		return true;
	} // end of insertTreeNode

	// print the root 
	public void print() {
		inOrderPrint(root); 
	}
	
	// method to print tree "inOrder" so increasing order (left, current, right)
	private void inOrderPrint(TreeNode node) {
		
		// if a node is empty return to method 
		if (node == null) return;
		
		// left subtree of current node is visited recursively first 
		inOrderPrint(node.leftChild); 
		
		// print node with format 
		System.out.printf("\n%s (keyword)\n", node.keyword);
	
		// title node is set to head 
		TitleNode title = node.head;
		
		// if title is null (node head)
		while (title != null) {
			// output the id, title, author nodes and format 
			System.out.printf("\t %d | %s | %s-->\n", title.id, title.title, title.author);
			
			// set title to next node 
			title = title.next;
		}
		
		// right subtree gets visited next after left and printed (inorder is in increasing order)
		inOrderPrint(node.rightChild); 
	} // end of inOrderPrint 
	
} // end of BinarySearchTree
