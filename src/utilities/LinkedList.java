
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

//	public void addToFront(T target)
//	{
//		Node n = new Node(target, _head._next);
//
//		Node current = _head;
//
//		n._next = _head._next;
//
//		current._next = n;
//		
//		_size++;
//	}
//	
	public void addToFront(T target) {
		
		insert(target, _head);
		
	}
	
	public void addToBack(T target) {
		
		insert(target, this.previous(_tail));
		
	}
	
	private void insert(T target, Node n) {
		
		Node node = new Node(target, n._next);
		
		n._next = node;
		
		_size++;
		
	}
	

	
	
	
	



}
