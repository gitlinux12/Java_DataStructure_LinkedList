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

	public void append(Type item) {
			Node<Type> newNode = new Node<Type>(item);
			if (isEmpty()) head = tail = newNode;
			else {
				tail.next = newNode;
				tail = newNode;
			}
		}
	public String toString() {
			if(head != null) return head.toString();
			else return null;
		}
		
		public static void main(String[] args) {
			System.out.println("Welcome to linked list program");
			LinkedList linkedList = new LinkedList<Integer>();
			linkedList.append(56);
			linkedList.append(30);
			linkedList.append(70);
			System.out.println(linkedList);
			
			
		}
}
