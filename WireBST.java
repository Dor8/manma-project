// this class holds the data structure of wire binary search tree


import javafx.event.ActionEvent;
import javafx.scene.control.Label;
//import WireBSTNode; //needed?

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

    public void setHead(WireBSTNode newHead){
        _head = newHead ;
    }



    /**
     * insert of the node to the WireBST
     * @param studentNum
     * @param studentName
     */
    public void insertWireBSTNode(int studentNum , String studentName){
        WireBSTNode newNode = new WireBSTNode(studentNum , studentName);
        WireBSTNode currentNode = this.getHead(); // alias, its a pointer to where i will insert the new node
        boolean insertedFlag = false;

        if( currentNode == null ) // empty tree case
        {
            this.setHead(newNode);
            return;
        }

        while ( ! InsertedFlag )
        {
            if (currentNode.getStudentNum() >= newNode.getStudentNum())
                if ( ! currentNode.isRealLeft())
                {
                    insertToLeft(currentNode , newNode);
                    InsertedFlag = true;
                }
                else
                    currentNode = currentNode.getLeft();
            else
                if ( ! currentNode.isRealRight())
                {

                    insertToRight(currentNode , newNode);
                    InsertedFlag = true;
                }
                else
                    currentNode = currentNode.getRight();
        }
    }

    /**
     * insert the new node to the left of the current node.
     * @param current is the node that will get a new left son.
     * @param newNode is the node to add.
     */
    private void insertToLeft(WireBSTNode current , WireBSTNode newNode ){
        newNode.setParent(current);
        newNode.setLeft(current.getLeft());  // make the predeccessor of the leaf to be the predeccessor of the new node.
        current.setLeft(newNode);  // insert the new node to her place!
        newNode.setRight(currentNode); // make the successor of the new node to be her parent, because it is the successor (only in insert to right!).
    }

    /**
     * insert the new node to the right of the current node.
     * @param current is the node that will get a new right son.
     * @param newNode is the node to add.
     */
    private void insertToRight(WireBSTNode current , WireBSTNode newNode ){
        newNode.setParent(current);
        newNode.setRight(current.getRight());  // make the successor of the leaf to be the successor of the new node.
        current.setRight(newNode);  // insert the new node to her place!
        newNode.setLeft(currentNode); // make the predecessor of the new node to be her parent, because it is the predecessor (only in insert to left!).
    }


    /**
     * remove of the node WireBST
     * @param node is the node to remove.
     */
    public void removeWireBSTNode(WireBSTNode node){
        if ( node == null) return;
        if ( ! node.isRealLeft() && ! node.isRealRight() ){
            removeDeepLeaf(node);
        }
        if ((node.isRealRight()) && (!node.isRealLeft())){    //** in case of removing node who has only right son
            removeNodeWithOnlyRightSon(node);
        }
        if ((!node.isRealRight()) && (node.isRealLeft())){    //** in case of removing node who has only left son
            removeNodeWithOnlyLeftSon(node);
        }
        if ((node.isRealRight()) && (node.isRealLeft())) {    //** in case of removing node who has two sons
            removeNodeWithTwoSons(node);
        }
    }

    /**
     * removing a deep leaf. used by the removeWiredBSTNode function
     * @param node. the node we wish to remove
     */
    private void removeDeepLeaf(WireBSTNode node){
        if (node.getParent() == null){
            _head = null;
            return;
        }
        if (node.equal(node.getParent().getRight())) {
            node.getParent().setRight(node.getRight());
        }
        else {
            node.getParent().setLeft(node.getLeft());
        }
    }

    /**
     * removing a node (who is right son) with just one son
     * @param node. the node we wish to remove
     */
    private void removeNodeWithOnlyRightSon(WireBSTNode node){
        if (node.equal(node.getParent().getRight())){             // in case the node is a right son
            node.getParent().setRight(node.getRight());
        }
        if (node.equal(node.getParent().getLeft())){              // in case the node is a left son
            node.getParent().setLeft(node.getRight());
        }
    }

    /**
    * removing a node (who is left son) with just one son
    * @param node. the node we wish to remove
    */
    private void removeNodeWithOnlyLeftSon(WireBSTNode node){
        if (node.equal(node.getParent().getRight())){             // in case the node is a right son
            node.getParent().setRight(node.getLeft());
        }
        if (node.equal(node.getParent().getLeft())){              // in case the node is a left son
            node.getParent().setLeft(node.getLeft());
        }
    }

    /**
     * remove node who has two sons
     * @param node with two sons
     */
    private void removeNodeWithTwoSons(WireBSTNode node){
        WireBSTNode temp = node.getSuccessor();
        if (node.getParent() == null )){
            _head = temp;
            temp.setRight(node.getRight());
            temp.setLeft(node.getLeft());
        } else if (node.equal(node.getParent().getRight())){
            temp.setRight(node.getRight());
            temp.setLeft(node.getLeft());
            node.getParent().setRight(temp);
        } else {
            temp.setRight(node.getRight());
            temp.setLeft(node.getLeft());
            node.getParent().setLeft(temp);
        }            
    }

                                   
    // search for node WireBST
    public void searchWireBST( WireBSTNode node ){


    }

    // find the Successor of the node WireBST
    public void findSuccessor( WireBSTNode node ){


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

    /**
     * print the wireBST as pre oder
     * @param node
     */
    public void preOrderScan(WireBSTNode node){

        if(node == null) return;

        printNode(node);

        preOrderScan(node.getLeft());

        preOrderScan(node.getRight());

    }

    /**
     * print the wireBST as in order
     * @param node
     */
    public void inOrderScan(){

        WireBSTNode temp = minWireBST();

        for (; temp != null; temp = temp.getRight()){
            printNode(temp);
        }

    }

    /**
     * print the wireBST as post order
     * @param node
     */
    public void postOrderScan(WireBSTNode node){

        if (node == null) return;

        postOrderScan(node.getLeft());

        postOrderScan(node.getRight());

        printNode(node);

    }

    /**
     *
     * @param node
     */
    private void printNode(WireBSTNode node){
        System.out.println(node.getStudentNum() + " ");
        System.out.println(node.getStudentName() + " ");
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
    
}  // end of WireBST class

}
