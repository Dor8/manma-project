
// this class holds the data structure of a node in a wire binary search tree

// import java.util.*;
// import java.lang.*;


public class WireBSTNode {

    private int _studentNum;
    private String _studentname;
    private WireBSTNode _left;
    private WireBSTNode _right;
    private WireBSTNode _parent;


    // build a node in the WBST(= wire binary search tree)
    public WireBSTNode(int studentNum , String studentname )
    {
        _studentNum = studentNum ;
        _studentname = studentname ;
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
    public void getStudentNum()
    {
        return _studentNum;
    }

    public void setStudentNum(int studentNum)
    {
        _studentNum = studentNum;
    }

    public String getStudentName()
    {
        return _studentname;
    }

    public void setStudentName(String studentname)
    {
        _studentname = studentname ;
    }
    // end of values getters and setters

    /**
     *
     * @return true for nodes that have right son, and false for nodes that poit on thier successor in thier right son (or null).
     */
    public boolean isRealRight ()
    {
        if (this == null)
            return false;
        if (this.getRight() == null)
            return false;
        if (this.getRight().getParent().equal(this) )
            return true;
        else
            return false;
    }


    /**
     *
     * @return true for nodes that have left son, and false for nodes that poit on thier predecessor in thier left son (or null).
     */
    public boolean isRealLeft ()
    {
        if (this == null)
            return false;
        if (this.getLeft() == null)
            return false;
        if (this.getLeft().getParent().equal(this) )
            return true;
        else
            return false;
    }


    /**
     * equals between two nodes means that they have the same StudentNum.
     * @param node check for equality
     * @return true if node is equal to this node.
     */
    public boolean equal(WireBSTNode node){
        if (this.getStudentNum() == node.getStudentNum())
            return true;
        else
            return false;
    }










}