import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTesting {
	
	public static void createTree1(BinaryTree<String> tree) {
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, null);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

		tree.setTree("A", bTree, cTree);

		System.out.println("\nGiven Tree:\n");
		System.out.println("     A        ");
		System.out.println("   /   \\     ");
		System.out.println("  B     C     ");
		System.out.println(" / \\   / \\  ");
		System.out.println("D   E F   G   ");
		System.out.println();
	} // end createTree
	
	public static void createTree2(BinaryTree<String> tree) {
		// Leaves
		BinaryTree<String> bTree = new BinaryTree<>("B");

		tree.setTree("A", bTree, null);

		System.out.println("\nGiven Tree:\n");
		System.out.println("     A        ");
		System.out.println("   /          ");
		System.out.println("  B           ");
		System.out.println();
	} // end createTree2
	
	public static void createTree3(BinaryTree<String> tree) {
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");

		// Subtrees:
		BinaryTree<String> cTree = new BinaryTree<>("C", dTree, null);
		BinaryTree<String> bTree = new BinaryTree<>("B", cTree, null);

		tree.setTree("A", bTree, null);

		System.out.println("\nGiven Tree:\n");
		System.out.println("      A  ");
		System.out.println("     /   ");
		System.out.println("    B    ");
		System.out.println("   /     ");
		System.out.println("  C      ");
		System.out.println(" /       ");
		System.out.println("D        ");
		System.out.println();
	} // end createTree3
	
	public static void createTree4(BinaryTree<String> tree) {
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");

		// Subtrees:
		BinaryTree<String> cTree = new BinaryTree<>("C", null, dTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", null, cTree);

		tree.setTree("A", bTree, null);

		System.out.println("\nGiven Tree:\n");
		System.out.println("A           ");
		System.out.println(" \\         ");
		System.out.println("  B         ");
		System.out.println("   \\       ");
		System.out.println("    C       ");
		System.out.println("     \\     ");
		System.out.println("      D     ");
		System.out.println();
	} // end createTree4
	
	public static void createTree5(BinaryTree<String> tree) {

		tree.setTree("A", null, null);

		System.out.println("\nGiven Tree:\n");
		System.out.println("       A       ");

		System.out.println();
	} // end createTree5
	
	public static void createTree6(BinaryTree<String> tree) {
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> hTree = new BinaryTree<>("H");
		BinaryTree<String> iTree = new BinaryTree<>("I");


		// Subtrees:
		BinaryTree<String> gTree = new BinaryTree<>("G", hTree, iTree);
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);


		tree.setTree("A", bTree, cTree);

		System.out.println("\nGiven Tree:\n");
		System.out.println("     A        ");
		System.out.println("   /   \\     ");
		System.out.println("  B     C     ");
		System.out.println(" / \\   /     ");
		System.out.println("D   E  F      ");
		System.out.println("       \\     ");
		System.out.println("       	G     ");
		System.out.println("       / \\   ");
		System.out.println("      H   I   ");
		System.out.println();
	} // end createTree6
	
	@Test
	public void postorderTraverseProtectedTest() {
		
		System.out.println("");
		System.out.println("BinaryTree postorderTraverseProtectedTest #1: Full Binary Tree");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);
		System.out.println("TESTING:(BinaryTree) Postorder of tree is " + aTree.postorderTraverseProtected());
		System.out.println("TESTING:(BinaryNode) Postorder of tree is " + aTree.postorderTraverse_callBinaryNodeMethodProtected());
		System.out.println("GIVEN:                                    " + "D E B F G C A ");
		assertEquals(aTree.postorderTraverseProtected(), "D E B F G C A ");
		assertEquals(aTree.postorderTraverse_callBinaryNodeMethodProtected(), "D E B F G C A ");
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree postorderTraverseProtectedTest #2: Tree with only one leaf");
		BinaryTree<String> aTree2 = new BinaryTree<>();
		createTree2(aTree2);
		System.out.println("TESTING:(BinaryTree) Postorder of tree is " + aTree2.postorderTraverseProtected());
		System.out.println("TESTING:(BinaryNode) Postorder of tree is " + aTree2.postorderTraverse_callBinaryNodeMethodProtected());
		System.out.println("GIVEN:                                    " + "B A ");
		assertEquals(aTree2.postorderTraverseProtected(), "B A ");
		assertEquals(aTree2.postorderTraverse_callBinaryNodeMethodProtected(), "B A ");
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree postorderTraverseProtectedTest #3: Tree with only left nodes");
		BinaryTree<String> aTree3 = new BinaryTree<>();
		createTree3(aTree3);
		System.out.println("TESTING:(BinaryTree) Postorder of tree is " + aTree3.postorderTraverseProtected());
		System.out.println("TESTING:(BinaryNode) Postorder of tree is " + aTree3.postorderTraverse_callBinaryNodeMethodProtected());
		System.out.println("GIVEN:                                    " + "D C B A ");
		assertEquals(aTree3.postorderTraverseProtected(), "D C B A ");
		assertEquals(aTree3.postorderTraverse_callBinaryNodeMethodProtected(), "D C B A ");
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree postorderTraverseProtectedTest #4: Tree with only right nodes");
		BinaryTree<String> aTree4 = new BinaryTree<>();
		createTree4(aTree4);
		System.out.println("TESTING:(BinaryTree) Postorder of tree is " + aTree4.postorderTraverseProtected());
		System.out.println("TESTING:(BinaryNode) Postorder of tree is " + aTree4.postorderTraverse_callBinaryNodeMethodProtected());
		System.out.println("GIVEN:                                    " + "D C B A ");
		assertEquals(aTree4.postorderTraverseProtected(), "D C B A ");
		assertEquals(aTree4.postorderTraverse_callBinaryNodeMethodProtected(), "D C B A ");
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree postorderTraverseProtectedTest #5: Tree with no leaves");
		BinaryTree<String> aTree5 = new BinaryTree<>();
		createTree5(aTree5);
		System.out.println("TESTING:(BinaryTree) Postorder of tree is " + aTree5.postorderTraverseProtected());
		System.out.println("TESTING:(BinaryNode) Postorder of tree is " + aTree5.postorderTraverse_callBinaryNodeMethodProtected());
		System.out.println("GIVEN:                                    " + "A ");
		assertEquals(aTree5.postorderTraverseProtected(), "A ");
		assertEquals(aTree5.postorderTraverse_callBinaryNodeMethodProtected(), "A ");
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree postorderTraverseProtectedTest #6: Tree with different lengths on the right and left");
		BinaryTree<String> aTree6 = new BinaryTree<>();
		createTree6(aTree6);
		System.out.println("TESTING:(BinaryTree) Postorder of tree is " + aTree6.postorderTraverseProtected());
		System.out.println("TESTING:(BinaryNode) Postorder of tree is " + aTree6.postorderTraverse_callBinaryNodeMethodProtected());
		System.out.println("GIVEN:                                    " + "D E B H I G F C A ");
		assertEquals(aTree6.postorderTraverseProtected(), "D E B H I G F C A ");
		assertEquals(aTree6.postorderTraverse_callBinaryNodeMethodProtected(), "D E B H I G F C A ");
		System.out.println("");	
		
		System.out.println("");
		System.out.println("BinaryTree postorderTraverseProtectedTest #7: No tree");
		BinaryTree<String> aTree7 = new BinaryTree<>();
		System.out.println("TESTING:(BinaryTree) Postorder of tree is " + aTree7.postorderTraverseProtected());
		System.out.println("TESTING:(BinaryNode) Postorder of tree is " + aTree7.postorderTraverse_callBinaryNodeMethodProtected());
		System.out.println("GIVEN:                                    " + "");
		assertEquals(aTree7.postorderTraverseProtected(), "");
		assertEquals(aTree7.postorderTraverse_callBinaryNodeMethodProtected(), "");
		System.out.println("");	
	} // end postOrderTraverseProtectedTest
	
	@Test
	public void getHeight_callBinaryNodeMethodTest() {
		
		System.out.println("");
		System.out.println("BinaryNode getHeight_callBinaryNodeMethodTest #1: Full Binary Tree");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);
		System.out.println("GIVEN:  (BinaryTree) Height of tree is " + aTree.getHeight());
		System.out.println("TESTING:(BinaryNode) Height of tree is " + aTree.getHeight_callBinaryNodeMethod());
		assertEquals(aTree.getHeight(), aTree.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryNode getHeight_callBinaryNodeMethodTest #2: Tree with only one leaf");
		BinaryTree<String> aTree2 = new BinaryTree<>();
		createTree2(aTree2);
		System.out.println("GIVEN:  (BinaryTree) Height of tree is " + aTree2.getHeight());
		System.out.println("TESTING:(BinaryNode) Height of tree is " + aTree2.getHeight_callBinaryNodeMethod());
		assertEquals(aTree2.getHeight(), aTree2.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryNode getHeight_callBinaryNodeMethodTest #3: Tree with only left nodes");
		BinaryTree<String> aTree3 = new BinaryTree<>();
		createTree3(aTree3);
		System.out.println("GIVEN:  (BinaryTree) Height of tree is " + aTree3.getHeight());
		System.out.println("TESTING:(BinaryNode) Height of tree is " + aTree3.getHeight_callBinaryNodeMethod());
		assertEquals(aTree3.getHeight(), aTree3.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryNode getHeight_callBinaryNodeMethodTest #4: Tree with only right nodes");
		BinaryTree<String> aTree4 = new BinaryTree<>();
		createTree4(aTree4);
		System.out.println("GIVEN:  (BinaryTree) Height of tree is " + aTree4.getHeight());
		System.out.println("TESTING:(BinaryNode) Height of tree is " + aTree4.getHeight_callBinaryNodeMethod());
		assertEquals(aTree4.getHeight(), aTree4.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryNode getHeight_callBinaryNodeMethodTest #5: Tree with no leaves");
		BinaryTree<String> aTree5 = new BinaryTree<>();
		createTree5(aTree5);
		System.out.println("GIVEN:  (BinaryTree) Height of tree is " + aTree5.getHeight());
		System.out.println("TESTING:(BinaryNode) Height of tree is " + aTree5.getHeight_callBinaryNodeMethod());
		assertEquals(aTree5.getHeight(), aTree5.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryNode getHeight_callBinaryNodeMethodTest #6: Tree with different lengths on the right and left");
		BinaryTree<String> aTree6 = new BinaryTree<>();
		createTree6(aTree6);
		System.out.println("GIVEN:  (BinaryTree) Height of tree is " + aTree6.getHeight());
		System.out.println("TESTING:(BinaryNode) Height of tree is " + aTree6.getHeight_callBinaryNodeMethod());
		assertEquals(aTree6.getHeight(), aTree6.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryNode getHeight_callBinaryNodeMethodTest #7: No tree");
		BinaryTree<String> aTree7 = new BinaryTree<>();
		System.out.println("GIVEN:  (BinaryTree) Height of tree is " + aTree7.getHeight());
		System.out.println("TESTING:(BinaryNode) Height of tree is " + aTree7.getHeight_callBinaryNodeMethod());
		assertEquals(aTree7.getHeight(), aTree7.getHeight_callBinaryNodeMethod());
		System.out.println("");
	} // end getHeight_callBinaryNodeMethodTest
	
	@Test
	public void getNumberOfNodesTest() {
		
		System.out.println("");
		System.out.println("BinaryTree getNumberOfNodesTest #1: Full Binary Tree");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);
		System.out.println("TESTING: (BinaryTree) Number of nodes in the tree are " + aTree.getNumberOfNodes());
		System.out.println("GIVEN:   (BinaryNode) Number of nodes in the tree are " + aTree.getNumberOfNodes_callBinaryNodeMethod());
		assertEquals(aTree.getHeight(), aTree.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree getNumberOfNodesTest #2: Full Binary Tree");
		BinaryTree<String> aTree2 = new BinaryTree<>();
		createTree2(aTree2);
		System.out.println("TESTING: (BinaryTree) Number of nodes in the tree are " + aTree2.getNumberOfNodes());
		System.out.println("GIVEN:   (BinaryNode) Number of nodes in the tree are " + aTree2.getNumberOfNodes_callBinaryNodeMethod());
		assertEquals(aTree2.getHeight(), aTree2.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree getNumberOfNodesTest #3: Tree with only left nodes");
		BinaryTree<String> aTree3 = new BinaryTree<>();
		createTree3(aTree3);
		System.out.println("TESTING: (BinaryTree) Number of nodes in the tree are " + aTree3.getNumberOfNodes());
		System.out.println("GIVEN:   (BinaryNode) Number of nodes in the tree are " + aTree3.getNumberOfNodes_callBinaryNodeMethod());
		assertEquals(aTree3.getHeight(), aTree3.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree getNumberOfNodesTest #4: Tree with only right nodes");
		BinaryTree<String> aTree4 = new BinaryTree<>();
		createTree4(aTree4);
		System.out.println("TESTING: (BinaryTree) Number of nodes in the tree are " + aTree4.getNumberOfNodes());
		System.out.println("GIVEN:   (BinaryNode) Number of nodes in the tree are " + aTree4.getNumberOfNodes_callBinaryNodeMethod());
		assertEquals(aTree4.getHeight(), aTree4.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree getNumberOfNodesTest #5: Tree with no leaves");
		BinaryTree<String> aTree5 = new BinaryTree<>();
		createTree5(aTree5);
		System.out.println("TESTING: (BinaryTree) Number of nodes in the tree are " + aTree5.getNumberOfNodes());
		System.out.println("GIVEN:   (BinaryNode) Number of nodes in the tree are " + aTree5.getNumberOfNodes_callBinaryNodeMethod());
		assertEquals(aTree5.getHeight(), aTree5.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree getNumberOfNodesTest #6: Tree with different lengths on the right and left");
		BinaryTree<String> aTree6 = new BinaryTree<>();
		createTree6(aTree6);
		System.out.println("TESTING: (BinaryTree) Number of nodes in the tree are " + aTree6.getNumberOfNodes());
		System.out.println("GIVEN:   (BinaryNode) Number of nodes in the tree are " + aTree6.getNumberOfNodes_callBinaryNodeMethod());
		assertEquals(aTree6.getHeight(), aTree6.getHeight_callBinaryNodeMethod());
		System.out.println("");
		
		System.out.println("");
		System.out.println("BinaryTree getNumberOfNodesTest #7: No tree");
		BinaryTree<String> aTree7 = new BinaryTree<>();
		System.out.println("TESTING: (BinaryTree) Number of nodes in the tree are " + aTree7.getNumberOfNodes());
		System.out.println("GIVEN:   (BinaryNode) Number of nodes in the tree are " + aTree7.getNumberOfNodes_callBinaryNodeMethod());
		assertEquals(aTree7.getHeight(), aTree7.getHeight_callBinaryNodeMethod());
		System.out.println("");
	} // end getNumberOfNodesTest
	

}
