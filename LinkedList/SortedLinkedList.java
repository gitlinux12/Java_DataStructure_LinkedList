package LinkedList;

public class SortedLinkedList <Type extends Comparable<Type>> extends LinkedList<Type> {
	public final static String ASCENDING = "ASC";
	
	public String order;
	
	SortedLinkedList(String order) {
		super();
		this.order = order;
	}
	
	
	public void add(Type item) {
		sortedAdd(item);
	}
	
	
	public void append(Type item) {
		sortedAdd(item);
	}

	
	public void insert(int position, Type item) {
		sortedAdd(item);
	}
	public void sortedAdd(Type item) {
		// create new node with item
		Node<Type> newNode = new Node<Type>(item);
		// linked list is empty then head and tail both will point to new node
		if(isEmpty()) {
			head = tail = newNode;
			return;
		}
		if(order.equals(ASCENDING)) {
			// if item found to be add to 0th index node
			if(head.item.compareTo(item) > 0) {
				newNode.next = head;
				head = newNode;
				return;
			}
			// item not have to add at 0th index
			Node<Type> currentNode = head; // take current node for traverse
			while(currentNode.next != null) {
				// check for position to add item
				if(currentNode.next.item.compareTo(item) > 0) {
					newNode.next = currentNode.next;
					currentNode.next = newNode;
					return;
				}
				currentNode = currentNode.next;
			}
		} 
		// add item to ending of linked list
		tail.next = newNode;
		tail = newNode;
	}

}
