import std.*;
/**
 * ***********************************************************************
 * YOU DO NOT NEED TO MODIFY THIS FILE
 *
 * Compilation: javac OrderInsertion.java Execution: java OrderInsertion <
 * file.txt Dependencies: Tour.java Point.java StdIn.java StdDraw.java
 *
 * Run order of input insertion heuristic for traveling salesperson problem and
 * plot results.
 *
 * % java OrderInsertion < tsp10.txt
 *
 ************************************************************************
 */
public class OrderInsertion {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int w = StdIn.readInt();
        int h = StdIn.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        // turn on animation mode
        StdDraw.show(0);

        // run smallest insertion heuristic
        Tour tour = new Tour();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            Point p = new Point(x, y);
            tour.insertInOrder(p);

            // uncomment the 4 lines below to animate
//            StdDraw.clear();
//            tour.draw();
//            StdDraw.text(100, 10, "" + tour.distance());
//            StdDraw.show(50);
        }

        // draw to standard draw
        tour.draw();
        StdDraw.show(0);

        // print tour to standard output
        tour.show();
        StdOut.printf("Tour distance =  %.4f\n", tour.distance());
        StdOut.printf("Number of points = %d\n", tour.size());
  
    }
}
