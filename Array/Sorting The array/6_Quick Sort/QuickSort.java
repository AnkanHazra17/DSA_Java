


import java.util.Arrays;

public class QuickSort{

    // Method to swap two elements in an array
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Method to find the correct position of the pivot element
    static int findPivot(int[] arr, int start, int end){

        int pivot = arr[start];   // Select the pivot element as the first element
        int count = 0;    // Count the number of elements less than or equal to the pivot


        // Iterate through the array from start + 1 to end
        for(int i = start + 1; i <= end; i++){
            if(arr[i] <= pivot){
                count++;   // Increment the count if the current element is less than or equal to the pivot
            }
        }

        int correctInd = start + count;  // Calculate the correct position of the pivot

        // Swap the pivot element with the element at the correct position
        swap(arr, start, correctInd);

        // Take i and j pointer pointing start and end
        int i = start;
        int j = end;

        // Rearrange the elements such that elements less than or equal to the pivot are on the left side,
        // and elements greater than the pivot are on the right side
        while(i < correctInd && j > correctInd){
            while(arr[i] <= pivot && i < correctInd){
                i++;   // Increment i until an element greater than the pivot is found or i reaches correctInd
            }

            while(arr[j] > pivot && j > correctInd){
                j--;   // Decrement j until an element less than or equal to the pivot is found or j reaches correctInd
            }

            swap(arr, i, j); // Swap elements to move them to the correct side
        }

        return correctInd;  // Return the correct position of the pivot
    }

    // Recursive method to perform QuickSort
    static void quickSort(int[] arr, int start, int end){

        // Base case: if start >= end, there is nothing to sort
        if(start >= end){
            return;
        }

        // Find the correct position of the pivot
        int pivotInd = findPivot(arr, start, end);

        // Recursively call quickSort for the left and right subarrays
        quickSort(arr, start, pivotInd - 1);
        quickSort(arr, pivotInd + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 3, 2, 11, 7};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sorting the array using Quick sort");
        System.out.println(Arrays.toString(arr));
    }
}


