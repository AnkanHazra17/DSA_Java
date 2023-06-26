

import java.util.Arrays;

public class FirstAndLastPosition{

    static int findTarget(int[] arr, int target){

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


    // Find the index of the first occurrence of the target value in the array
    static int firstOccurence(int[] arr, int target){
        int n = arr.length;

        if(n < 1){    // Check for an empty array
            return -1;
        }

        if(n == 1){    // Check for an array with a single element
            if(arr[0] == target){
                return 0;
            }
            return -1;
        }

        if(arr[0] == target){  // Check if the target is at the first index
            return 0;
        }

        int targetInd = findTarget(arr,target);   // Find the index of the target value

        if(targetInd == -1){     // If the target value is not present in the array, return -1
            return -1;
        }

        // Iterate backwards from the target index to find the first occurrence
        for(int fistInd = targetInd; fistInd >= 0; fistInd--){
            if(arr[fistInd] != target){
                return fistInd + 1;
            }
        }

        return -1;  // If the target value is not found, return -1
    }


    // Find the index of the last occurrence of the target value in the array
    static int secondOccurence(int[] arr, int target){
        int n = arr.length;

        if(n < 1){     // Check for an empty array
            return -1;
        }

        if(n == 1){    // Check for an array with a single element
            if(arr[0] == target){
                return 0;
            }
            return -1;
        }

        if(arr[n - 1] == target){  // Check if the target is at the last index
            return n - 1;
        }

        int targetInd = findTarget(arr,target);  // Find the index of the target value

        if(targetInd == -1){     // If the target value is not present in the array, return -1
            return -1;   
        }


        // Iterate forwords from the target index to find the first occurrence
        for(int secInd = targetInd; secInd <= n - 1; secInd++){
            if(arr[secInd] != target){
                return secInd - 1;
            }
        }

        return -1;
    }

    static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};
        int first = firstOccurence(nums,target);
        int last = secondOccurence(nums,target);

        ans[0] = first;
        ans[1] = last;

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {2,2};
        System.out.println(Arrays.toString(searchRange(arr,2)));
    }
}