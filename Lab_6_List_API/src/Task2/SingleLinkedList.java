package Task2;


public class SingleLinkedList<E> {

	private Node<E> headNode = null;
	private Node<E> tailNode = null;
	private int size;

	public SingleLinkedList() {
		this.headNode = null;
		this.tailNode = null;
		this.size = 0;

	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false
	// otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in
	// the list.
	public E first() {
		return headNode.getData();
	}

	// Returns (but does not remove) the last element in
	// the list.
	public E last() {
		return tailNode.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		if (size == 0) {
			headNode = newNode;
			tailNode = newNode;
		} else {
			newNode.setNext(headNode);
			headNode = newNode;
		}
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (size == 0) {
			headNode = newNode;
			tailNode = newNode;
		} else {
			tailNode.setNext(newNode);
			tailNode = newNode;
		}
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		} else {
			Node<E> removed = headNode;
			headNode = headNode.getNext();

			size--;
			return removed.getData();
		}

	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		Node<E> removedNode ;
		if (headNode == tailNode) {
			removedNode = headNode;
	        headNode = null;
	        tailNode = null;
	    } else {
	     
	        Node<E> current = headNode;
	        while (current.getNext() != tailNode) {
	            current = current.getNext();
	        }
	        removedNode = tailNode;
	        current.setNext(null);
	        tailNode = current;
	    }
	    
	    size--;
	    return removedNode.getData();
	}
	public void display() {
		if (headNode == null) {
			System.out.println("list is empty");
		} else {
			Node<E> temp = headNode;
			while (temp != null) {
				System.out.print(temp.getData());
				temp = temp.getNext();
				if (temp != null) {
					System.out.print("->");
				} else {
					System.out.println();
				}
			}
		}
	}
}
