
// Question: Single Element in a Sorted Array

// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.


// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10



public class Solution{

    // Function to find the single non-duplicate element in a sorted array
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // corner cases

        // Handle the case when the array has only one element
        if(n == 1){
            return nums[0];
        }

        // Check if the first element is unique
        if(nums[0] != nums[1]){
            return nums[0];
        }

        // Check if the last element is unique
        if(nums[n - 1] != nums[n - 2]){
            return nums[n - 1];
        }

        // Initialize pointers for binary search
        int start = 1;
        int end = n - 2;

        // Perform binary search
        while(start <= end){
            int mid = start + (end - start) / 2;  // Calculate the middle index

            // Check if the middle element is unique by comparing with adjacent elements
            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]){
                return nums[mid];
            }

            // Adjust pointers based on whether mid is in an even or odd position and whether the duplicate is on the left or right
            else if(mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid - 1]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        // Return -1 if no unique element is found
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(arr));
    }
}

