// this class holds the data structure of wire binary search tree


//import WireBSTNode; //needed?

public class WireBST{


    private WireBSTNode _head;
    private WireBSTNode _median;
    private int _nodeCounter;


    /**
     * constructor
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
     * count the number of nodes in the tree.
     * Complexity: O(n). Because it's recursively goes to all the nodes in the tree, and visit each one of them one time.
     * @param node is the head of the sub tree that start from it.
     * @return the number of nodes in the tree.
     */
    public int countNodes(WireBSTNode node) {
        int count = 0;
        if (node == null)  // empty tree
        {
            return 0;
        }
        count++;  // count the current node
        if ( ( ! node.isRealLeft()) && ( ! node.isRealRight()))  // leaf
        {
            return count ;
        }

        if ( node.isRealLeft())  // count all the nodes in the left sub tree
        {
            count += countNodes(node.getLeft());
        }
        if ( node.isRealRight())  // count all the nodes in the right sub tree
        {
            count += countNodes(node.getRight());
        }
        return count;
    }


    /**
     * insert of the node to the WireBST
     * Complexity: O(lg(n)) (height of the tree) - capitalize the BST attributes by going down the levels after compare the insert
     * value to the node and response respectively to the result: right for node bigger, otherwise left.
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

        if( searchWireBST(newNode.getStudentNum()) != null )  // case that this node is already in the tree (cant override)
        {
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
     * Complexity: O(1). overloading the insert function, a constant number of action, does not change the overall complexity.
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
     * Complexity: O(1). overloading the insert function, a constant number of action, does not change the overall complexity.
     * @param currentNode is the node that will get a new right son.
     * @param newNode is the node to add.
     */
    private void insertToRight(WireBSTNode currentNode , WireBSTNode newNode ){
        newNode.setParent(currentNode);
        newNode.setRight(currentNode.getRight());  // make the successor of the leaf to be the successor of the new node.
        currentNode.setRight(newNode);  // insert the new node to her place!
        newNode.setLeft(currentNode); // make the predecessor of the new node to be her parent, because it is the predecessor (only in insert to left!).
    }

    /**
     * update the median after insert a node
     * @param newNode the node that inserted
     */
    private void updateMedianInsert(WireBSTNode newNode){
        if(newNode.getStudentNum() > this.getMedianWireBST().getStudentNum() ) {
            if (this.getNodeCounter() % 2 == 0) {
                this.setMedian(getSuccessor(this.getMedianWireBST()));
            }
        }
        else if (this.getNodeCounter() % 2 == 1) {
            this.setMedian(getPredecessor(this.getMedianWireBST()));
        }
        this._nodeCounter ++;
    }

    /**
     * remove the student that his number is the given parameter
     * Complexity: O(lg(n))- for searching the node we wish to remove by call search function. Up next overloading the remove function
     * will not change the function's complexity.
     * @param studentNum , the key for node to remove
     * @return true if the node was removed, else false
     */
    public boolean removeWireBSTNode(int studentNum){

        WireBSTNode temp = searchWireBST( studentNum );

        if (temp == null){
            return false;
        }
        else {
            updateMedianRemove(temp);
            removeWireBSTNode(temp);
            return true;
        }
    }

    /**
     * overloading the removeWireBSTNode function, remove node who exist in the tree
     * Complexity: O(1) - constant number of actions.
     * @param node is the node to remove.
     */
    public void removeWireBSTNode(WireBSTNode node){

        if ( ! node.isRealLeft() && ! node.isRealRight() ){        //** in case of removing deep leaf
            removeDeepLeaf(node);
        }
        else if ((node.isRealRight()) && (!node.isRealLeft())){    //** in case of removing node who has only right son
            removeNodeWithOnlyRightSon(node);
        }
        else if ((!node.isRealRight()) && (node.isRealLeft())){    //** in case of removing node who has only left son
            removeNodeWithOnlyLeftSon(node);
        }
        else {                                                     //** in case of removing node who has two sons
            removeNodeWithTwoSons(node);
        }
    }

