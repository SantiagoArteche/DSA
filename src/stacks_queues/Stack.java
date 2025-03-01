package stacks_queues;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Stack {
    protected int[] stack;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public Stack(){
        this(Stack.DEFAULT_SIZE);
    }

    public Stack(int val){
        this.stack = new int[val];
    }

    public void display(){
        int[] temp = new int[ptr + 1];
        for(int i = 0; i <= ptr; i++){
            temp[i] = this.stack[i];
        }
        System.out.println(Arrays.toString(temp));
    }

    public boolean push(int val){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        this.stack[ptr] = val;
        return true;
    }

    public boolean dynamicPush(int val){
        if(isFull()){
            int[] temp = new int[this.stack.length * 2];

            for(int i =0; i < this.stack.length; i++){
                temp[i] = this.stack[i];
            }

            this.stack = temp;
        }

        ptr++;
        this.stack[ptr] = val;
        return true;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Cannot pop from an empty stack");
        }


        int value = stack[ptr];
        stack[ptr--] = 0;
        return value;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Cannot peak from an empty stack");
        }

        return stack[ptr];
    }

    private boolean isFull(){
        return ptr == stack.length -1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(4);
        stack.dynamicPush(6);
        stack.dynamicPush(7);
        stack.dynamicPush(8);
        System.out.println(stack.peek());
        stack.display();
    }
}
