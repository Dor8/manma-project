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

    // find the minimum node WireBST
    public WireBSTNode minWireBST(WireBSTNode node){
        if(node == null)
            return null;
        if (node.getLeft() == null)
            return node;
        else
            return minWireBST(node.getLeft());
    }

    // find the maximum node WireBST
    public void maxWireBST(WireBSTNode node){


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

    public void print2DWireBST(){
        WireBSTNode.print2DNodeWireBST(getHead(), 0 );
    }


    public void sayHello(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }
}