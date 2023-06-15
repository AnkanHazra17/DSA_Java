

// qusetion: Given an array of integers from 1 to n, yhe task is to rearrange the elements of
// the array to have odd number appear first in accending order, followed by even numbers in 
// decending order.

import java.util.Arrays;

public class ArrangeElement{

    // Method to arrange the elements of the array with odd numbers first, followed by even numbers
    static void arrangeEle(int[] arr){
        int n = arr.length;
        int start = 0;     // Pointer for the start index
        int end = n - 1;   // Pointer for the end index
        int val = arr[0];  // Current value to be assigned to the array elements

        while(start <= end){
            if(val % 2 == 1){
                // Assign the current value to the element at the start index, if it is odd number
                arr[start] = val; 
                start++;  // Move the start index one position ahead
                val++;  // Increment the current value by 1 for the next iteration
            }

            else{
                // Assign the current value to the element at the end index, if it is Even number
                arr[end] = val; 
                end--;  // Move the end index one position back
                val++;  // Increment the current value by 1 for the next iteration
            }
        }

    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        arrangeEle(arr);
        System.out.println(Arrays.toString(arr));
    }
}