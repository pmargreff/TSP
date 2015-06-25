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
    Tour(){                                   // create an empty tour
    
    }
    Tour(Point a, Point b, Point c, Point d){ // create a 4 point tour a->b->c->d->a
    }
    
    void show(){                                   // print the tour to standard output
    }
    
    void draw(){                                   // draw the tour to standard draw
    }
    
    int size(){                                   // number of points on tour
    }
    
    double distance(){                               // return the total distance of the tour
    }
    
    void insertNearest(Point p){                   // insert p using nearest neighbor heuristic
    }
    
    void insertSmallest(Point p){
        
    }
    
    void insertInOrder(Point newPoint){
        
    }
}
