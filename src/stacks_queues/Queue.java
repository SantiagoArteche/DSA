package stacks_queues;

import java.util.Arrays;

public class Queue {
    protected int[] queue;
    private static final int DEFAULT_SIZE = 10;

    int end = -1;

    public Queue(){
        this(Queue.DEFAULT_SIZE);
    }

    public Queue(int val){
        this.queue = new int[val];
    }

    public void display(){
        int[] temp = new int[end + 1];
        for(int i = 0; i <= end; i++){
            temp[i] = this.queue[i];
        }
        System.out.println(Arrays.toString(temp));
    }

    public boolean insert(int val){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        end++;
        this.queue[end] = val;
        return true;
    }

    public boolean dynamicInsert(int val){
        if(isFull()){
            int[] temp = new int[this.queue.length * 2];

            for(int i = 0; i < this.queue.length; i++){
                temp[i] = this.queue[i];
            }

            this.queue = temp;
        }

        end++;
        this.queue[end] = val;
        return true;
    }

    public int unshift(){
        if(isEmpty()){
            System.out.println("Cannot pop from an empty queue");
        }

        int value = queue[0];

        for (int i = 1; i <= end; i++) {
            queue[i - 1] = queue[i];
        }

        end--;
        return value;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Cannot peak from an empty queue");
        }

        return queue[end];
    }

    private boolean isFull(){
        return end == queue.length -1;
    }

    private boolean isEmpty(){
        return end == -1;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.dynamicInsert(6);
        queue.dynamicInsert(7);
        queue.dynamicInsert(8);
        queue.unshift();
        queue.display();
    }
}
