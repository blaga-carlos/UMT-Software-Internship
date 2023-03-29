/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise1;

/**
 *
 * @author carloss
 */

import java.util.*;

public class Exercise1 {
    
    public static void main(String[] args) {
        Point[] points = {new Point(1,1), new Point(1,3), new Point(2,1), new Point(2,3), new Point(3,1), new Point(3,3)};
        System.out.println(countRectangles(points)); // output: 3
        Point[] modifiedPoints = {new Point(1,1), new Point(1,3), new Point(2,1), new Point(3,1), new Point(3,3)};
        System.out.println(countRectangles(modifiedPoints)); // output: 1
    }
    
    public static int countRectangles(Point[] points) {
        HashSet<Point> PointSet = new HashSet<>();
        for (Point point : points) {
            PointSet.add(point);        
        }
//        System.out.println(PointSet);
        int count = 0;
        
        for (int i = 0; i < points.length - 1; i++) {
//            System.out.println(points[i]);
            Point p1 = points[i];
            for (int j = i+1; j < points.length; j++) {
                Point p2 = points[j];
                if (p1.x != p2.x && p1.y != p2.y) {
                    Point p3 = new Point(p1.x, p2.y);
                    Point p4 = new Point(p2.x, p1.y);
                    if (PointSet.contains(p3) && PointSet.contains(p4)) {
                        count++;
                    }
                }
            }
        }
        return count/2;
    }

    
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.x;
        hash = 13 * hash + this.y;
        return hash;
    }
    
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}



