
/**
 * 
 * @author zhouwubai
 *
 * @param <Item>
 */
public class Subset {

//	private RandomizedQueue<Item> rQueu;
//	private int k;
//	
//	/**
//	 * k subset of universal set.
//	 * please use add() method to add universal set elements
//	 * before use genSubset to generate subset.
//	 */
//	public Subset(){
//		rQueu = new RandomizedQueue<Item>();
//		this.k = 0;//initial value
//	}
//	
//	
//	public void add(Item item){
//		rQueu.enqueue(item);
//	}
//	
//	/**
//	 * Here can not return Item[], weird..
//	 * If TA see this, give me some feedback, thanks.
//	 * @return
//	 */
////	@SuppressWarnings("unchecked")
//	public Object[] genSubset(){
//		int n = (k > rQueu.size() ? rQueu.size() : k);
//		Object[] rtn = new Object[n];
//		for(int i = 0; i < n; i++){
//			rtn[i] = rQueu.dequeue();
//		}
//		return rtn;
//	}
	
	
	
	public static void main(String[] args) {
		
//		Subset<String> sbSet = new Subset<String>(Integer.valueOf(args[0]));
		int k = Integer.valueOf(args[0]);
		RandomizedQueue<String> rQueu = new RandomizedQueue<String>();
		
		while(!StdIn.isEmpty())
			rQueu.enqueue(StdIn.readString());
	
		int n = (k > rQueu.size() ? rQueu.size() : k);
		for(int i = 0; i < n; i++){
			StdOut.println(rQueu.dequeue());
		}
	}
	
}
