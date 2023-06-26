

public class SearchInRotatedSortedArray{


    // Function to find the index of the pivot element in the rotated sorted array
    static int findPivot(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            // Check if the middle element is the pivot
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }

            // Check if the middle - 1 element is the pivot
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }

            if(arr[mid] < arr[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }


    // Function to perform binary search in a sorted subarray
    static int searchBS(int[] arr, int target, int start, int end){

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

    // Function to search for a target value in the rotated sorted array
    static int searchItem(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int pivot = findPivot(nums);

        if(pivot == -1){   // No rotation, perform binary search on the whole array
            return searchBS(nums,target,start,end);
        }

        if(nums[pivot] == target){  // If the pivot is the target value, return the pivot index
            return pivot;
        }

        // If the target is in the left half (before the pivot), perform binary search in that range
        if(nums[start] <= target){
            return searchBS(nums,target,start,pivot - 1);
        }
        else{
            // If the target is in the right half (after the pivot), perform binary search in that range
            return searchBS(nums,target,pivot + 1,end);
        }
        
    }

    public static void main(String[] args){
        int[] arr = {3, 5, 1};
        System.out.println(searchItem(arr,3));
        System.out.println(findPivot(arr));

    }
}