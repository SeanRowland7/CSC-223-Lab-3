package utilities.math;

import ExamPractice.DoublyLinkedList.DNode;

public class LinkedList <T>
{
	private int _size;
	protected Node _head, _tail;

	private class Node
	{
		protected Node _prev;
		protected T _data;
		protected Node _next;

		public Node() {this(null, null, null);}

		public Node(Node prev, T data, Node next) {
			_prev = prev; 
			_data = data; 
			_next = next;
		}
	}

	public LinkedList(){

		_head = new Node();
		_tail = new Node(_head, null, null);

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
		Node n = new Node(_head, target, _head._next);

		Node current = _head;

		n._next._prev = current._next;

		current._next = n;
	}



}
