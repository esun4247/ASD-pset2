package pset2;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList {
	private int size;
	private Node first = null;
	private Node last = null;

	public SimpleLinkedList() {
		size = 0;
		first = new Node(null, null, null);
		last = new Node(null, first, null);
		first.setNext(last);
	}
	
	public SimpleLinkedList(List<String> list) {
		first = new Node(null, null, null);
		last = new Node(null, null, null);
		Node currentNode = first;
		for(int i = 0; i < list.size(); i++) {
			currentNode = currentNode.addAfter(list.get(i));
		}
		currentNode.setNext(last);
		last.setPrevious(currentNode);
		size = list.size();
	}
	
	public void add(int index, String s) {
		checkIndex(index);
		Node nextNode = getNode(index);
		Node prevNode = nextNode.getPrevious();
		Node newNode = new Node(s, prevNode, nextNode);
		prevNode.setNext(newNode);
		nextNode.setPrevious(newNode);
		size++;
	}
	
	public void addFirst(String s) {
		add(0, s);
	}
	
	public void addLast(String s) {
		add(size, s);
	}
	
	public void clear() {
		for(int i = size-1; i >= 0; i--) {
			Node tempNode = getNode(i);
			tempNode.getPrevious().setNext(null);
			tempNode.setPrevious(null);
		}
		first.setNext(last);
		last.setPrevious(first);
		size = 0;
	}
	
	public boolean contains(String s) {
		return (indexOf(s) != -1);
	}
	
	public String get(int index) {
		checkIndexAlt(index);
		Node tempNode = getNode(index);
		return tempNode.getData();
	}
	
	public String getFirst() {
		checkSize();
		return get(0);
	}
	
	public String getLast() {
		checkSize();
		return get(size-1);
	}
	
	public int indexOf(String s) {
		Node currentNode = first;
		for(int i = 0; i < size; i++) {
			currentNode = currentNode.getNext();
			if(currentNode.getData().equals(s)) {
				return i; 
			}
		}
		return -1;
	}
	
	public String remove(int index) {
		checkIndexAlt(index);
		Node tempNode = getNode(index);
		Node prevNode = tempNode.getPrevious();
		Node nextNode = tempNode.getNext();
		String element = tempNode.getData();
		tempNode = null;
		prevNode.setNext(nextNode);
		nextNode.setPrevious(prevNode);
		size--;
		return element;
	}
	
	public boolean remove(String s) {
		int index = indexOf(s);
		if(index != -1) {
			remove(index);
			return true;
		}
		return false;
	}
	
	public String removeLast() {
		checkSize();
		return remove(size-1);
	}
	
	public String removeFirst() {
		checkSize();
		return remove(0);
	}
	
	public String set(int index, String s) {
		checkIndexAlt(index);
		Node tempNode = getNode(index);
		String element = tempNode.getData();
		tempNode.setData(s);
		return element;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String s = "[";
		Node currentNode = first;
		for(int i = 0; i < size-1; i++) {
			currentNode = currentNode.getNext();
			s = s + currentNode.getData() + ", ";
		}
		if(size != 0) {
			s +=  currentNode.getNext().getData(); 
		}
		s += "]";
		return s;
	}
	
	private Node getNode(int index) {
		Node currentNode = first.getNext();
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	
	private void checkIndex(int index) {
		if(index < 0 || index > size) { 
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}
	
	private void checkIndexAlt(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}
	
	private void checkSize() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
	}
	
		
		
	
} 