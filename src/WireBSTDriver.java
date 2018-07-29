import java.util.*;

public class WireBSTDriver {

    private static boolean isRunning = true;  // flag to indicate from the user when to exit from the program

    public static void main(String[] args) {

        // define all the variables of the main function: wireBST and more

        Scanner scanner = new Scanner(System.in);

        String command = "" ;
        String firstParam = "";
        String secondParam = "";
        String userInput = "" ;
        WireBST tree = new WireBST();

        // get the input from the user for build the tree (maybe in while loop? how the program ends?)
        while (isRunning){
            promptUser();
            userInput = scanner.nextLine();                // get input from the user: which action to do? + parameters

            String parts []  = userInput.split(" ") ;
            command = parts [0];
            if ( parts.length > 1 ) {
                firstParam = parts[1];
                if (parts.length > 2 ){
                    secondParam = parts [2];
                }
            }


            switch (command){
                case "help" : helpUser();
                              break;
                case "exit" : exit();
                              break;
                case "insert" : insert( tree , Integer.valueOf( firstParam ) , secondParam );
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
                case "inorder" : inorder( tree );
                    break;
                case "postorder" : postorder( tree );
                    break;
                case "median" : median( tree );
                    break;
                case "gui" : gui( tree );
                    break;
                case "file" : readFile( firstParam );
                    break;
            }


        }

    }

    private static void readFile(String firstParam) {
    }


    private static void gui(WireBST tree) {
        WireBST.print2DNodeWireBST(tree.getHead() , Constants.ZERO);
    }

    private static void median(WireBST tree) {
        tree.getMedianWireBST().printData();
    }


    private static void postorder(WireBST tree) {
        tree.postOrderScan();
    }

    private static void inorder(WireBST tree) {
        tree.inOrderScan();
    }

    private static void preorder(WireBST tree) {
        tree.preOrderScan();
    }

    private static void min(WireBST tree) {
        tree.minWireBST().printData();
    }

    private static void max(WireBST tree) {
        tree.maxWireBST().printData();
    }

    private static void predecessor(WireBST tree, int studentNum) {
        tree.getPredecessor( tree.searchWireBST( studentNum ) ).printData();
    }

    private static void successor(WireBST tree, int studentNum) {
        tree.getSuccessor( tree.searchWireBST( studentNum ) ).printData();
    }

    private static void search(WireBST tree, int studentNum) {
        tree.searchWireBST(studentNum).printData();

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