    /**
     * removing a deep leaf. used by the removeWiredBSTNode function
     * @param node the node we wish to remove
     */
    private void removeDeepLeaf(WireBSTNode node){

        if (node.getParent() == null){                              //in case node is root and has no sons
            this.setHead(null);
        }

        else if (node.equal(node.getParent().getRight())) {         //in case node is a right deep leaf
            node.getParent().setRight(getSuccessor(node));
        }

        else {
            node.getParent().setLeft(getPredecessor(node));         // in case node is a left deep leaf
        }
    }

    /**
     * update the median after remove of a node
     * @param node, the node that removed
     */
    private void updateMedianRemove(WireBSTNode node){

        if (this.getNodeCounter() == 1) {
            this.setMedian(null);
        }
        else if (this.getNodeCounter() % 2 == 0) {

            if (node.getStudentNum() <= this.getMedianWireBST().getStudentNum())
                this.setMedian(getSuccessor(this.getMedianWireBST()));
        }
        else  {
            if (node.getStudentNum() >= this.getMedianWireBST().getStudentNum())
            this.setMedian(getPredecessor(this.getMedianWireBST()));
        }
        this._nodeCounter --;
    }

    /**
     * removing a node with only right son
     * @param node the node we wish to remove
     */
    private void removeNodeWithOnlyRightSon(WireBSTNode node){

        if (node.getParent() == null){                                  //in case node is root
            this.setHead(node.getRight());
            getSuccessor(node).setLeft(node.getLeft());
        }

        else if  (node.equal(node.getParent().getRight())){            //in case node is right son
            node.getParent().setRight(node.getRight());
            getSuccessor(node).setLeft(node.getParent());
        }
        else {                                                         //in case node is left son
            node.getParent().setLeft(node.getRight());
            getSuccessor(node).setLeft(getPredecessor(node));
        }
        node.getRight().setParent(node.getParent());
    }



    /**
    * removing a node with only left son
    * @param node the node we wish to remove
    */
    private void removeNodeWithOnlyLeftSon(WireBSTNode node){

        if (node.getParent() == null){
            this.setHead(node.getLeft());
            getPredecessor(node).setRight(node.getRight());
        }

        else if (node.equal(node.getParent().getRight())){
            node.getParent().setRight(node.getLeft());
            getPredecessor(node).setRight(getSuccessor(node));
        }

        else {
            node.getParent().setLeft(node.getLeft());
            getPredecessor(node).setRight(getSuccessor(node));
        }
        node.getLeft().setParent(node.getParent());
    }

    /**
     * remove node who has two sons
     * Complexity: O(1). overloading the insert function, a constant number of action, does not change the overall complexity.
     * @param node with two sons
     */
    private void removeNodeWithTwoSons(WireBSTNode node){

        WireBSTNode temp = getSuccessor(node);
        WireBSTNode dataSaver = new WireBSTNode(node.getStudentNum(), node.getStudentName());
        dataSaver.copyData(temp);
        removeWireBSTNode(temp); // remove the successor of node. in this call, its promised that temp have at the max 1 child, so he will be remove easily.
                                 // this assuming is good because its cant be the successor if it have 2 sons.
        node.copyData(dataSaver);
    }

    /**
     * @param studentNum the key to look for in the tree.
     * Complexity: O(lg(n)) - (height of the tree). Implementation of binary search, going down the tree according to the
     * result of the comparison.
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
     * Complexity: O(lg(n)) worst case (successor of the root is the deepest leaf). after getting right child going down the tree
     * until there is no left son.
     * @param node is the current node, that looking for her's successor.
     * @return the successor of node.
     */
    public WireBSTNode getSuccessor(WireBSTNode node){
        if ( node == null || node.getRight() == null)
            return null;
        if ( ! node.isRealRight() )     // if the right son isn't real, so he is the successor!
            return node.getRight();
        WireBSTNode temp;
        for( temp = node.getRight(); temp.isRealLeft() ; temp = temp.getLeft() )  // temp one step to the right, and then run all the way left, till he reach a non-real son.
            ;
        return temp ;
    }

