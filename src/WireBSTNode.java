
// this class holds the data structure of a node in a wire binary search tree

// import java.util.*;
// import java.lang.*;


public class WireBSTNode {

    private int _studentNum;
    private String _studentName;
    private WireBSTNode _left;
    private WireBSTNode _right;
    private WireBSTNode _parent;


    // build a node in the WBST(= wire binary search tree)
    public WireBSTNode(int studentNum , String studentName )
    {
        _studentNum = studentNum ;
        _studentName = studentName ;
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

    // getters and setters values of the node: studentNum, studentName
    public int getStudentNum()
    {
        return _studentNum;
    }

    public void setStudentNum(int studentNum)
    {
        _studentNum = studentNum;
    }

    public String getStudentName()
    {
        return _studentName;
    }

    public void setStudentName(String studentName)
    {
        _studentName = studentName ;
    }
    // end of values getters and setters

    /**
     * complexity: i preform constance number of actions (4), so its O(1).
     * @return true for nodes that have right son, and false for nodes that point on their successor in their right son (or null).
     */
    public boolean isRealRight ()
    {
        if (this == null || this.getRight() == null) {
            return false;
        }
        return (this.getRight().getParent().equal(this) : true ? false );
    }


    /**
     * complexity: i preform constance number of actions (4), so its O(1).
     * @return true for nodes that have left son, and false for nodes that point on their predecessor in their left son (or null).
     */
    public boolean isRealLeft ()
    {
        if (this == null || this.getLeft() == null){
            return false;
        }
        return (this.getLeft().getParent().equal(this) : true ? false );
    }


    /**
     * equals between two nodes means that they have the same StudentNum.
     * complexity: i preform constance number of actions (2), so its O(1).
     * @param node check for equality
     * @return true if node is equal to this node.
     */
    public boolean equal(WireBSTNode node){
        return (this.getStudentNum() == node.getStudentNum() : true ? false);
    }










}
