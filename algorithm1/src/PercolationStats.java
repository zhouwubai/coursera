
public class PercolationStats {

	private int N;
	private int T;
	private double[] px; // fraction of open site in each experiment
	
	public PercolationStats(int N, int T) {
		// TODO Auto-generated constructor stub
		if(N <= 0 || T <= 0)
			throw new IllegalArgumentException("Given N <= 0 || T <= 0");
		
		this.N = N;
		this.T = T;
		px = new double[T];
		
		runExperiments();
	}
	
	/**
	 * run T experiments until it percolates
	 */
	private void runExperiments(){
		
		Percolation perc = null;
		int[] perm = null;
		int count = 0;
		
		for(int i = 0; i < T; i++){
			
			perc = new Percolation(N);
			perm = randomizeInPlace(N*N);
			
			// start randomly open site and test percolate()
			int row,col;
			for(count = 0; count < perm.length; count++){
				row = (int)(perm[count] / N) + 1;
				col = perm[count] % N + 1;
				perc.open(row, col);
				
				if(perc.percolates()) break;
			}
			
			px[i] = (count+1) / (double)(N*N);  // get one sample instance
		}
		
	}
	
	
	
	public double mean(){
		return StdStats.mean(px);
	}
	
	
	
	public double stddev(){
		return StdStats.stddev(px);
	}
	
	
	
	public double confidenceLo(){
		double mu = mean();
		double sigma = stddev();
		
		return (mu - 1.96 * sigma / Math.sqrt(T));
	}
	
	
	
	public double confidenceHi(){
		double mu = mean();
		double sigma = stddev();
		
		return (mu + 1.96 * sigma / Math.sqrt(T));
	}
	
	
	
	//some util function
	
	/**
	 * generate a random permutation of [0,1,2,3,...,n]
	 * @param n
	 * @return
	 */
	private int[] randomizeInPlace(int n){
		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = i;
		}
		
		int tmp;
		for(int i = 0; i < n; i++){
			int swap = StdRandom.uniform(i, n); //generate random integer range [i,n-1]
			//swap array[i] with array[swap]
			tmp = array[i];
			array[i] = array[swap];
			array[swap] = tmp;
		}
		
		return array;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		PercolationStats percState = new PercolationStats(N, T);
		
		String confidence = percState.confidenceLo() + ", " + percState.confidenceHi();
        StdOut.println("mean                    = " + percState.mean());
        StdOut.println("stddev                  = " + percState.stddev());
        StdOut.println("95% confidence interval = " + confidence);
	}
	
}
