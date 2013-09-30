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
		
		List<Point> pointsCopy = Arrays.asList(points);
		for(int i = 0; i < pointsNum; i++){
			Collections.sort(pointsCopy, points[i].SLOPE_ORDER);
			
			//at least 4 points
			for(int j= 0; j < pointsNum - 3; ) {
				if(points[i].slopeTo(pointsCopy.get(j)) == 
						points[i].slopeTo(pointsCopy.get(++j))){
					
					int start = j - 1;
					while( (++ j) < pointsNum && 
							points[i].slopeTo(pointsCopy.get(j - 1)) == 
							points[i].slopeTo(pointsCopy.get(j)));
					//find a collinear set of points
					int coSize = j - start;
					if(coSize >= 4){
						List<Point> collinearPoints = pointsCopy.subList(start, j);//j exclusive
						Collections.sort(collinearPoints);
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
