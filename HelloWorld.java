public class HelloWorld {
	
	public static void main (String[] args) {
	System.out.println("Hello, world!");
	System.out.println("This is my attempt at basic java control flow statements");
		int in = 24;
		int in1 = 3;
		int in2 = 36;
		int in3 = 14;
		boolean bo = true;

		if (in == 24){
			System.out.println("in is equal to 24");
		} else if(in == 6){
			System.out.println("in is invalid");
		}
		else {
			System.out.println("Actually in is equal to " + in);

		}

		boolean condition = true;

		while(in < 10 && condition){
			System.out.println(in);
			in++;
		}

}

}

