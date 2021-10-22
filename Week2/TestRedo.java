import java.lang.*;
import java.io.*;
import java.util.*;

public class TestRedo
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        String input = sc.next();
            
        System.out.println(getVowel(input));
    
    }
    
    //WRITE YOUR CODE BELOW HERE

public static String getVowel(String s) {

    String vowels = s;


     for (int i = 0; i < s.length(); i++){
        if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
            System.out.println (" " + s.charAt(i));
        }
            }

       if (s == " "){
           return s;
       }else{
           return null;
       }
        
    
}
}


/* 
Here is my code from the test I submitted:


import java.lang.*;
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        String input = sc.next();
            
        System.out.println(getVowel(input));
    
    }
    
    //WRITE YOUR CODE BELOW HERE

public static char getVowel(String s) {

    String input = new String(s);
    
     for (int i = 0; i < s.length; i++){
        if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
            System.out.println (" " + s.charAt(i));
                }else{
                    System.out.println("No Vowels!");
                }
            }
        
    
}
}
*/