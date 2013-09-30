import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Brute {
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
		
		// find 4 points p-r-s-t that share same line
		for(int p = 0; p < pointsNum; p++) {
			for(int r= p+1; r < pointsNum; r++) {
				double slopePR = points[p].slopeTo(points[r]);
				for(int s = r+1; s < pointsNum; s++) {
					double slopeRS = points[r].slopeTo(points[s]);
					//check whether three points share same line
					if(slopePR == slopeRS) {
						for(int t = s+1; t < pointsNum; t++) {
							double slopeST = points[s].slopeTo(points[t]);
							// four points share same line.
							if(slopeRS == slopeST) {
								List<Point> collinearPoints = new ArrayList<Point>();
								collinearPoints.add(points[p]);
								collinearPoints.add(points[r]);
								collinearPoints.add(points[s]);
								collinearPoints.add(points[t]);
								Collections.sort(collinearPoints);
								
								for(int i = 0; i < 4; i++) {
									StdOut.print(collinearPoints.get(i));
									if(i != 3) {
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
}
