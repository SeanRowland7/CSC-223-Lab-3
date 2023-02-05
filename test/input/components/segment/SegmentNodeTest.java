package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeTest
{

	@Test
	void testSegmentNode()
	{
		assertEquals("A(1.0, 2.0) B(3.0, 4.0)\n", new SegmentNode(new PointNode("A", 1.0, 2.0), new PointNode("B", 3.0, 4.0)).toString());
	}

	@Test
	void testEqualsBadInput()
	{
		assertFalse(new SegmentNode(new PointNode("A", 1.0, 2.0), new PointNode("B", 3.0, 4.0)).equals(null));
	}

	@Test
	void testEqualsIntegers()
	{
		SegmentNode n1 = new SegmentNode(new PointNode("A", 1.0, 2.0), new PointNode("B", 3.0, 4.0));
		SegmentNode n2 = new SegmentNode(new PointNode("A", 1.0, 2.0), new PointNode("B", 3.0, 4.0));
		SegmentNode n3 = new SegmentNode(new PointNode("C", 3.0, 4.0), new PointNode("D", 1.0, 2.0));
		SegmentNode n4 = new SegmentNode(new PointNode("E", 1.0, 2.0), new PointNode("F", 4.0, 3.0));

		assertTrue(n1.equals(n2));
		assertTrue(n1.equals(n3));
		assertTrue(n3.equals(n2));
		assertFalse(n1.equals(n4));
		assertFalse(n3.equals(n4));
	}

	@Test
	void testEqualsDoublesBarelyOff()
	{
		SegmentNode n1 = new SegmentNode(new PointNode("A", 1.0000001, 3.14159265), new PointNode("B", 1.41421356, 4));
		SegmentNode n2 = new SegmentNode(new PointNode("A", 1, 3.141592), new PointNode("B", 1.41421399, 4.00000007));

		assertTrue(n1.equals(n2));
		assertTrue(n2.equals(n1));
	}

	@Test
	void testEqualsDoublesOffBySignificant()
	{
		SegmentNode n1 = new SegmentNode(new PointNode("A", 1.0030001, 3.14159265), new PointNode("B", 1.41421356, 4));
		SegmentNode n2 = new SegmentNode(new PointNode("A", 1, 3.151592), new PointNode("B", 1.41621399, 4.04000007));

		assertFalse(n1.equals(n2));
		assertFalse(n2.equals(n1));
	}

	@Test
	void testToString()
	{
		assertEquals("A(1.0, 2.0) B(3.0, 4.0)\n", new SegmentNode(new PointNode("A", 1.0, 2.0), new PointNode("B", 3.0, 4.0)).toString());
	}
}