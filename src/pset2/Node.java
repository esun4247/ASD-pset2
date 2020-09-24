package pset2;

public class Node {
	
	private String data;
	private Node previousNode;
	private Node nextNode;
	
	public Node(String s, Node previous, Node next) {
		data = s;
		previousNode = previous;
		nextNode = next;
		
	}
	
	public Node next() {
		return nextNode;
	}
	
	public Node previous() {
		return previousNode;
	}
	
	public Node addAfter(String s) {
		
		Node newNode = new Node(s, this, null);
		this.nextNode = newNode;
		return newNode;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String s) {
		data = s;
		return;
	}
	
	public void setPrevious(Node previousNode) {
		this.previousNode = previousNode;
	}
	
	public void setNext(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public Node getPrevious() {
		return previousNode;
	}
	
	public Node getNext() {
		return nextNode;
	}
}