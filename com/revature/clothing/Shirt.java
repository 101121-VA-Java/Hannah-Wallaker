package com.revature.clothing;

public class Shirt{

public static String color;
public static char size;


Shirt(String newColor, char newSize ){
    color = newColor;
    size = newSize;
}


Shirt() {
}

    public static void wear() {
        System.out.println("wearing the shirt.");

    }

    public static void notwear() {
        System.out.println("shirtless");
    }
    
    public static void setColor(String newColor){
        color = newColor;
    }

    public static void setSize(char newSize){
        size = newSize;
    }


}