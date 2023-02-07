
package utilities;

public class LinkedList <T>
{
	private int _size;
	protected Node _head, _tail;

	private class Node
	{
		protected T _data;
		protected Node _next;

		public Node() {this(null, null);}

		public Node(T data, Node next) {
			_data = data; 
			_next = next;
		}
	}

	public LinkedList(){

		_head = new Node();
		_tail = new Node(null, null);

		_head._next = _tail;

		_size = 0;
	}


	public boolean isEmpty()
	{
		return _head._next == _tail;
	}

	public void clear()
	{
		_head._next = _tail;
	}

	public int size()
	{
		return _size;
	}

	public void addToFront(T target)
	{
		Node n = new Node(target, _head._next);

		Node current = _head;

		n._next = current._next;

		current._next = n;

		_size++;
	}

	public boolean contains(T target)
	{
		return contains(target,_head._next);
	}

	private boolean contains(T target, Node n)
	{
		if(n._next == _tail)
		{
			return false;
		}

		if(n._next._data.equals(target))
		{
			return true;
		}

		return contains(target, n._next);
	}
	
	private Node previous(T target)
	{
		return previous(target,_head);
	}
	
	private Node previous(T target, Node n)
	{
		if(n._next == _tail)
		{
			return null;
		}
		if(n._next._data.equals(target))
		{
			return n;
		}
		
		return previous(target, n._next);
		
	}


	public String toString()
	{
		if(_head == null) {return null;}
		String result = "";
		Node n = _head;
		while (n != null)
		{
			result += String.valueOf(n._data) + "->";
			n = n._next;
		}
		return result;	
	}







}
