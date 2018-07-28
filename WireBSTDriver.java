import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.*;
public class WireBSTDriver {


    static boolean isRunning = true; // flag to indicate from the user when to exit from the program



    public static void main(String[] args) {

        // define all the variables of the main function: wireBST and more
        Scanner scanner = new Scanner(System.in);




        // get the input from the user for build the tree (maybe in while loop? how the program ends?)
        while (isRunning){
            System.out.println(Constants.PROMPT_USER);
            userInput = scanner.nextLine();                                   // get input from the user: which action to do? + parameters
            parseLine(command , firstParam , secondParam, userInput);         //
            switch (command){
                case "exit" : exit();
                              break;
                case "help" : System.out.Println(HELP_TEXT);
                                break;
                case "insert" : insert( firstParam , secondParam );
                                break;
                case "remove" : remove( firstParam );
                                break;

            }




        }








    }



    // ask the user to choose a method to preform
    void askTheUser(){

    }


    // call when the user want to finish the program
    void exit(){
        isRunning = false;
    }


}
