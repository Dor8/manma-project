// this class holds the data structure of wire binary search tree


import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class WireBST{


    private WireBSTNode _head;


    public Label helloWorld;  // lable for the gui

    // constractor
    public WireBST(int studentNum , String name )
    {
        WireBSTNode head = new WireBSTNode(studentNum , name);
        _head = head ;

    }

    public WireBST() {
    }


    public WireBSTNode getHead(){
        return _head;
    }

	// insert of the node WireBST
    public void insertWireBST(WireBSTNode node){


    }

    // remove of the node WireBST
    public void removeWireBST(WireBSTNode node){


    }

    // search for node WireBST
    public void searchWireBST(WireBSTNode node){


    }

    // find the Successor of the node WireBST
    public void findSuccessor(WireBSTNode node){


    }

    // find the Predecessor of the node WireBST
    public void findPredecessor(WireBSTNode node){


    }

    /*
    * find the minimum node WireBST
    * the leftest node in the BST is the min node in it
    * */
    public WireBSTNode minWireBST(WireBSTNode node){
        if(node == null)
            return null;
        if (node.getLeft() == null)
            return node;
        else
            return minWireBST(node.getLeft());
    }

    /*
    * find the maximum node WireBST
    * the rightest node in the BST is the max node in it
    * */
    public void maxWireBST(WireBSTNode node){
        if(node == null)
            return null;
        if (node.getRight() == null)
            return node;
        else
            return minWireBST(node.getRight());


    }

    // print the WireBST as pre order
    public void preOrderScan(WireBSTNode node){


    }

    // print the WireBST as in order
    public void inOrderScan(WireBSTNode node){


    }

    // print the WireBST as post order
    public void postOrderScan(WireBSTNode node){


    }

    // return the median WireBST
    public WireBSTNode medianWireBST(WireBSTNode node){

        return node;
    }


    // Function to print binary tree in 2D
    // It does reverse inorder traversal
    // i translate it from C. cradit to: https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
    public static void print2DNodeWireBST(WireBSTNode head, int space)
    {
        // Base case
        if (head == null)
            return;

        // Increase distance between levels
        space += Constants.COUNT;

        // Process right child first
        print2DNodeWireBST(head.getRight() , space);

        // Print current node after space count
        System.out.println();    // go one line down
        for (int i = Constants.COUNT ; i < space; i++)
            System.out.println(" ");
        System.out.println(Integer.valueOf(head.getStudentNum()) + head.getName() + "\n" );

        // Process left child
        print2DNodeWireBST(head.getLeft(), space);
    }


    /*  this is for the gui, if will be implement.
    * public void print2DWireBST(){
    *     WireBSTNode.print2DNodeWireBST(getHead(), 0 );
    * }
    *
    * public void sayHello(ActionEvent actionEvent) {
    *     helloWorld.setText("Hello World!");
    * }
    *
    *
    * */

}