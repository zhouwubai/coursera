import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
	int count;
	
	public Deque() {
		// TODO Auto-generated constructor stub
		count = 0;
	}
	
	public boolean isEmpty(){
		return (first == null || last == null);
	}
	
	
	public int size(){
		return count;
	}
	
	public void addFirst(Item item){
		
		if(item == null)
			throw new NullPointerException("new add item can not be null");
		
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.prev = null;
		if(isEmpty()) last = first;
		else{
			first.next = oldFirst;
			oldFirst.prev = first;
		}
		count ++;
	}
	
	public void addLast(Item item){
		
		if(item == null)
			throw new NullPointerException("new add item can not be null");
		
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else{
			last.prev = oldLast;
			oldLast.next = last;
		}
		count++;
	}
	
	
	public Item removeFirst(){
		
		if(isEmpty())
			throw new NoSuchElementException("deque already empty");
		
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		else{
			first.prev = null;
		}
		count--;
		return item;
	}
	
	
	public Item removeLast(){
		
		if(isEmpty())
			throw new NoSuchElementException("deque already empty");
		
		Item item = last.item;
		last = last.prev;
		if(isEmpty()) first = null;
		else{
			last.next = null;
		}
		count--;
		return item;
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new DequeIterator();
	}
	
	
	// Because it's a deque, we need to use two direction linked list
	private class Node{
		Item item;
		Node next;
		Node prev;
	}
	
	// Item here means parent class's generic type Item, unknown this before :)
	private class DequeIterator implements Iterator<Item>{

		//if I am a private class inside a class
		//then I can refer to parent's members
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return first != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		Deque<String> test = new Deque<String>();
		test.addFirst("aaa");
		test.addFirst("bbb");
		StdOut.print(test.removeLast());
		
	}
	
}
