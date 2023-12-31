

public class BinarySearch{


    // Method to perform binary search on a sorted array
    static int searchBS(int[] arr, int target){
        int n = arr.length;   // Length of the array
        int start = 0;   // Start index of the search range
        int end = n - 1;    // End index of the search range
        

        while(start <= end){
            int mid = start + (end - start) / 2;  // Calculate the middle index

            if(arr[mid] == target){   // If the middle element is equal to the value, return the index
                return mid;
            }

            // If the middle element is greater than the value, search in the left half
            if(arr[mid] > target){
                end = mid - 1;
            }

            // If the middle element is smaller than the value, search in the right half
            if(arr[mid] < target){
                start = mid + 1;
            }

        }
        return -1;  // If the value is not found, return -1
    }

    public static void main(String[] args){
        int[] arr = {};
        System.out.println(searchBS(arr,2));
    }
}