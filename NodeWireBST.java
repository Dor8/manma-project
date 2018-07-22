
// this class holds the data structure of a node in a wire binary search tree

// import java.util.*;
// import java.lang.*;


public class NodeWireBST{

    private int _studentNum;
    private String _name;
    private NodeWireBST _left;
    private NodeWireBST _right;
    private NodeWireBST _parent;


    // build a node in the WBST(= wire binary search tree)
    public NodeWireBST(int studentNum , String name )
    {
        _studentNum = studentNum ;
        _name = name ;
        _left = null ;
        _right = null ;
        _parent = null ;
    }


    // getters and setters for all the pointers of the node
    public NodeWireBST getLeft( )
    {
        return _left;
    }

    public NodeWireBST getRight()
    {
        return _right;
    }

    public NodeWireBST getParent( )
    {
        return _parent;
    }

    public void setLeft( NodeWireBST left )
    {
        _left = left;
    }

    public void setRight( NodeWireBST right)
    {
        _right = right;
    }

    public void setParent( NodeWireBST parent)
    {
        _parent = parent;
    }
    // end of getters and setters for all the pointers of the node

    // getters and setters values of the node: studentNum, name
    public int getStudentNum()
    {
        return _studentNum;
    }

    public void setStudentNum(int studentNum)
    {
        _studentNum = studentNum;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }
    // end of values getters and setters



    // Function to print binary tree in 2D
    // It does reverse inorder traversal
    // i translate it from C. cradit to: https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
    public static void print2DNodeWireBST(NodeWireBST head, int space)
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






}