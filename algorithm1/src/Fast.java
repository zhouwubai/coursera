import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fast {

	public static void main(String[] args) {
		
		StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
		
		In in = new In(args[0]);
		int pointsNum = in.readInt();
		Point[] points = new Point[pointsNum];
		
		for(int i = 0; i < pointsNum; i++){
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x,y);
			points[i].draw();
		}
		
		
		/**
		 * strange thing happen here, Arrays.asList() return a 
		 * fixed sized list. arr.subList() return a list view backed by 
		 * arr which does not support add and removal. Why ?
		 * dupChecker for check same line
		 */
		
		List<Point> pointsCopy = new ArrayList<Point>(Arrays.asList(points));
		for(int i = 0; i < pointsNum; i++){
			Collections.sort(pointsCopy, points[i].SLOPE_ORDER);
			
			//at least 4 points, do not start from self
			for(int j= 1; j <= pointsNum - 3; ) {
				if(points[i].slopeTo(pointsCopy.get(j)) == 
						points[i].slopeTo(pointsCopy.get(++j))){// already three points here.
					
					int start = j - 1;
					double slope = points[i].slopeTo(pointsCopy.get(j - 1));
					while( (++ j) < pointsNum && 
							slope == points[i].slopeTo(pointsCopy.get(j)));
					//find a collinear set of points,add one to include points[i] itself
					int coSize = j - start + 1;
					if(coSize >= 4){ 
						List<Point> collinearPoints = new ArrayList<Point>(pointsCopy.subList(start, j));//j exclusive
						collinearPoints.add(points[i]);//add itself
						Collections.sort(collinearPoints);
						
						/**
						 * this check for duplicate line, based on that knowing system use stable sort algorithm.
						 * so no matter how we sort it, the first element in collinearPoints will be one-to-one mapping
						 * to a unique line if this line exists
						 */
						if(points[i].equals(collinearPoints.get(0))) {
							for(int m = 0; m < coSize; m++) {			
								StdOut.print(collinearPoints.get(m));
								if(m != coSize -1) {
									StdOut.print(" -> ");
								} else {
									StdOut.println();
								}
							}	
							Collections.min(collinearPoints).drawTo(Collections.max(collinearPoints));
						}
					}
				}
			}
		}
		
	}
	
}
