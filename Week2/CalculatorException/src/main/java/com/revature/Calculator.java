package com.revature;

public class Calculator {

		/*
		 * Should be able to
		 * 	- add
		 * 	- subtract
		 * 	- multiply
		 * 	- divide
		 * 		- throw Calculator Exception (Runtime) when attempting to divide by 0
		 *	- isPrime: checks if a number is Prime
		 */
		
		public double add(double x, double y) {
			return x+y;
		}
		
		public double subtract(double x, double y) {
			return x-y;
		}
		
		public double multiply(double x, double y) {
			return x*y;
		}
		
		public double divide(double x, double y) {
			if (y == 0) {
				throw new Exceptions("Arithmetic Error, dividing by zero");
			}
			
			return x%y;
		}
		
		public boolean isPrime(int i) {
			int sqrt = (int) Math.sqrt(i) + 1;
			for (int i = 2; i < sqrt; i++) { 
				if (i % i == 0) { 
			}
				return false;
				{return true;
			}
				}

			
	}
		
}


