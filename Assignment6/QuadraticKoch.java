/*************************************************************************
 * Compilation: javac QuadraticKoch.java
 * Execution: java QuadraticKoch n
 *
 * @author Jeremy Hui
 *
 *************************************************************************/
public class QuadraticKoch {

    /**
     * Gets the set of coordinates to draw one segment of the Quadratic Koch Curve.
     * Returns the coordinates in a 2D array of doubles in the following format:
     * {array of x-coordinates,
     * array of y-coordinates}
     * 
     * @param x0 the x-coordinate of one endpoint
     * @param y0 the y-coordinate of one endpoint
     * @param x5 the x-coordinate of the other endpoint
     * @param y5 the y-coordinateof the other endpoint
     * @return the set of coordinates to draw one segment of the Quadratic Koch
     *         Curve
     */
    public static double[][] getCoords(double x0, double y0, double x5, double y5) {

        double[][] finalArr = new double[2][6];

        finalArr[0][0] = x0;
        finalArr[1][0] = y0;
        finalArr[0][5] = x5;
        finalArr[1][5] = y5;

        //bump points up 
        if(x0 < x5 && y0 == y5) {
            double d = (x5 - x0)/3.0;

            finalArr[0][1] = x0 + d;
            finalArr[1][1] = y0;
            finalArr[0][2] = x0 + d;
            finalArr[1][2] = y0 + d;
            finalArr[0][3] = x0 + 2.0 * d;
            finalArr[1][3] = y0 + d;
            finalArr[0][4] = x0 + 2.0 * d;
            finalArr[1][4] = y0;
        }

        //bump points left 
        else if(x0 == x5 && y0 < y5) {
            double d = (y5 - y0)/3.0;

             finalArr[0][1] = x0;
             finalArr[1][1] = y0 + d;
             finalArr[0][2] = x0 - d;
             finalArr[1][2] = y0 + d;
             finalArr[0][3] = x0 - d;
             finalArr[1][3] = y0 + 2.0 * d;
             finalArr[0][4] = x0;
             finalArr[1][4] = y0 + 2.0 * d;
        }

        //bump points right 
        else if(x0 == x5 && y0 > y5) {
            double d = (y0 - y5)/3.0;

             finalArr[0][1] = x0;
             finalArr[1][1] = y0 - d;
             finalArr[0][2] = x0 + d;
             finalArr[1][2] = y0 - d;
             finalArr[0][3] = x0 + d;
             finalArr[1][3] = y0 - 2.0 * d;
             finalArr[0][4] = x0;
             finalArr[1][4] = y0 - 2.0 * d;
        }

        //bump points down 
        else if(x0 > x5 && y0 == y5) {
            double d = (x0 - x5)/3.0;

             finalArr[0][1] = x0 - d;
             finalArr[1][1] = y0;
             finalArr[0][2] = x0 - d;
             finalArr[1][2] = y0 - d;
             finalArr[0][3] = x0 - 2.0 * d;
             finalArr[1][3] = y0 - d;
             finalArr[0][4] = x0 - 2.0 * d;
             finalArr[1][4] = y0;
        }

        else if(x0 == x5 && y0 == y5) {
            for(int i = 0; i < finalArr[0].length; i++) {
                finalArr[0][i] = x0;
                finalArr[1][i] = y0;
            }
        }

        else if(x0 == 0 && x5 == 3 && y0 == 0 && y5 == 3) {
            finalArr[0][1] = 1.0;
            finalArr[0][2] = 0.0;
            finalArr[0][3] = 1.0;
            finalArr[0][4] = 2.0;

            finalArr[1][1] = 1.0;
            finalArr[1][2] = 2.0;
            finalArr[1][3] = 3.0;
            finalArr[1][4] = 2.0;
        }
        

        return finalArr;
    }

    /**
     * Gets the set of coordinates from getCoords() to draw the snowflake,
     * and calls Koch on two adjacent array indices with n being one less.
     * The method draws a line between the two endpoints if n == 0.
     * 
     * @param x0 the x-coordinate of one endpoint
     * @param y0 the y-coordinate of one endpoint
     * @param x5 the x-coordinate of the other endpoint
     * @param y5 the y-coordinate of the other endpoint
     * @param n  The current order
     */
    public static void koch(double x0, double y0, double x5, double y5, int n) {
       if(n == 0) {
            StdDraw.line(x0,y0,x5,y5);
        } else {
            double[][] coords = getCoords(x0,y0,x5,y5);
            for(int i = 0; i < coords[0].length - 1; i++) {
                koch(coords[0][i], coords[1][i], coords[0][i + 1], coords[1][i + 1], n - 1);
            }
        }
    }

    /**
     * Takes an integer command-line argument n,
     * and draws a Quadratic Koch Curve of order n in a 1 x 1 canvas
     * with an initial square side length of 0.5.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int order = Integer.parseInt(args[0]);

        koch(0.25, 0.25, 0.25, 0.75, order);
        koch(0.25, 0.75, 0.75, 0.75, order);
        koch(0.75, 0.75, 0.75, 0.25, order);
        koch(0.75, 0.25, 0.25, 0.25, order);
    }
}