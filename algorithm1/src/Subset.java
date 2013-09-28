
/**
 * 
 * @author zhouwubai
 *
 * @param <Item>
 */
public class Subset<Item> {

	private RandomizedQueue<Item> rQueu;
	private int k;
	
	/**
	 * k subset of universal set.
	 * please use add() method to add universal set elements
	 * before use genSubset to generate subset.
	 */
	public Subset(int k){
		rQueu = new RandomizedQueue<Item>();
		this.k = k;//initial value
	}
	
	
	public void add(Item item){
		rQueu.enqueue(item);
	}
	
	/**
	 * Here can not return Item[], weird..
	 * If TA see this, give me some feedback, thanks.
	 * @return
	 */
//	@SuppressWarnings("unchecked")
	public Object[] genSubset(){
		int n = (k > rQueu.size() ? rQueu.size() : k);
		Object[] rtn = new Object[n];
		for(int i = 0; i < n; i++){
			rtn[i] = rQueu.dequeue();
		}
		return rtn;
	}
	
	
	
	public static void main(String[] args) {
		
		Subset<String> sbSet = new Subset<String>(Integer.valueOf(args[0]));
		
		while(!StdIn.isEmpty())
			sbSet.add(StdIn.readString());
	
		Object[] strs = (Object[]) sbSet.genSubset();
		for(Object str : strs){
			StdOut.println((String)str);
		}
		
	}
	
}
