
// Question: Given an integer array nums sorted in non-decreasing order,
//  remove the duplicates in-place such that each unique element appears only 
//  once. The relative order of the elements should be kept the same. Then return
//  the number of unique elements in nums.

//       Consider the number of unique elements of nums to be k, to get accepted,
//  you need to do the following things:

//      * Change the array nums such that the first k elements of nums contain the
//  unique elements in the order they were present in nums initially. The 
//  remaining elements of nums are not important as well as the size of nums.
//  * Return k.

public class RemoveDuplicates{

    // Method to remove duplicates from an array
    static int remove_duplicate(int[] nums){

        int i = 0;  // Initialize a variable to keep track of the last non-duplicate element

        // Iterate over the array from the second element to the last element
        for(int j = 1; j < nums.length; j++){

            // Check if the current element is different from the element at index i
            if(nums[i] != nums[j]){

                // If a non-duplicate element is found, shift it to the next position in the array
                nums[i + 1] = nums[j];
                i++; // Increment i to keep track of the last non-duplicate element
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(remove_duplicate(arr));
    }
}