package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNodeDatabaseTest 
{

	@Test
	void testPut() 
	{
		PointNodeDatabase db = new PointNodeDatabase();
		PointNode p1 = new PointNode(2, 2);
		db.put(p1);
		db.put(new PointNode(1, 1));
		assertTrue(db.contains(p1));
		assertTrue(db.contains(1, 1));
	}
	
	@Test
	void testContainsNode() 
	{
		PointNodeDatabase db = new PointNodeDatabase();
		PointNode p1 = new PointNode(2, 2);
		db.put(p1);
		assertTrue(db.contains(p1));
	}
	
	@Test
	void testContainsXY() 
	{
		PointNodeDatabase db = new PointNodeDatabase();
		PointNode p1 = new PointNode(2, 2);
		db.put(p1);
		db.put(new PointNode(1, 1));
		assertTrue(db.contains(2, 2));
		assertTrue(db.contains(1, 1));
	}
	
	
	@Test
	void testGetNameNode() 
	{
		PointNodeDatabase db = new PointNodeDatabase();
		PointNode p1 = new PointNode("A", 2, 2);
		db.put(p1);
		assertEquals("A", db.getName(p1));
	}
	
	@Test
	void testGetNameXY() 
	{
		PointNodeDatabase db = new PointNodeDatabase();
		db.put(new PointNode("A", 2, 2));
		assertEquals("A", db.getName(2, 2));
	}
	
	@Test
	void testGetPointNode() 
	{
		PointNodeDatabase db = new PointNodeDatabase();
		PointNode p1 = new PointNode(2, 2);
		db.put(p1);
		assertEquals(p1, db.getPoint(p1));
	}
	
	@Test
	void testGetPointXY() 
	{
		PointNodeDatabase db = new PointNodeDatabase();
		PointNode p1 = new PointNode(2, 2);
		db.put(p1);
		assertEquals(p1, db.getPoint(2, 2));
	}
}
