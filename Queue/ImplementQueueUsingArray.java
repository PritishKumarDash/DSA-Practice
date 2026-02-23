/*
Problem: Implement Queue
Approach: Array simulation
*/

class MyQueue {
    int[] arr = new int[1000];
    int front = 0, rear = 0;

    void push(int x){
        arr[rear++] = x;
    }

    int pop(){
        return arr[front++];
    }

    int peek(){
        return arr[front];
    }

    boolean empty(){
        return front == rear;
    }
}
