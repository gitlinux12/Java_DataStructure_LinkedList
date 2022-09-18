package LinkedList;

public class LinkedList  <Type extends Comparable<Type>>  {
	
		Node<Type> head; // point to first node of the linked list
		Node<Type> tail; // point to last node of the linked list
		
		
		LinkedList(){
			head = null;
			tail = null;
		}
		public void add(Type item) {
			if (isEmpty()) head = tail = new Node<Type>(item);
			else {
				Node<Type> tempNode = new Node<Type>(item);
				tempNode.next = head;				head = tempNode;
			}
		}		
		public boolean isEmpty() {
			if(head == null) return true;
			else return false;
		}
		public int size() {
			int count = 0;
			Node<Type> currentNode = head;
			// will traverse over linked list
			while(currentNode != null) {
				count++; // count nodes in linked list
				currentNode = currentNode.next;
			}
			return count;
		}

	public void append(Type item) {
			Node<Type> newNode = new Node<Type>(item);
			if (isEmpty()) head = tail = newNode;
			else {
				tail.next = newNode;
				tail = newNode;
			}
		}
	public void insert(int position, Type item) {
		Node<Type> newNode = new Node<Type>(item);
		if(position == 0) add(item);  
		else if(size() <= position) append(item); 
		else if (isEmpty()) head = tail = newNode; 
		else {
			Node<Type> currentNode = head;
			for (int i = 0; i < (position - 1); i++) currentNode = currentNode.next;
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}
	public void remove(Type item) {
		if(head.item.equals(item)) {
			if(head == tail) head = tail = null; 
			else head = head.next; 
			return;
		}
		Node<Type> currentNode = head;
		while(currentNode.next != null) {
			if(currentNode.next.item.equals(item)) {
				if(currentNode.next == tail) tail = currentNode; 
				currentNode.next = currentNode.next.next;
				return;
			}
			currentNode = currentNode.next;
		}
	}
	public Type pop() {
		Type currentHeadItem=headItem();
		if(currentHeadItem !=null) {
			remove(headItem());
			return currentHeadItem;
		}
		else return null;
	}
	public Type headItem() {
		if(isEmpty()) return null; 
		else return head.item; 
	}
	
	public String toString() {
			if(head != null) return head.toString();
			else return null;
		}
		
		public static void main(String[] args) {
			System.out.println("Welcome to linked list program");
			LinkedList linkedList = new LinkedList<Integer>();
			linkedList.append(56);
			
			linkedList.append(70);
			linkedList.insert(1,30);
			System.out.println(linkedList);
			System.out.println(linkedList.pop());
			System.out.println("After Removeing New head element "+linkedList.headItem());
			System.out.println(linkedList);
			
			
		}
}