    /**
     * find the Predecessor of the node WireBST.
     * Complexity: O(lg(n)) worst case (predecessor of the root is the deepest leaf). after getting left child going down the tree
     * until there is no right son.
     * @param node is the current node, that looking for her's predecessor.
     * @return the predecessor of node.
     */
    public WireBSTNode getPredecessor(WireBSTNode node){
        if ( node == null || node.getLeft() == null )
            return null;
        if ( ! node.isRealLeft() )     // if the left son isn't real, so he is the successor!
            return node.getLeft();
        WireBSTNode temp;
        for(temp = node.getLeft(); temp.isRealRight() ; temp = temp.getRight() )  // temp go one step to the left, and then run all the way right, till he reach a non-real son.
            ;
        return temp ;
    }

    /**
     * find the minimum node WireBST
     * Complexity: O(lg(n)) worst case (minimum is deepest root)
     * the leftest node in the BST is the min node in it
     */
    public WireBSTNode minWireBST(){
        if( this.getHead() == null )
            return null;
        WireBSTNode temp = this.getHead();
        while (temp.getLeft() != null)
            temp = temp.getLeft();
        return temp;
    }

    /**
     * find the maximum node WireBST
     * Complexity: O(lg(n)) worst case (maximum is deepest root)
     * the rightest node in the BST is the max node in it
     */
    public WireBSTNode maxWireBST(){
        if( this.getHead() == null )
            return null;
        WireBSTNode temp = this.getHead();
        while (temp.getRight() != null)
            temp = temp.getRight();
        return temp;
    }

    /**
     * print the wireBST as pre oder
     * Complexity: O(n) recursively visit all the nodes in the tree. Visit each node only once and preform constant number
     * of actions.
     * @param node
     */
    public void preOrderScan(WireBSTNode node){


        if(node == null) return;

        WireBSTNode.printData(node, this);

        if (node.isRealLeft()) {
            preOrderScan(node.getLeft());
        }
        if (node.isRealRight()){
            preOrderScan(node.getRight());
        }

    }

    /**
     * print the wireBST as in order
     * We could implement this method in recursive way as we did in post and pre order, but we choose to go to the elegant way
     * without recursive, the motive was to invent the threaded tree initially.
     * Complexity: O(n). first we found the minimum which is log(n) and then visit each node twice at the worst case (the for loop take
     * you up and right in the tree, the while loop takes you down and left) - in the worst case you will go over the tree twice.
     * The time's complexity stay the same for both: the recursive and the none recursive for that function. But space's complexity in
     * the way we choose is far better (we don't need any spare in that way).
     */
    public void inOrderScan(){

        WireBSTNode temp = this.minWireBST();
        int flag = temp.getStudentNum();

        for (; temp != null; temp = temp.getRight()){
            while ( temp.isRealLeft() && temp.getLeft().getStudentNum() > flag ){
                temp = temp.getLeft();
            }
            flag = temp.getStudentNum();
            WireBSTNode.printData(temp, this);
        }
    }

    /**
     * print the wireBST as post order
     * Complexity: O(n) recursively visit all the nodes in the tree. Visit each node only once and preform constant number
     * of actions.
     * @param node
     */
    public void postOrderScan(WireBSTNode node){

        if (node == null) return;

        if (node.isRealLeft()){
            postOrderScan(node.getLeft());
        }
        if (node.isRealRight()){
            postOrderScan(node.getRight());
        }

        WireBSTNode.printData(node, this);

    }


    /**
     * Complexity: O(1)
     * @return the median WireBST
     */
    public WireBSTNode getMedianWireBST()
    {
        return _median;

    }

    /**
     * @param median is the new median to be set.
     */
    private void setMedian(WireBSTNode median) {
        this._median = median;
    }

    // Function to print binary tree in 2D
    // It does reverse inorder traversal
    // i translate it from C. credit to: https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
    public static void print2DNodeWireBST(WireBSTNode head, int space, WireBST tree)
    {
        // Base case
        if (head == null) {
            System.out.println("tree is empty.");
            return;
        }

        // Increase distance between levels
        space += Constants.COUNT;

        // Process right child first
        if (head.isRealRight()){
            print2DNodeWireBST(head.getRight() , space, tree);
        }

        // Print current node after space count
        System.out.println();    // go one line down
        for (int i = Constants.COUNT ; i < space; i++)
            System.out.print(" ");
        WireBSTNode.printData(head ,tree);

        // Process left child
        if (head.isRealLeft()){
            print2DNodeWireBST(head.getLeft(), space, tree);
        }
    }

}   // end of WireBST class
