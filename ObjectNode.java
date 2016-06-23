package final_lab_password_cracker2;

/* Class to be used along BST Class
 * Creates objects type Password
 * with data fields including left and right */
public class ObjectNode {
	Password data;
	ObjectNode left;
	ObjectNode right;

	public ObjectNode(Password data){
		this.data = data;
		left = null;
		right = null;
	}//end constructor
}
