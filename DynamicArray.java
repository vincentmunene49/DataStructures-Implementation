package projects;

import java.lang.reflect.Array;
import java.util.Arrays;

class DynamicArray {
    public static void main(String[] args) {
        ArrayImplement array = new ArrayImplement(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        array.remove(20); // item won't exisst so it will exit
        array.indexOf(4);
        array.clear(); //deletes all the items in the array

        array.displayArray();

    }
}

class ArrayImplement {
    private int myArray[];
    // private int arrayLength;
    private int count;

    ArrayImplement(int arrayLength) {
        myArray = new int[arrayLength];
        this.count = 0;

    }

    public void add(int data) {
        myArray[count++] = data;
        // check if array is full and if full create another array of double the size
        // and copy the items of one array to the new and reassign the array

        if (count >= myArray.length) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = myArray[i];
                // newArray[count] = data;
            }
            myArray = newArray;

        }

    }

    public void remove(int data) {
        int found = -1;// we will use this to test whether what we want is in the array
        for (int i = 0; i < count; i++) {
            if (data == myArray[i]) {
                found = 0;
                int temp = myArray[i];
                myArray[i] = myArray[i + 1];
                myArray[i + 1] = temp;

            }

        }
        count--;
        if (found == -1) {
            System.out.println("item does not exist");
        }
    }

    public void indexOf(int data) {// we will use this to check index of the entered data
        int found = -1;
        for (int i = 0; i < count; i++) {
            if (myArray[i] == data) {
                found = 0;
                System.out.println("The index of " + data + " is " + i);
            }
        }
        if (found == -1) {
            System.out.println("Specified item does not exist");
            System.exit(1);
        }

    }

    public void clear() {
        for (int i = 0; i < myArray.length; i++) {
            count--;
        }
    }

    public void displayArray() {
        for (int i = 0; i < count; i++) {
            System.out.print(myArray[i] + " ,");
        }
    }

}