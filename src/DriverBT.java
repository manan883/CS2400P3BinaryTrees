public class DriverBT {
	public static void main(String[] args) {
		System.out.println("1st Testing Example:");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);

		System.out.println("(binaryTree) post-order: ");
		aTree.postorderTraverse();

		System.out.println("(binaryNode) post-order: ");
		aTree.postorderTraverse_callBinaryNodeMethod();

		System.out.println();

		System.out.println("(BinaryTree) Height of tree is " + aTree.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree.getHeight_callBinaryNodeMethod());

		System.out.println();

		System.out.println("(BinaryTree) # nodes of tree is " + aTree.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree.getNumberOfNodes_callBinaryNodeMethod());

		
		System.out.println("==========================================");
		System.out.println();
		  
		System.out.println("2nd Testing Example:"); BinaryTree<String> aTree2 = new
		BinaryTree<>(); createTree2(aTree2);
		  
		System.out.println("(binaryTree) post-order: "); aTree2.postorderTraverse();
		  
		System.out.println("(binaryNode) post-order: ");
		aTree2.postorderTraverse_callBinaryNodeMethod();
		  
		System.out.println();
		  
		System.out.println("(BinaryTree) Height of tree is " + aTree2.getHeight());
		System.out.println("(BinaryNode) Height of tree is " +
		aTree2.getHeight_callBinaryNodeMethod());
		  
		System.out.println();
		  
		System.out.println("(BinaryTree) # nodes of tree is " +
		aTree2.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " +
		aTree2.getNumberOfNodes_callBinaryNodeMethod());
		 
		System.out.println("Done.");
	} // end main

	public static void createTree1(BinaryTree<String> tree) {
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);

		System.out.println("\nGiven Tree:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\  ");
		System.out.println("  B     C  ");
		System.out.println(" / \\   /  ");
		System.out.println("D   E  F   ");
		System.out.println("        \\ ");
		System.out.println("         G ");
		System.out.println();
	} // end createTree

	/** -------------------------------------------------------------------- */
	/** Task 4: Create a tree case as shown in assignment 3 */
	public static void createTree2(BinaryTree<String> tree) {
		// Leaves
		BinaryTree<String> jTree2 = new BinaryTree<>("J");
		BinaryTree<String> hTree2 = new BinaryTree<>("H");
		BinaryTree<String> fTree2 = new BinaryTree<>("F");

		// Subtrees:
		BinaryTree<String> iTree2 = new BinaryTree<>("I", jTree2, null);
		BinaryTree<String> gTree2 = new BinaryTree<>("G", null, iTree2);
		BinaryTree<String> dTree2 = new BinaryTree<>("D", gTree2, null);
		BinaryTree<String> bTree2 = new BinaryTree<>("B", null, dTree2);
		BinaryTree<String> eTree2 = new BinaryTree<>("E", null, hTree2);
		BinaryTree<String> cTree2 = new BinaryTree<>("C", eTree2, fTree2);

		tree.setTree("A", bTree2, cTree2);

		System.out.println("\nGiven Tree:\n");
		System.out.println("      A      ");
		System.out.println("   /    \\   ");
		System.out.println("  B      C   ");
		System.out.println("   \\   / \\ ");
		System.out.println("    D  E   F ");
		System.out.println("   /   \\    ");
		System.out.println("  G     H    ");
		System.out.println("  \\         ");
		System.out.println("   I         ");
		System.out.println("  /          ");
		System.out.println(" J           ");


	} // end createTree2

} // end DriverBT
