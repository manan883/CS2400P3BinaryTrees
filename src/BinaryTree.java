public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // end setTree

   public void setRootData(T rootData)
   {
      root.setData(rootData);
   } // end setRootData
   
   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // end getRootData
   
   public boolean isEmpty()
   {
      return root == null;
   } // end isEmpty
   
   public void clear()
   {
      root = null;
   } // end clear
   
   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // end setRootNode
   
   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // end getRootNode
   
   private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);
      
      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);
      
      if ((rightTree != null) && !rightTree.isEmpty())
      {
         if (rightTree != leftTree)
            root.setRightChild(rightTree.root);
         else
            root.setRightChild(rightTree.root.copy());
      } // end if
      
      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();
      
      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   } // end initializeTree
   
   /** -------------------------------------------------------------------- */
   /** Task 1: Implement the 4 methods
    *     . In BinaryTree.java
    *          1. public void postorderTraverse();
    *          2. private void postorderTraverse(BinaryNode<T> node)
    *          3. public void postorderTraverse_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          4. public void postorderTraverse_binaryNodeMethod() */
   
   /** calls postorderTraverse(BinaryNode<T> node)
    * prints (using post-order traversal) all nodes in the "whole" tree */
   protected void postorderTraverse()
   {
	   // Calls postOrderTraverse(BinaryNode<T> node) with the root as the starting node
	   postorderTraverse(root);
   } // end postorderTraverse()
   
   /** A Recursive Method in the BinaryTree Class   
    * prints (using post-order traversal) all nodes in the subtree rooted at this node.*/
   private void postorderTraverse(BinaryNode<T> node)
   {
	   if (node != null) {
		   // Call the postorderTraverse(BinaryNode<T> node) method with the left child, if it exists
		   postorderTraverse(node.getLeftChild());
		   // Call the postorderTraverse(BinaryNode<T> node) method with the right child, if it exists
		   postorderTraverse(node.getRightChild());
		   // Print the data of the node that the recursive method is currently on
		   System.out.println(node.getData());
	   }
   } // end postorderTraverse(BinaryNode<T> node)
   
   /** Protected version of postOrderTraverse() that calls postOrderTraverseProtected(BinaryNode<T> node)
    * @return  A string that contains the postOrderTraverseProtected method's output
    */
   String result = "";
   protected String postorderTraverseProtected()
   {
	   // The same method as postorderTraverse() but it returns a string instead of being void
	   result = "";
	   if (root == null) {
		   return "";
	   }
	   return postOrderTraverseProtected(root);
   } // end postorderTraverseProtected()
   
   /** Protected version of postOrderTraverse(BinaryNode<T> node) that returns a string
    * @return  A string that contains the postOrderTraverse method's output
    */
   protected String postOrderTraverseProtected(BinaryNode<T> node) {
	   // The same method as postorderTraverse(BinaryNode<T> node) but it returns a string instead of being void
	   if (node != null) {
		   postOrderTraverseProtected(node.getLeftChild());
		   postOrderTraverseProtected(node.getRightChild());
		   result = result + (String) node.getData() + " ";
	   }
	   return result;
   } // end postOrderTraverseProtected(BinaryNode<T> node)
   
   /** The following calls postorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method   
    * prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse_callBinaryNodeMethod()
   {
	   // Calls postorderTraverse_binaryNodeMethod() with root as the starting node
	   root.postorderTraverse_binaryNodeMethod();
   } // end postorderTraverse_callBinaryNodeMethod()
   
   /** Protected version of postorderTraverse_callBinaryNodeMethod() that calls postorderTraverse_binaryNodeMethod()
    * @return  A string that contains the postorderTraverse_binaryNodeMethodProtected method's output
    */
   protected String postorderTraverse_callBinaryNodeMethodProtected()
   {
	   // If the tree is null, return an empty string
	   if (root == null) {
		   return "";
	   }
	   // The same method as postorderTraverse_callBinaryNodeMethod() but it returns a string instead of being void
	   return root.postorderTraverse_binaryNodeMethodProtected();
   } // end postorderTraverse_callBinaryNodeMethodProtected()
   
   /** -------------------------------------------------------------------- */
   /** Task 2: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getHeight_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          2. public int getHeight_binaryNodeMethod()*/
   
   /** calls getHeight(BinaryNode<T> node)
   @return  The height of the "whole" tree */
   public int getHeight()
   {
	   return getHeight(root);
   } // end getHeight()
   
   /** A Recursive Method in the BinaryTree Class  
    * Computes the height of the subtree rooted at this node.
   @return  The height of the subtree rooted at this node. */
   private int getHeight(BinaryNode<T> node)
   {
      int height = 0;
      if (node != null)
         height = 1 + Math.max(getHeight(node.getLeftChild()),
                               getHeight(node.getRightChild()));
      return height;
   } // end getHeight(BinaryNode<T> node)
   
   /** The following calls getHeight_binaryNodeMethod() which is a recursive binaryNode class method
    * Computes the height of the "whole" tree.
   @return  The height of the "whole" tree. */
   public int getHeight_callBinaryNodeMethod()
   {
	   // If the tree is null, return 0
	   if (root == null) {
		   return 0;
	   }
	   // Calls getHeight_binaryNodeMethod() with root as the starting node
	   return root.getHeight_binaryNodeMethod();
   } // end getHeight_callBinaryNodeMethod()

   /** -------------------------------------------------------------------- */
   /** Task 3: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getNumberOfNodes()
    *          2. private int getNumberOfNodes(BinaryNode<T> node)*/
   
   /** calls getNumberOfNodes(BinaryNode<T> node) 
   @return  The number of nodes in the "whole" tree */
   public int getNumberOfNodes()
   {
	   // Calls getNumberOfNodes(BinaryNode<T> node)
      return getNumberOfNodes(root);
   } // end getNumberOfNodes()
   
   /** A Recursive Method in the BinaryTree Class   
    * Counts the nodes in the subtree rooted at this node.
   @return  The number of nodes in the subtree rooted at this node. */
   private int getNumberOfNodes(BinaryNode<T> node)
   {
	   int numberOfNodes = 0;
	   if (node != null) {
		   // Calls numberOfNodes(BinaryNode<T> node) for the left and right children and keeps adding 1 until the entire tree is read
		   numberOfNodes = 1 + getNumberOfNodes(node.getLeftChild()) + getNumberOfNodes(node.getRightChild());
	   }
	return numberOfNodes;
   } // end getNumberOfNodes(BinaryNode<T> node)
   
   /** The following calls getNumberOfNodes_binaryNodeMethod() which is a recursive binaryNode class method
    * Counts the nodes in the "whole" tree
   @return  The number of nodes in the "whole" tree. */
   public int getNumberOfNodes_callBinaryNodeMethod()
   {
	   int numberOfNodes = 0;
	   if (root != null)
		   numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
	   return numberOfNodes;
   } // end getNumberOfNodes_callBinaryNodeMethod()
   
} // end BinaryTree
