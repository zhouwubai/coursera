import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER;       // YOUR DEFINITION HERE
//    String name = "outer";

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
        SLOPE_ORDER = new PointsComparatorBySlope();
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    	if(this.x == that.x) {
    		if(this.y == that.y)
    			return Double.NEGATIVE_INFINITY;
    		else
    			return Double.POSITIVE_INFINITY;
    	}
    	
    	return (that.y - this.y)/(double)(that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    	if(this.y < that.y) return -1;
    	if(this.y == that.y && this.x < that.x) return -1;
    	if(this.y == that.y && this.x == that.x) return 0;
    	return +1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    
    
    private class PointsComparatorBySlope 
    					implements Comparator<Point>{
    	
    	Point parent;
//    	String name = "inner";
    	
    	/**
    	 * Way to refer to outer class this. this is actually technical way
    	 * to solve name conflicts. 
    	 */
    	public PointsComparatorBySlope() {
			// TODO Auto-generated constructor stub
    		parent = Point.this;
//    		StdOut.println("inner: " + name);
//    		StdOut.println("outer: " + Point.this.name);
		}
    	
		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			double diff = parent.slopeTo(o1) - parent.slopeTo(o2);
			if(diff < 0) return -1;
			if(diff > 0) return +1;
			return 0;
		}
    	
    } 

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    	Point p1 = new Point(2,3);
    	Point p2 = new Point(1,1);
    	Point p3 = new Point(3,2);
    	Point[] points = {p1,p2,p3};
    	
    	int result = p1.SLOPE_ORDER.compare(p1, p3);
    	StdOut.print(result);
    	List<Point> ps = Arrays.asList(points);
    	Collections.sort(ps,p1.SLOPE_ORDER);
    	for(Point p : ps) {
    		StdOut.print(p.toString());
    	}
    }
}