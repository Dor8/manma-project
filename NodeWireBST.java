
// this class holds the data structor of a node in a wire binary search tree

import java.util.*;


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

    public NodeWireBST getRight( )
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
        return _studentNum;
    }

    public void setName(String name)
    {
        _name = name;
    }
    // end of values getters and setters







}