// this class holds the data structure of wire binary search tree


//import WireBSTNode; //needed?

public class WireBST{


    private WireBSTNode _head;
    private WireBSTNode _median;
    private int _nodeCounter;


    /**
     * constractor
     */
    public WireBST()
    {
        _head = null ;
        _median = null;
        _nodeCounter = 0;
    }



    public WireBSTNode getHead(){
        return _head;
    }

    public void setHead(WireBSTNode newHead){
        _head = newHead ;
    }

    private int getNodeCounter(){
        return this._nodeCounter;

    }


    /**
     * insert of the node to the WireBST
     * @param studentNum the student number
     * @param studentName the student name
     */
    public boolean insertWireBSTNode(int studentNum , String studentName){
        WireBSTNode newNode = new WireBSTNode(studentNum , studentName);
        WireBSTNode currentNode = this.getHead(); // alias, its a pointer to where i will insert the new node
        boolean insertedFlag = false;

        if( currentNode == null ) // empty tree case
        {
            this.setHead(newNode);
            this.setMedian(newNode);
            _nodeCounter ++ ;
            return true;
        }

        if( searchWireBST(newNode.getStudentNum()) != null ){
            System.out.println( Constants.ERROR_INSERT);
            return false;
        }


        while ( ! insertedFlag )
        {
            if (currentNode.getStudentNum() > newNode.getStudentNum())
                if ( ! currentNode.isRealLeft())
                {
                    insertToLeft(currentNode , newNode);
                    insertedFlag = true;
                }
                else
                    currentNode = currentNode.getLeft();
            else
                if ( ! currentNode.isRealRight())
                {

                    insertToRight(currentNode , newNode);
                    insertedFlag = true;
                }
                else
                    currentNode = currentNode.getRight();
        }
        updateMedianInsert(newNode);
        return true;
    }

    /**
     * insert the new node to the left of the current node.
     * @param currentNode is the node that will get a new left son.
     * @param newNode is the node to add.
     */
    private void insertToLeft(WireBSTNode currentNode , WireBSTNode newNode ){
        newNode.setParent(currentNode);
        newNode.setLeft(currentNode.getLeft());  // make the predeccessor of the leaf to be the predeccessor of the new node.
        currentNode.setLeft(newNode);  // insert the new node to her place!
        newNode.setRight(currentNode); // make the successor of the new node to be her parent, because it is the successor (only in insert to right!).
    }

    /**
     * insert the new node to the right of the current node.
     * @param currentNode is the node that will get a new right son.
     * @param newNode is the node to add.
     */
    private void insertToRight(WireBSTNode currentNode , WireBSTNode newNode ){
        newNode.setParent(currentNode);
        newNode.setRight(currentNode.getRight());  // make the successor of the leaf to be the successor of the new node.
        currentNode.setRight(newNode);  // insert the new node to her place!
        newNode.setLeft(currentNode); // make the predecessor of the new node to be her parent, because it is the predecessor (only in insert to left!).
    }

    private void updateMedianInsert(WireBSTNode newNode){
        if(newNode.getStudentNum() > this.getMedianWireBST().getStudentNum() ){
            if (this.getNodeCounter() % 2 == 0){
                this.setMedian ( getSuccessor( this.getMedianWireBST() ) ) ;
            }
        else
            if (this.getNodeCounter() % 2 == 1){
                this.setMedian ( getPredecessor( this.getMedianWireBST() ) ) ;
            }
        this._nodeCounter ++;
        }




    }

    // remove of the node WireBST
    public void removeWireBST(int studetNum){


    }

    /**
     *
     * @param studentNum the key to look for in the tree.
     * @return pointer to the node if find it in the tree, or null if its not in the tree.
     */
    public WireBSTNode searchWireBST(int studentNum){
        if ( this.getHead() == null)  // edge case of null or empty tree
            return null;
        WireBSTNode temp = this.getHead();
        while( ( temp != null ) && ( studentNum != temp.getStudentNum() ) ){
            if( ( studentNum < temp.getStudentNum() )) {
                if (temp.isRealLeft())
                    temp = temp.getLeft();
                else
                    temp = null;
            }
            else {
                if (temp.isRealRight())
                    temp = temp.getRight();
                else
                    temp = null;
            }
        }
        return temp ;
    }

    /**
     * find the Successor of the node WireBST.
     * @param node is the current node, that looking for her's successor.
     * @return the successor of node.
     */
    public WireBSTNode getSuccessor(WireBSTNode node){
        if ( node == null )
            return null;
        if ( ! node.isRealRight() )     // if the right son isnt real, so he is the successor!
            return node.getRight();
        WireBSTNode temp;
        for( temp = node.getRight(); temp.isRealLeft() ; temp = temp.getLeft() )  // temp one step to the right, and then run all the way left, tilll he reach a non-real son.
            ;
        return temp ;
    }

    /**
     * find the Predecessor of the node WireBST.
     * @param node is the current node, that looking for her's predecessor.
     * @return the predecessor of node.
     */
    public WireBSTNode getPredecessor(WireBSTNode node){
        if ( node == null )
            return null;
        if ( ! node.isRealLeft() )     // if the left son isnt real, so he is the successor!
            return node.getLeft();
        WireBSTNode temp;
        for(temp = node.getLeft(); temp.isRealRight() ; temp = temp.getRight() )  // temp go one step to the left, and then run all the way right, tilll he reach a non-real son.
            ;
        return temp ;
    }

    /*
    * find the minimum node WireBST
    * the leftest node in the BST is the min node in it
    * */
    public WireBSTNode minWireBST(){
        if( this.getHead() == null )
            return null;
        WireBSTNode temp = this.getHead();
        while (temp.getLeft() != null)
            temp = temp.getLeft();
        return temp;
    }

    /*
    * find the maximum node WireBST
    * the rightest node in the BST is the max node in it
    * */
    public WireBSTNode maxWireBST(){
        if( this.getHead() == null )
            return null;
        WireBSTNode temp = this.getHead();
        while (temp.getRight() != null)
            temp = temp.getRight();
        return temp;
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

    /**
     *
     * @return the median WireBST
     */
    public WireBSTNode getMedianWireBST()
    {
        return _median;

    }

    /**
     *
     * @param median is the new median to be set.
     */
    private void setMedian(WireBSTNode median) {
        this._median = median;
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
        System.out.println(Integer.valueOf(head.getStudentNum()) + head.getStudentName() + "\n" );

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
