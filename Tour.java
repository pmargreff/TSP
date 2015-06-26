/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pmargreff
 */
public class Tour {

    private Node head_;

    Tour() {                                   // create an empty tour
        this.head_ = new Node();
    }

    Tour(Point a, Point b, Point c, Point d) { // create a 4 point tour a->b->c->d->a
        this.head_ = new Node();
        Node tmp = new Node();
        Node newNode = new Node();

        //set head a
        this.head_.p = a;
        tmp = this.head_;

        //set b
        newNode.p = b;
        tmp.next = newNode; //a point to b

        tmp = newNode;
        newNode = new Node();
        newNode.p = c;
        tmp.next = newNode;

        tmp = newNode;
        newNode = new Node();
        newNode.p = d;
        tmp.next = newNode;
        newNode.next = this.head_;

    }

    void show() {                                   // print the tour to standard output
        if (this.head_.p != null) {
            Node tmp;
            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
                StdOut.println(tmp.p);
            }
            StdOut.println(tmp.p);
        }
    }

    void draw() {                                   // draw the tour to standard draw
        StdDraw.setXscale(0, 600); //set windows scale
        StdDraw.setYscale(0, 600);
        
        if (this.head_.p != null) {
            Node tmp;
            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
                tmp.p.drawTo(tmp.next.p);
            }
            tmp.p.drawTo(tmp.next.p);
        }
    }

    int size() {                                   // number of points on tour
        int size = 0;

        if (this.head_.p != null) {
            Node tmp;
            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
                size++;
            }
            size++;
        }
        return size;
    }

    double distance() {                               // return the total distance of the tour
        double dist = 0.0;
        if (this.head_.p != null) {
            Node tmp;
            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
                dist += tmp.p.distanceTo(tmp.next.p);
            }
            dist += tmp.p.distanceTo(tmp.next.p);
        }
        return dist;
    }

    void insertNearest(Point p) {                   // insert p using nearest neighbor heuristic
    }

    void insertSmallest(Point p) {

    }

    void insertInOrder(Point newPoint) {

    }
}
