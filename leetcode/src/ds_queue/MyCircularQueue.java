package ds_queue;

public class MyCircularQueue {
    private int[] queue;
    private int head;
    private int capacity;
    private int len;
    public MyCircularQueue(int k) {
        capacity = k;
        len = k;
        queue = new int[k];
        head = -1;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head++;
        }
        queue[(head+len-capacity)%len] = value;
        capacity--;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        queue[head] = -1;
        head = (head+1) % len;
        capacity++;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return queue[((head+len-capacity-1)%len)];
    }

    public boolean isEmpty() {
        if(capacity == queue.length) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        if(capacity == 0) {
            return true;
        }else{
            return false;
        }
    }
}
