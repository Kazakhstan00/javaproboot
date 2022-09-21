package game;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) throws Exception{
        if(x>=0 && x<=1000 && y>=0 && y<=1000) {
            this.x = x;
            this.y = y;
        }else throw new Exception();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x>=0 && y<=1000) {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y>=0 && y<=1000) {
            this.y = y;
        }
    }

    public int distance(Point a){
        int distance;
        distance=(int)Math.sqrt((a.x-this.x)*(a.x-this.x)+(a.y-this.y)*(a.y-this.y));
        return distance;
    }
}

class Example {
    public static void main(String[] args) {
        Map<Point, List<Herois>> group = new HashMap<>();

        LinkedList<Herois> list = new LinkedList<>();


    }
}
