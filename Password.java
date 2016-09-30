package gui_for_final;

/** This class will store a Password object */
public class Password {
	//Data for Password
	public String pwd;
	public int value;
	
	//Default Constructor
	public Password(String password, int value){
		this.pwd = password;
		this.value = value;
	}//end constructor
	//Empty constructor
	public Password(){
		pwd = " ";
		value = 0;
	}//end constructor
}//end class
