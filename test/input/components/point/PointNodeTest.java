package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNodeTest 
{

	@Test
	void testPointNodeXY() 
	{
		assertEquals("__UNNAMED(1.0, 1.0)", new PointNode(1.0, 1.0).toString());
	}
	
	@Test
	void testPointNodeNameXY() 
	{
		assertEquals("A(-3.4, 1.9)", new PointNode("A", -3.4, 1.9).toString());
	}
	
	@Test
	void testEqualsBadInput()
	{
		assertFalse(new PointNode(1.0, 1.0).equals(null));
		assertFalse(new PointNode(1.0, 1.0).equals(":("));
	}

	@Test
	void testEqualsIntegers()
	{
		assertTrue(new PointNode(1, 1).equals(new PointNode(1, 1)));
		assertTrue(new PointNode(3, -5).equals(new PointNode(3, -5)));
		assertFalse(new PointNode(-5, 3).equals(new PointNode(3, -5)));
		assertFalse(new PointNode(-5, -5).equals(new PointNode(3, 3)));
	}
	
	@Test
	void testEqualsDoublesBarelyOff()
	{
		assertTrue(new PointNode(1.0000000001, 1).equals(new PointNode(1, 1)));
		assertTrue(new PointNode(3.1415926, -12).equals(new PointNode(3.14159265, -12.0)));
	}
	
	@Test
	void testEqualsDoublesOffBySignificant()
	{
		assertFalse(new PointNode(1.001, 1).equals(new PointNode(1, 1)));
		assertFalse(new PointNode(3.1415926, -12).equals(new PointNode(3.14, -12.0)));
	}
	
	@Test
	void testToString() 
	{
		assertEquals("__UNNAMED(1.0, 1.0)", new PointNode(1.0, 1.0).toString());
		assertEquals("A(-3.4, 1.9)", new PointNode("A", -3.4, 1.9).toString());
	}
}
