# manma-project

<h3>
We, Dor Dahan and Rea Haas had builded a fine wired BST!
</h3>
We choose to implement it in a way that its will consume the least memory that we can, 
and still have all the methods in the required efficiency.


To run the program just put all the files in one directory, and run it we used intellij to do that. 
Then you can choose what action to preform. For help, just type help.


At last, but first we will answer here to the first question in the project:

<h4>
Question: How can you detect if a son is real or wired? 
</h4>
<h4>
Answer:
</h4>
The easiest way to handle that is to add two Boolean fields to every node: isRealRight, isRealLeft, that indicates about the identity of the son: true for real son, and false for wired son.
The problem with that approach, is that it consumes and wastes a lots of space in the memory, which we want to avoid.
A better way to do that, is to fallow the logic of: 
"If the father of my son is me, then this son is a real son of mine, else it’s a wire son, that point to my successor/predecessor".
We have some edge cases in this method: the min node, the max node, and the predecessor and successor of the root (parent of root is null), which we have handled all of them in our functions: isRealRight(), isRealLeft().

Complexity: each time one of the "isReal..." functions is called, a constance number of actions is executed. we want to show that the complecity is O(1):
The actions are (we will show the version of the right side, Without loss of generality):
1. Check is my right son is null. (if so, return false).
2. Get my right son.
3. Check if the father of my right son is null. (if so, return false)
4. Check if the data in me, and the data in the father of my real son is the same. In assumption all students are unique as required. (if so, return true, else, return false)

The number of actions is not depending on the number of nodes in the tree, we execute 4 actions. 
So the complexity is O(1).





