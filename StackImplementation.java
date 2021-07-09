package projects;

class StackImplementation {
    public static void main(String[] args) {
        Stack stack = new Stack(6);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        stack.pop();

        System.out.println("The item currently at top of array is " + stack.peek());

        stack.display();

    }
}

class Stack {
    private int top; // this will be our pointer
    private int stackArray[];
    private int maxSize;

    Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        stackArray = new int[maxSize];
    }

    public void push(int data) {
        top++;
        if (isFull()) {
            System.out.println("Stack is full");
            System.exit(1);
        } else {
            stackArray[top] = data;
        }
    }

    public int pop() {
        int current = top;
        top--;
        return stackArray[current];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        while (!isEmpty()) {
            System.out.println(pop() + " ");
        }
    }

}