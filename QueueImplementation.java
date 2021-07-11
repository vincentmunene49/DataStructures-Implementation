package projects;

import java.util.*;

class QueueImplmentation {
    public static void main(String[] args) {
        Queue queue = new Queue(10);

        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        queue.enque(6);
        queue.enque(3);
        queue.enque(8);
        queue.enque(9);
        queue.dequeue();
        queue.dequeue();
        // queue.dequeue();
        queue.peek();

        queue.display();
    }
}

class Queue {
    private int first;// pointer to front of queue
    private int last;// pointer to the last item in the queue
    private int arr[];

    Queue(int arrLength) {
        arr = new int[arrLength];
        last = 0;
        first = 0;
    }

    public void enque(int data) {
        if (isFull()) {
            System.out.println("The queue is full cannot be added any more items");
            System.exit(1);
        }
        if (isEmpty()) {
            arr[first] = data;
        } else {
            arr[last] = data;
        }
        last++;
    }

    public int dequeue() {
        int pointerToCurrentFirstElement = first;
        if (isEmpty()) {
            System.out.println("The queue is Empty, nothing to remove");
        } else {
            first++;
        }

        System.out.println("First element " + arr[pointerToCurrentFirstElement] + " has been removed");
        return arr[pointerToCurrentFirstElement];
    }

    public int peek() {
        System.out.println(arr[first]);
        return arr[first];
    }

    public boolean isEmpty() {
        return first == last;
    }

    public boolean isFull() {
        return last == arr.length - 1;
    }

    public void display() {
        for (int i = first; i < last; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}