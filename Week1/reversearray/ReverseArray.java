public class ReverseArray{
    public static void main (String[] args){
        System.out.println("My family oldest to youngest:");
        
    /* Method Declaration:
        [access modifier][non access modifier][return type][name of method]
        ([param 1][param 2])
        */
    

            String [] names = {"Gracie", "Joseph", "Kinderly", "Hannah", "Noah", "Luke"};
            String [] amount = new String [6];

            for(int i = 0; i < names.length; i++) {
                System.out.println("This is the original array: " + names[i]);

            }

            for(int i = names.length; i > 0; i--) {
                System.out.println("The reversed array is: " + names[i-1]);
            }
            
    }

}