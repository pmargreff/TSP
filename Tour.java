import std.*;
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

    /**
     * Show x and y coordinates point
     */
    void show() {                                   // print the tour to standard output
        if (this.head_.p != null) {
            Node tmp;
            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
                StdOut.println(tmp.p);
            }
            StdOut.println(tmp.p);
        }
    }

    /**
     * draw the add points
     */
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

    /**
     * @return list size
     */
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
    
    /**
     * calculate circuit distance
     * @return  the circuit distance pass by all nodes until became the first
     */
    double distance() {                               // return the total distance of the tour
        double dist = 0.0;
        if (this.head_.p != null) {
            Node tmp;

            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
                dist += tmp.p.distanceTo(tmp.next.p);
            }

            dist += tmp.p.distanceTo(this.head_.p);
        }
        return dist;
    }

    /**
     * Add the new node with new point in the lowest cost to distance
     * the distance account is
     * Point of node N distance to new Point
     * @param newPoint 
     */
    void insertNearest(Point newPoint) {                   // insert p using nearest neighbor heuristic
        //case haven't nodes add the first
        if (this.head_.p == null) {

            this.head_.p = newPoint;
            this.head_.next = head_;

            //case have add at nearest    
        } else {
            double dist = this.head_.p.distanceTo(newPoint);
            Node near = this.head_;

            Node tmp;
            //percorre a lista
            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
//                System.out.print(tmp.p.distanceTo(newPoint)+" ");

                //caso seja o primeiro salve em near e atualiza a distância
                if (dist > tmp.p.distanceTo(newPoint)) {
                    dist = tmp.p.distanceTo(newPoint);
                    near = tmp;
                }

            }

            if (dist > tmp.p.distanceTo(newPoint)) {
                near = tmp;
            }

//          add the new node
            Node newNode = new Node();
            newNode.p = newPoint;
            newNode.next = near.next;   //point the new to next
            near.next = newNode; //point the new to first
        }
    }
    /**
     * Add the new node with new point in the lowest cost to distance
     * the distance account is
     * (node.point N1 distance to newPoint ) + (node.point N2 distance to newPoint ) - (node.point N1 distance to node.point N1)
     * @param newPoint 
     */
    void insertSmallest(Point newPoint) {
        //case haven't nodes add the first
        if (this.head_.p == null) {

            this.head_.p = newPoint;
            this.head_.next = head_;

            //case have add at nearest    
        } else {
            double dist = this.head_.p.distanceTo(newPoint) + this.head_.next.p.distanceTo(newPoint) - this.head_.p.distanceTo(this.head_.next.p);
            Node near = this.head_;

            Node tmp;
            //percorre a lista
            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
//                System.out.print(tmp.p.distanceTo(newPoint)+" ");

                //caso seja o primeiro salve em near e atualiza a distância
                if (dist > tmp.p.distanceTo(newPoint) + tmp.next.p.distanceTo(newPoint) - tmp.p.distanceTo(tmp.next.p)) {
                    dist = tmp.p.distanceTo(newPoint) + tmp.next.p.distanceTo(newPoint) - tmp.p.distanceTo(tmp.next.p);
                    near = tmp;
                }

            }

            if (dist > tmp.p.distanceTo(newPoint) + tmp.next.p.distanceTo(newPoint) - tmp.p.distanceTo(tmp.next.p)) {
                near = tmp;
            }

//          add the new node
            Node newNode = new Node();
            newNode.p = newPoint;
            newNode.next = near.next;   //point the new to next
            near.next = newNode; //point the new to first
        }
    }
    
    /**
     * Add the new node with new point at end of list
     * @param newPoint 
     */
    void insertInOrder(Point newPoint) {
        if (this.head_.p == null) {
            Node newNode = new Node();

            this.head_.p = newPoint;
            this.head_.next = head_;
        } else {
            Node tmp;
            //go to ond of list
            for (tmp = this.head_; tmp.next != this.head_; tmp = tmp.next) {
            }

            Node newNode = new Node();
            newNode.p = newPoint;
            tmp.next = newNode;   //point the last to new
            newNode.next = this.head_; //point the new to first
        }
    }
}
