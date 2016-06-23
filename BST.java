package final_lab_password_cracker2;

//imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* This Binary Search Tree Class is very simple.
 * It will demonstrate basic knowledge about how BST work
 * and some of their methods, because of the simplicity
 * added elements in a random order are very likely to 
 * create an unbalanced tree. A workaround is to use a
 * sorting algorithm before creating the tree. */
public class BST {
	
	public static ObjectNode root;	//root variable
	
	/* Default Constructor */
	public BST(){	
		this.root = null;
	}//end empty constructor
	
	/*Method for finding a password in the BST
	 * [ADD] Hash table if you plan to do a BST of Values instead*/
	public boolean find(Password pass){
		ObjectNode current = root;
		while(current!= null){
			if(current.data.pwd.equals(pass.pwd)){
				System.out.println("Found in Dictionary!\nYour Hidden Password "+
						"is: "+pass.pwd);
				return true;
			}else if (current.data.pwd.compareTo(pass.pwd) > 0)
				current = current.left;
			else
				current = current.right;
		}//end while
		return false;
	}//end find
	
	/* Method for inserting a password */
	public void insert(Password pass){
		ObjectNode newNode = new ObjectNode(pass);
		if(root == null){	//empty tree
			root = newNode;
			return;
		}
		ObjectNode current= root;
		ObjectNode parent = null;
		while(true){
			parent = current;	//parent becomes last viewed node
			if(current.data.pwd.compareTo(pass.pwd) > 0){	//move to left
				current = current.left;
				if(current == null){	//insert left there
					parent.left = newNode;
					return;
				}
			}//end insert left
			else{
				current = current.right;	
				if(current == null){	//insert right there
					parent.right = newNode;
					return;
				}
			}//end insert right
		}//end while
	}//end insert

	public void display(ObjectNode root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data.pwd);
			display(root.right);
			System.out.println();
		}
	}
	
	//Delusion Printer
	public static void printNode(ObjectNode root){
		int maxLevel = maxLevel(root);
		
		printNodeInternal(Collections.singletonList(root),1,maxLevel);
	}
	
	private static void printNodeInternal(List<ObjectNode> nodes, int level, int maxLevel){
		if(nodes.isEmpty() || isAllElementsNull(nodes))
			return;
		
		int floor = maxLevel - level;
		int edgeLines = (int) Math.pow(2, (Math.max(floor -1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor))-1 ;
		int betweenSpaces = (int) Math.pow(2, (floor +1))-1;
		
		printWhitespaces(firstSpaces);
		
		List<ObjectNode> newNodes = new ArrayList<ObjectNode>();
		for (ObjectNode node : nodes){
			if(node != null){
				System.out.print(node.data.pwd);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= edgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);

				if (nodes.get(j) == null) {
					printWhitespaces(edgeLines + edgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					printWhitespaces(1);

				printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					printWhitespaces(1);
				
				printWhitespaces(edgeLines + edgeLines -i);
			}
			System.out.println(" ");
		}
		printNodeInternal(newNodes, level +1 , maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}
	
	private static int maxLevel(ObjectNode node){
		if(node == null)
			return 0;
		return Math.max(maxLevel(node.left), maxLevel(node.right))+1 ;
	}
	
	private static boolean isAllElementsNull(List<ObjectNode> list){
		for(Object object : list){
			if(object != null)
				return false;
		}
		return true;
	}
	
}//end class
