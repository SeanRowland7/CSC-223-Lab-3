package input.components.segment;

import input.components.point.PointNode;

/**
* The A SegmentNode provides a way to represent ONE segment
*
* <p>Bugs: None
*
* @author Sean Rowland, Khushi Patel, Julia Hogg
* @date 01/27/2023
*/
public class SegmentNode
{
	
	protected PointNode _point1;
	protected PointNode _point2;
	
	public PointNode getPoint1() { return _point1; }
	public PointNode getPoint2() { return _point2; }
	
	public SegmentNode(PointNode pt1, PointNode pt2)
	{
		_point1 = pt1;
		_point2 = pt2;
	}

	/**
	 *	Returns true if another SegmentNode is the essentially the same as this SegmentNode.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		
		if(!(obj instanceof SegmentNode)) return false;
		
		SegmentNode that = (SegmentNode)obj;
		
		if(_point1.equals(that.getPoint1()) && _point2.equals(that.getPoint2())) return true;
		
		if(_point1.equals(that.getPoint2()) && _point2.equals(that.getPoint1())) return true;
			
		return false;
	}


	/**
	 *	Returns a String representing this SegmentNode.
	 */
	@Override
	public String toString()
	{
		return _point1.toString() + " " + _point2.toString() + "\n";
	}
}

