
package input.components.segment;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeDatabaseTest
{
	
    public SegmentNodeDatabase build()
    {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(d, e);
    	
    	return db;
    }

    
    public SegmentNodeDatabase build2()
    {
    	//      A___B___C                             
    	//     / \ / \ / \                                                    
    	//    D___E___F___G		
    	//  
    	PointNode a = new PointNode("A", 1, 1);
    	PointNode b = new PointNode("B", 3, 1);
    	PointNode c = new PointNode("C", 5, 1);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 2, 0);
    	PointNode f = new PointNode("F", 4, 0);
    	PointNode g = new PointNode("G", 6, 0);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(a, d);
    	db.addUndirectedEdge(a, e);
    	db.addUndirectedEdge(b, e);
    	db.addUndirectedEdge(b, f);
    	db.addUndirectedEdge(c, f);
    	db.addUndirectedEdge(c, g);
    	db.addUndirectedEdge(d, e);
    	db.addUndirectedEdge(e, f);
    	db.addUndirectedEdge(f, g);
    	
    	return db;
    }
	@Test
	void testNumUndirectedEdges()
	{
		SegmentNodeDatabase db = build();
		
		assertEquals(8, db.numUndirectedEdges());
		
		SegmentNodeDatabase db2 = build2();
		
		assertEquals(11, db2.numUndirectedEdges());
	}
	
	@Test
	void testAddUndirectedEdge()
	{
		SegmentNodeDatabase db = build();
		
		assertEquals(8, db.numUndirectedEdges());
		
		SegmentNodeDatabase db2 = build2();
		
		assertEquals(11, db2.numUndirectedEdges());
	}
	
	@Test
	void testAddAdjacencyListWithPreconstructed()
	{
		//      A                     
    	//     / \                    
    	//    B___C                      
    	//   / \ / \                      
    	//  /   X   \ 
    	// D_________E
		
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(d, e);
    	
		
		//      A       ->    	  A                     
    	//     / \      ->       / \                   
    	//    B___C     ->      B___C_____G                     
    	//   / \ / \    ->     / \ / \   /                      
    	//  /   X   \   ->    /   X   \ /
    	// D_________E  ->   D_________E
	
	
		ArrayList<PointNode> adjListG = new ArrayList<PointNode>();
		adjListG.add(c);
		adjListG.add(e);
		db.addAdjacencyList(new PointNode("G", 8, 4), adjListG);
		
		assertEquals(10, db.numUndirectedEdges());
		
	}
	
	@Test
	void testAddAdjacencyListByConstructing()
	{
		//      A                     
    	//     / \                    
    	//    B___C                      
    	//   / \ / \                      
    	//  /   X   \ 
    	// D_________E
		
		PointNode a = new PointNode("A", 3, 6);
	  	PointNode b = new PointNode("B", 2, 4);
	  	PointNode c = new PointNode("C", 4, 4);
	  	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);
    	
		ArrayList<PointNode> adjListA = new ArrayList<PointNode>();
    	ArrayList<PointNode> adjListB = new ArrayList<PointNode>();
    	ArrayList<PointNode> adjListC = new ArrayList<PointNode>();
    	ArrayList<PointNode> adjListD = new ArrayList<PointNode>();
    	ArrayList<PointNode> adjListE = new ArrayList<PointNode>();
    	ArrayList<PointNode> adjListX = new ArrayList<PointNode>();

    	adjListA.add(b);
    	adjListA.add(c);
    	adjListB.add(a);
    	adjListB.add(c);
    	adjListB.add(x);
    	adjListB.add(d);
    	adjListC.add(a);
    	adjListC.add(b);
    	adjListC.add(x);
    	adjListC.add(e);
    	adjListX.add(b);
    	adjListX.add(c);
    	adjListD.add(b);
    	adjListD.add(e);
    	adjListE.add(c);
    	adjListE.add(d);
    	
    	SegmentNodeDatabase db = new SegmentNodeDatabase();
  
		db.addAdjacencyList(a, adjListA);
		db.addAdjacencyList(b, adjListB);
		db.addAdjacencyList(c, adjListC);
		db.addAdjacencyList(d, adjListD);
		db.addAdjacencyList(e, adjListE);
		db.addAdjacencyList(x, adjListX);
		
		assertEquals(8, db.numUndirectedEdges());
		
	}
	
	@Test
	void testAsSegmentList()
	{
		//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(d, e);
    	
    	
		ArrayList<SegmentNode> list = new ArrayList<SegmentNode>();
		list.add(new SegmentNode(a, b));
		list.add(new SegmentNode(a, c));
		list.add(new SegmentNode(b, a));
		list.add(new SegmentNode(b, c));
		list.add(new SegmentNode(b, x));
		list.add(new SegmentNode(b, d));
		list.add(new SegmentNode(c, a));
		list.add(new SegmentNode(c, b));
		list.add(new SegmentNode(c, x));
		list.add(new SegmentNode(c, e));
		list.add(new SegmentNode(x, b));
		list.add(new SegmentNode(x, c));
		list.add(new SegmentNode(d, b));
		list.add(new SegmentNode(d, e));
		list.add(new SegmentNode(e, c));
		list.add(new SegmentNode(e, d));

		assertEquals(list, db.asSegmentList());
		
	}
	
	@Test
	void testAsUniqueSegmentList()
	{
		//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(d, e);
    	
    	
		ArrayList<SegmentNode> list = new ArrayList<SegmentNode>();
		list.add(new SegmentNode(a, b));
		list.add(new SegmentNode(a, c));
		list.add(new SegmentNode(b, c));
		list.add(new SegmentNode(b, x));
		list.add(new SegmentNode(b, d));
		list.add(new SegmentNode(c, x));
		list.add(new SegmentNode(c, e));
		list.add(new SegmentNode(d, e));

		assertEquals(list, db.asUniqueSegmentList());

	}
}
