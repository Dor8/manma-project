// this file contain all the constants in the package and use as an interface to all the other file in the project.
 public class Constants {
     public static final int ZERO = 0;
    public static final int COUNT = 10;

    public static final String ERROR_INSERT = "cant insert this student. number already exists.";
    public static final String ERROR_NULL = "node not found. this node is null.";
    public static final String ERROR_REMOVE = "node not found, so it didn't removed.";
    public static final String ERROR_FILE_NAME_IS_REQUIRED = "file name is required";
    public static final String ERROR_READ_FILE = "cant read the file. make sure you insert the full path of the file.";
    public static final String ERROR_FIRST_PARAM_NOT_NUMBER = "the index of the node must be integer." ;
    public static final String TREE_COUNT = "the number of nodes in the tree is: ";

    public static final String NODE_REMOVED = "node : %s has removed\n";

    public static final String PROMPT_USER = "\nplease insert one line that contain the command and parameters. for help, type help.\n>>>";
    public static final String HELP_TEXT =
            "insert a line that contain the command then the parameters. \n" +
            "the methods are:\n" +
            "help - list all the possible commands."+
            "exit - exit from the program.\n" +
            "insert <studentNum> <studentName> - insert the student.\n" +
            "remove <studentNum> - remove the student.\n" +
            "search <studentNum> - search for the student.\n" +
            "successor <studentNum> - print the successor.\n" +
            "predecessor <studentNum> - print the successor.\n" +
            "max - print the max student.\n" +
            "min - print the max student.\n" +
            "preorder || pre - print the tree as pre order.\n" +
            "inorder || in - print the tree as in order.\n" +
            "postorder || post - print the tree as post order.\n" +
            "count - count all the nodes in the tree" +
            "gui - print the tree as two dimension tree.\n" +
            "median - print the median.\n" +
            "file <fileName> - read the input from the specific file. after reading the file, the program will finish.\n"
            ;

}
