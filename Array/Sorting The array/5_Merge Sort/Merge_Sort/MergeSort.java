


import java.util.Arrays;

public class MergeSort{

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

    static int[] arraySort(int[] arr){
        // Base case: If the array has only one element, it is already sorted
        if(arr.length == 1){
            return arr;
        } 

        // Find the middle index of the array
        int mid = arr.length / 2;

        // Recursively sort the left half of the array
        int[] left = arraySort(Arrays.copyOfRange(arr, 0, mid)); 

        // Recursively sort the right half of the array
        int[] right = arraySort(Arrays.copyOfRange(arr, mid, arr.length));

        // Merge the sorted left and right halves of the array
        return arrayMerge(left, right);
    }

    public static void main(String[] args){
        int[] arr = {2, 5, 9, 3};
        arr = arraySort(arr);
        System.out.println(Arrays.toString(arr));

    }
}