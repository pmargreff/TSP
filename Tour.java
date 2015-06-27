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

            dist += tmp.p.distanceTo(this.head_.p);
        }
        return dist;
    }

    /*
     *   ver por que está dando um resultado melhor 
     *   que o esperado (mas não o ótimo)
     */
    void insertNearest(Point newPoint) {                   // insert p using nearest neighbor heuristic
        //caso a lista estiver vazia insere no inicio
        if (this.head_.p == null) {

            this.head_.p = newPoint;
            this.head_.next = head_;

        } else {
            double dist = this.head_.p.distanceTo(newPoint); //salva a distância do primeiro
            Node near = this.head_; //e inicia usando para o mais perto
            
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
//            System.out.println(dist);
//            System.out.println();

            //insere o novo nodo após e mais próximo
            Node newNode = new Node();
            newNode.p = newPoint;
            newNode.next = near.next;   //point the new to next
            near.next = newNode; //point the new to first
        }
    }

    void insertSmallest(Point p) {

    }

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
