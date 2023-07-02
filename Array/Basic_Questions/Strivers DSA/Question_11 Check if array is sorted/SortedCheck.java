
// Question: Check if array is sorted
// Given an array nums, return true if the array was originally sorted in non-decreasing order,
// then rotated some number of positions (including zero). Otherwise, return false.

// There may be duplicates in the original array.

public class SortedCheck {

    // Method to check if an array is sorted in non-decreasing order
    static boolean arraySortedOrNot(int[] nums) {

        int n = nums.length;  // Obtain the length of the input array

        // Check if the first element is greater than or equal to the last element
        // This is for t handel the Rotated sorted array
        if (nums[0] >= nums[n - 1]) {

            // Iterate from the first element to the second-to-last element
            for(int i = 0; i < n - 1; i++){

                // Check if the current element is greater than the next element
                if(nums[i] > nums[i + 1]){

                    // Iterate from the element next to the current index to the second-to-last element
                    for(int j = i + 1; j < n - 1; j++){

                        // Check if there is a further descending sequence
                        if(nums[j] > nums[j + 1]){
                            return false;  // Array is not sorted, return false
                        }
                    }
                }
            }
        } 

        else {
            // Iterate from the first element to the second-to-last element
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {  // Check if the current element is greater than the next element
                    return false;  // Array is not sorted, return false
                }
            }
        }
        return true;  // Array is sorted, return true
    }

    public static void main(String[] args) {
        int[] nums = {2,7,4,1,2,6,2};
        // int n = arr.length;
        System.out.println(arraySortedOrNot(nums));
    }
}