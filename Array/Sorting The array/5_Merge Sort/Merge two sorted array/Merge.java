

import java.util.Arrays;

public class Merge{

    // Method to merge two sorted arrays into a single sorted array
    static int[] arrayMerge(int[] first, int[] second){

        // Create a new array to store the merged result
        int[] ans = new int[first.length + second.length];
        int i = 0;  // Index for the first array
        int j = 0;  // Index for the second array
        int k = 0;  // Index for the marged array

        // Compare elements from both arrays and merge them in sorted order
        while(i < first.length && j< second.length){

            // Store the smaller element from the first array in the merged array
            if(first[i] < second[j]){
                ans[k] = first[i];
                i++;  // Move to the next element in the first array
            }
            else{
                // Store the smaller element from the second array in the merged array
                ans[k] = second[j];
                j++;  // Move to the next element in the second array
            }
            k++;
        }

        // Copy remaining elements from the first array, if any
        while(i < first.length){
            ans[k] = first[i];
            i++;
            k++;
        }

        // Copy remaining elements from the second array, if any
        while(j < second.length){
            ans[k] = second[j];
            j++;
            k++;
        }

        return ans;  // Return the merged array
    }

    public static void main(String[] args){
        int[] arr1 = {2, 5, 9, 11, 12};
        int[] arr2 = {1, 3, 7, 13};

        System.out.println(Arrays.toString(arrayMerge(arr1, arr2)));
    }
}