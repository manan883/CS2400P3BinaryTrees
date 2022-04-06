import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class BinaryTreeTest {
	BinaryTree<String> tree = new BinaryTree<>();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		//Leaves
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");
		BinaryTree<String> hTree = new BinaryTree<>("H");
		// Subtrees:
		BinaryTree<String> eTree = new BinaryTree<>("E", gTree, hTree);
		BinaryTree<String> dTree = new BinaryTree<>("D", fTree, null);
		BinaryTree<String> cTree = new BinaryTree<>("C", dTree, eTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", null, null);
		tree.setTree("A",bTree,cTree);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(originalOut);
	}

	@Test
	void traverseTree() {
		tree.postorderTraverse();
		assertEquals("B,F,D,G,H,E,C,A,",outContent.toString());
//		fail("Not yet implemented");
	}
	@Test
	void traverseBinaryNode() {
		tree.postorderTraverse_callBinaryNodeMethod();
		assertEquals("B,F,D,G,H,E,C,A,",outContent.toString());
	}
	@Test
	void heightTree() {
		assertEquals(4,tree.getHeight());
	}
	@Test
	void heightBinaryNode() {
		assertEquals(4,tree.getHeight_callBinaryNodeMethod());
	}
	@Test
	void nodeTree() {
		assertEquals(8,tree.getNumberOfNodes());
	}
	@Test
	void nodeBinaryNode() {
		assertEquals(8,tree.getNumberOfNodes_callBinaryNodeMethod());
	}

}
