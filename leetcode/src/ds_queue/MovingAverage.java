package ds_queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private int size;
    private Queue<Integer> q;
    private double total = 0;
    public MovingAverage(int size){
        this.size = size;
        q = new LinkedList<>();
    }
    public double next(int val){
        if(q.size() == size){
            total = total - q.remove();
        }
        total = total + val;
        q.offer(val);
        return total/q.size();
    }
}
