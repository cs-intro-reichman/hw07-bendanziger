/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
    StdDraw.line(x1, y1, x2, y2);
    return;
	}
	double splitX1 = x1 + (x2 - x1) / 3.0;
	double splitY1 = y1 + (y2 - y1) / 3.0;
	double splitX2 = x1 + 2 * (x2 - x1) / 3.0;
	double splitY2 = y1 + 2 * (y2 - y1) / 3.0;
	double peakX = (x1 + x2) / 2.0 + Math.sqrt(3) / 6.0 * (y1 - y2);
	double peakY = (y1 + y2) / 2.0 + Math.sqrt(3) / 6.0 * (x2 - x1);
	curve(n - 1, x1, y1, splitX1, splitY1);
	curve(n - 1, splitX1, splitY1, peakX, peakY);
	curve(n - 1, peakX, peakY, splitX2, splitY2);
	curve(n - 1, splitX2, splitY2, x2, y2);
	}
    
    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(-0.5, 1.3);
		StdDraw.setXscale(-0.2, 1.2);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
double x1 = 0, y1 = 0;
double x2 = 1, y2 = 0;
double x3 = 0.5, y3 = Math.sqrt(3) / 2;
curve(n, x1, y1, x3, y3);
curve(n, x3, y3, x2, y2);
curve(n, x2, y2, x1, y1);
	}
}
