import java.io.*;
import java.util.*;

public class WireBSTDriver {

    private static boolean isRunning = true;  // flag to indicate from the user when to exit from the program
    private static Scanner scanner = new Scanner(System.in);   // stream to get input from. start from the keyboard, and the user can change it to a file.

    public static void main(String[] args) {

        // define all the variables of the main function: wireBST and more

        String userInput = "" ;  // user input is a line build in this format: <command> <firstParam> <secondParam>
        String command = "" ;
        String firstParam = "";
        String secondParam = "";
        WireBST tree = new WireBST();
         // get the input from the user for build the tree, or make other actions.
        while (isRunning){
            promptUser();
            if (scanner.hasNextLine()){
                userInput = scanner.nextLine();                // get input from the user: which action to do? + parameters
                System.out.printf("your command is: %s\n", userInput);
            }
            else{
                exit();
            }

            String parts []  = userInput.split(" ") ;  // credit for split goes to: https://stackoverflow.com/questions/3481828/how-to-split-a-string-in-java
            command = parts [0];
            if ( parts.length > 1 ) {
                firstParam = parts[1];
                if (parts.length > 2 ){
                    secondParam = parts [2];
                }
            }


            switch (command){
                case "help" : printHelp();
                              break;
                case "exit" : exit();
                    break;
                case "insert" : insert( tree , firstParam , secondParam );
                                break;
                case "remove" : remove( tree , Integer.valueOf( firstParam ) );
                                break;
                case "search" : search( tree , Integer.valueOf( firstParam ) );
                    break;
                case "successor" : successor( tree , Integer.valueOf( firstParam ) );
                    break;
                case "predecessor" : predecessor( tree , Integer.valueOf( firstParam ) );
                    break;
                case "max" : max( tree );
                    break;
                case "min" : min( tree );
                    break;
                case "preorder" : preorder( tree );
                    break;
                case "pre" : preorder( tree );
                    break;
                case "inorder" : inorder( tree );
                    break;
                case "in" : inorder( tree );
                    break;
                case "postorder" : postorder( tree );
                    break;
                case "post" : postorder( tree );
                    break;
                case "median" : median( tree );
                    break;
                case "count" : count( tree );
                    break;
                case "gui" : gui( tree );
                    break;
                case "file" : readFile(firstParam);
                    break;
                default: printHelp();
            }
            command = "" ; firstParam = ""; secondParam = "" ;  // reset all the argument from the user
        }  // end of while loop
    }   // end of main

    private static void count(WireBST tree) {
        System.out.println(Constants.TREE_COUNT + String.valueOf(tree.countNodes(tree.getHead())));
    }

    private static void readFile(String fileName) {
        if (fileName != ""){
            try {   // try to redirect the input stream to the file specified. credit goes to: https://www.journaldev.com/709/java-read-file-line-by-line#java-read-file-line-by-line-using-scanner
                scanner = new Scanner(new File(fileName));       // redirect the input to come from the file
                System.out.printf("Read from file: %s\n" , fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                try {
                    Thread.sleep(100);           // paused the program to 0.1 sec, to allow full print of the system's error messages.
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.println(Constants.ERROR_READ_FILE);
            }
        }
        else {
            System.out.println(Constants.ERROR_FILE_NAME_IS_REQUIRED);
        }
    }


    private static void gui(WireBST tree) {
        System.out.println("Gui is: ");
        WireBST.print2DNodeWireBST(tree.getHead() , Constants.ZERO, tree);
        count(tree);
    }

    private static void median(WireBST tree) {
        WireBSTNode.printData(tree.getMedianWireBST(), tree);
    }
     private static void postorder(WireBST tree) {
        tree.postOrderScan(tree.getHead());
    }
     private static void inorder(WireBST tree) {
         tree.inOrderScan();
    }
     private static void preorder(WireBST tree) {
         tree.preOrderScan(tree.getHead());
    }

    private static void min(WireBST tree) {
        WireBSTNode.printData(tree.minWireBST(), tree);
    }

    private static void max(WireBST tree) {
        WireBSTNode.printData(tree.maxWireBST(), tree);
    }

    private static void predecessor(WireBST tree, int studentNum) {
        WireBSTNode.printData(tree.getPredecessor( tree.searchWireBST( studentNum ) ), tree);
    }

    private static void successor(WireBST tree, int studentNum) {
        WireBSTNode.printData(tree.getSuccessor( tree.searchWireBST( studentNum ) ), tree);
    }

    private static void search(WireBST tree, int studentNum) {
        WireBSTNode.printData(tree.searchWireBST(studentNum), tree);

    }

    private static void remove(WireBST tree, int studentNum ) {
        if (tree.removeWireBSTNode( studentNum )) {
            System.out.printf(Constants.NODE_REMOVED, String.valueOf(studentNum));
        }
        else{
            System.out.println(Constants.ERROR_REMOVE);
        }

    }

    private static void printHelp() {
        System.out.println(Constants.HELP_TEXT);
    }
     private static void promptUser() {
        System.out.println(Constants.PROMPT_USER);
    }
     private static void insert(WireBST tree, String studentNum, String studentName) {
        if (studentNum.matches("-?\\d+")) // credit for the regex goes to this answer (stackoverflow):  https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
        {
            tree.insertWireBSTNode(Integer.valueOf(studentNum), studentName);
        }
        else{
            System.out.println(Constants.ERROR_FIRST_PARAM_NOT_NUMBER);
        }

    }
     // call when the user want to finish the program
    private static void exit(){
        isRunning = false;
    }
 }
