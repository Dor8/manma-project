
// this class holds the data structure of a node in a wire binary search tree

// import java.util.*;
// import java.lang.*;


public class WireBSTNode extends WireBST {

    private int _studentNum;
    private String _name;
    private WireBSTNode _left;
    private WireBSTNode _right;
    private WireBSTNode _parent;


    // build a node in the WBST(= wire binary search tree)
    public WireBSTNode(int studentNum , String name )
    {
        _studentNum = studentNum ;
        _name = name ;
        _left = null ;
        _right = null ;
        _parent = null ;
    }


    // getters and setters for all the pointers of the node
    public WireBSTNode getLeft( )
    {
        return _left;
    }

    public WireBSTNode getRight()
    {
        return _right;
    }

    public WireBSTNode getParent( )
    {
        return _parent;
    }

    public void setLeft( WireBSTNode left )
    {
        _left = left;
    }

    public void setRight( WireBSTNode right)
    {
        _right = right;
    }

    public void setParent( WireBSTNode parent)
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









}