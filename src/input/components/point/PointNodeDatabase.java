package input.components.point;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
* The PointNodeDatabase class provides a way to store unique 2D PointNodes.
*
* <p>Bugs: None
*
* @author Sean Rowland, Khushi Patel, Julia Hogg
* @date 01/27/2023
*/
public class PointNodeDatabase 
{

	protected Set <PointNode> _points;

	public PointNodeDatabase(){ _points = new LinkedHashSet<PointNode>(); }
	
	public PointNodeDatabase(List<PointNode> list) { _points = new LinkedHashSet<PointNode>(list); }
	
	
	/**
	 *	Add a given PointNode to the database if it is not already in the set.
	 */
	public void put(PointNode node)
	{
		_points.add(node);
	}
	
	/**
	 *	Check if the database contains a given PointNode.
	 */
	public boolean contains(PointNode node)
	{
		return _points.contains(node);
	}
	
	/**
	 *	Check if the database contains a given (x, y) pair.
	 */
	public boolean contains(double x, double y)
	{
		return _points.contains(new PointNode(x, y));
	}
	
	/**
	 *	Get the name of a given PointNode in the database
	 */
	// doesntn get name in database
	public String getName(PointNode node)
	{
		if(!contains(node)) return null;
		
		return node.getName();
	}
	
	/**
	 *	Get the name of a given (x, y) pair in the database.
	 */
	public String getName(double x, double y)
	{
		for(PointNode point: _points)
		{
			if(point.equals(new PointNode(x, y))) return point.getName();
		}
		
		return null;
	}
	
	/**
	 *	Get the matching PointNode from the database.
	 */
	public PointNode getPoint(PointNode node)
	{
		for(PointNode point: _points)
		{
			if(point.equals(node)) return point;
		}
		
		return null;
	}
	

	/**
	 *	Get a PointNode from the database given its (x, y) pair.
	 */
	//Redundant
	public PointNode getPoint(double x, double y)
	{
		for(PointNode point: _points)
		{
			if(point.equals(new PointNode(x, y))) return point;
		}
		
		return null;
	}
}
