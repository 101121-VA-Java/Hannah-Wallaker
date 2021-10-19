
public class StringPractice {
	
public static void main(String[] args) {
		
		String s = "Hello"; // literal
		String s1 = "Hello";
		String s2 = new String("Hello");
		
		System.out.println("Is s == to s1? " + (s == s1) ); // true
		System.out.println("Is s == to s2? " + (s == s2) ); // false
		System.out.println("Is s .equals to s2? " + s.equals(s2));
		
		s2 = s2.intern();
		System.out.println("Once interned, is s == to s2? " + (s == s2) ); // false
		
		System.out.println();
		
		/*
		 * Comparing objects in Java:
		 * 		- == vs .equals
		 * 			- == compares the value in the Stack, used for primitives
		 * 				- if used on reference types, compare the memory address
		 * 			- .equals (if implemented properly) compares the value of the objects as defined in the class
		 * 				- default implementation in the Object class is ==
		 * 					- need to override based on Class fields
		 */
		
		
		Object a = new Object();
		Object b = new Object();
		
		System.out.println("Is object a == b? " + (a == b));
		System.out.println("Is object a .equals b? " + a.equals(b));
		
		/*
		 * String methods to be play around with:
		 * 		- substring
		 * 		- replace
		 * 		- chartAt
		 * 		- ...
		 */
		
		StringBuilder sb = new StringBuilder("Hello world!");
		
		System.out.println(sb.reverse());
		
		//generally use string builder
		StringBuffer sbuff = new StringBuffer("Hello");
		
		StringPractice sd = new StringPractice();
		
		System.out.println(sd.removeEveryOtherLetter("Hello World!"));
		
		System.out.println(getControllerValue("localhost:3500/[controller]/[resource]"));
	}
	
	/*
	 * Using StringBuilder and its associated methods (if needed), 
	 * create a method that removes every other letter of a String passed in 
	 * and return that newly created string.
	 */
	public String removeEveryOtherLetter(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < s.length(); i= i+2) {
			sb.append(s.charAt(i));
		}
		
		
		String s2 = sb.toString();
		
		return s2;
		
		
	}


	/*
	 * Given the string of a url of the format localhost:3500/[controller]/[resource]
	 * where "localhost:3500" is a constant
	 * controller and resource can be any 1 word
	 * return the value of controller as a string
	 */
	public static String getControllerValue(String url) {
		StringBuilder sb = new StringBuilder();
		
		int indexStart = url.indexOf("/");
		int indexEnd = url.indexOf("/", indexStart+1);
		
		for(int i= indexStart+1; i < indexEnd; i++) {
			sb.append(url.charAt(i));
		}
	    
		
		String con = sb.toString();
		return con;
	}
	

}



