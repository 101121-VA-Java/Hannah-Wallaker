public static void main(String[] args) { // This declares the method access is public, it is a static method meaning 
                                            //it belongs to a class which is not listed in this assignment, and we see our parameters 
                                            //being a String with arguments.
	String[] foodTypes = getFoodTypes(); // This declares a string of food types and sets the value equal to getFoodTypes
	String myType = foodTypes[2]; // This declares a string of myType and looks at foodType 2 which is dinner

	String[] foodsOfMyType = getFoodsByType(myType); // This declares another String foodsOfMyType and combines the two strings above
	
	for (String food : foodsOfMyType) { // a for loop that says for String food, we will return the array foodsOfMyType
		System.out.println(food); // print the name of the food
	}
}

public static String[] getFoodTypes() { // Declares a new method that returns a String of getFoodTypes
	String[] foodTypes = {"breakfast","lunch","dinner","dessert","snack"};// Shoes the elements of our String
	return foodTypes; // returns the members of the array above
}

public static String[] getFoodsByType(String type) {// Declares a new method that returns a String of getFoodsByType with parameters
													// that it will be a String and return type which will be foods
	String[] foods = new String[3]; //Declares that the String foods will return a new String with 3 food items seen as [0, 1, and 2]

	switch(type) { // Creating a switch to switch the type
	case "breakfast": // if case breakfast, return the three below food types
		foods[0] = "pancakes";
		foods[1] = "cereal";
		foods[2] = "omelette";
		break; // moves us on to the next case
	case "lunch": // if case lunch, return the three food types below
		foods[0] = "sandwich";
		foods[1] = "salad";
		foods[2] = "soup";
		break; // next case
	case "dinner": // if case dinner (which is our case this problem falls into because of String myType), return the three below types
		foods[0] = "curry";
		foods[1] = "stir fry";
		foods[2] = "burger";
		break;// next case
	case "dessert": // if case dessert, return below
		foods[0] = "cake";
		foods[1] = "ice cream";
		foods[2] = "candy";
		break; // next case
	case "snack": // if case snack, return below
		foods[0] = "chips";
		foods[1] = "apple";
		foods[2] = "samosa";
		break;
	default: // will default to this if no other cases declared
		system.out.println("you're not hungry");
		break;
	}

	return foods;// we will return the String foods after this Switch
}