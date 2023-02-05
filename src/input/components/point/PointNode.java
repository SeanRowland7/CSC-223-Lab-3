package input.components.point;

import utilities.math.MathUtilities;

/**
* The PointNode class provides a 2D point that has a name, x coordinate, and y coordinate.
*
* <p>Bugs: None
*
* @author Sean Rowland, Khushi Patel, Julia Hogg
* @date 01/27/2023
*/

public class PointNode
{

	protected static final String ANONYMOUS = "__UNNAMED";

	protected double _x;
	public double getX() { return this._x; }

	protected double _y; 
	public double getY() { return this._y; }

	protected String _name; 
	public String getName() { return _name; }

	/**
	 * Create a new Point with the specified coordinates.
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public PointNode(double x, double y)
	{
		_x = x;
		_y = y;
		_name = ANONYMOUS;
	}

	/**
	 * Create a new Point with the specified coordinates.
	 * @param name -- The name of the point. (Assigned by the UI)
	 * @param x -- The X coordinate
	 * @param y -- The Y coordinate
	 */
	public PointNode(String name, double x, double y)
	{
		_x = x;
		_y = y;
		_name = name;
	}

	/**
	 *	Returns an integer whose value represents the hash value of the coordinate.
	 */
	@Override
	public int hashCode()
	{
		return Double.valueOf(_x).hashCode() + Double.valueOf(_y).hashCode();
	}

	/**
	 *	Returns true if another PointNode is the essentially the same as this PointNode.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) return false;
		if (!( obj instanceof PointNode)) return false;
		
		PointNode that = (PointNode) obj;
		
		return MathUtilities.doubleEquals(_x, that.getX()) && MathUtilities.doubleEquals(_y, that.getY());
	}

	/**
	 *	Returns a String representing the PointNode.
	 */
    @Override
    public String toString()
    {
		return _name + "(" + _x + ", " + _y + ")";
	}
}