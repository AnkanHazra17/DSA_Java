

import java.util.Arrays;

public class KLeargest{

    // Method to print the k largest elements from the array
    static int[] printKLeargest(int[] Arr, int k){
        int[] Arr2 = new int[k];  // Create a new array to store the k largest elements
        int n = Arr.length;   // Length of the input array
        Arrays.sort(Arr);  // Sort the input array in ascending order

        int leargest = n - 1;  // Index of the largest element in the sorted array
        for(int i = 0; i < k; i++){
            Arr2[i] = Arr[leargest];  // Assign the largest element to the corresponding index in Arr2
            leargest--;  // Decrement the index to move to the next largest element
        }
        return Arr2;  // Return the array containing the k largest elements
    }

    public static void main(String[] args){
        int[] Arr = {12, 5, 787, 1, 23};
        System.out.println(Arrays.toString(printKLeargest(Arr,5)));
    }
}