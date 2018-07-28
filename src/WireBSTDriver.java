import java.util.*;

public class WireBSTDriver {
    
    public static void main(String[] args) {

        // define all the variables of the main function: wireBST and more

        boolean isRunning = true; // flag to indicate from the user when to exit from the program
        Scanner scanner = new Scanner(System.in);

        String command;
        String firstParam;
        String secondParam;
        String userInput;
        WireBST tree = new WireBST();

        // get the input from the user for build the tree (maybe in while loop? how the program ends?)
        while (isRunning){
            promptUser();
            userInput = scanner.nextLine();                // get input from the user: which action to do? + parameters

            String parts []  = userInput.split(" ") ;
            command = parts [0];
            firstParam = parts [1];
            secondParam = parts [2];

            switch (command){
                case "exit" : exit();
                              break;
                case "help" : helpUser();
                                break;
                case "insert" : insert( tree , Integer.valueOf( firstParam ) , secondParam );
                                break;
                case "remove" : remove( tree , Integer.valueOf( firstParam ) );
                                break;

            }




        }








    }

    private static void remove(WireBST tree, int studentNum ) {
        tree.removeWireBST( studentNum ) ;

    }

    private static void helpUser() {
        System.out.println(Constants.HELP_TEXT);
    }

    private static void promptUser() {
        System.out.println(Constants.PROMPT_USER);
    }

    private static void insert(WireBST tree, int studentNum, String studentName) {
        tree.insertWireBSTNode( studentNum, studentName );
    }




    // call when the user want to finish the program
    private static void exit(){
        isRunning = false;
    }


}
