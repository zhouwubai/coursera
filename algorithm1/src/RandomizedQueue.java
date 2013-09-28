import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Object[] items;
	private int first = 0;
	private int last = 0;
	private int capacity;
	
	public RandomizedQueue(int initCapacity) {
		// TODO Auto-generated constructor stub
		//generic type
		this.capacity = initCapacity;
		items = new Object[initCapacity]; 
	}
	
	
	/**
	 * initial size is 10 
	 */
	public RandomizedQueue(){
		this(10);
	}
	
	
	public boolean isEmpty(){
		return (first == last);
	}
	
	
	
	public int size(){
		int diff = last - first;
		return (diff < 0 ? diff + capacity : diff);
	}
	
	
	/**
	 * enqueue element to end of queue,resize size
	 * is half of capacity after enqueue.
	 * @param item
	 */
	public void enqueue(Item item){
		
		if(size() == capacity - 1){
			resize(2 * capacity);
		}	
		items[last] = item;
		last = (last+1) % capacity;

	}
	
	
	/**
	 * randomly dequeue a element. Here I use technical to generate
	 * a random permutation to ensure amortized constant cost
	 * it will shrink when size is one fourth of capacity after dequeue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Item dequeue(){
		int rndIdx= StdRandom.uniform(first,first+size()) % capacity;
		
		//swap first and rndIdex item, then dequeue the first one
		Item item = (Item) items[rndIdx];
		items[rndIdx] = items[first];
//		items[first] = item;  // not necessary for this step
		first = (first+1) % capacity;
		
		if(size() > 10 && size() == capacity/4){
			resize(capacity/2);
		}
		return item;
	}
	
	
	/**
	 * return a random item without delete it.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Item sample(){
		int rndIdx = StdRandom.uniform(first,first+size()) % capacity;
		return (Item) items[rndIdx];
	}
	
	
	public Iterator<Item> iterator(){
		
		return new RandomizedQueueIterator();
		
	}
	
	
	/**
	 * iterator for RandomizedQueue. use same technical above
	 * store a uniform random permutation of items' order, then 
	 * iterate according to this order. 
	 * @author zhouwubai
	 *
	 */
	private class RandomizedQueueIterator implements Iterator<Item>{
		
		int[] randomOrder;
		int pt = 0;
		
		public RandomizedQueueIterator(){
			int n = size();
			randomOrder = new int[n];
			
			for(int i = 0; i < n; i++){
				randomOrder[i] = i;
			}
			
			for(int i = 0; i < n; i++){
				int swap = StdRandom.uniform(i,n);
				int tmp = randomOrder[swap];
				randomOrder[swap] = randomOrder[i];
				randomOrder[i] = tmp;
			}
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return pt < randomOrder.length;
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public Item next() {
			// TODO Auto-generated method stub
			int idx = (first + randomOrder[pt++]) % capacity;
			return (Item) items[idx];
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}
	
	
	/**
	 * resize queue size to n.
	 * @param n
	 */
	private void resize(int n){
		
		Object[] newItems = new Object[n];
		int cnt = 0;
		for(int i = first; i % capacity != last; i++, cnt++){
			newItems[cnt] = items[i % capacity];
		}
		
		//reset value of member variables
		items = newItems;
		first = 0;
		last = cnt;
		capacity = n;
	}
	
	
	
	public static void main(String[] args) {
		
		RandomizedQueue<String> strQue = new RandomizedQueue<String>();
		strQue.enqueue("a");
		strQue.enqueue("b");
		strQue.enqueue("c");
		strQue.enqueue("e");
		strQue.dequeue();
		for(String str : strQue){
			StdOut.println(str);
		}
		
	}
	
}
