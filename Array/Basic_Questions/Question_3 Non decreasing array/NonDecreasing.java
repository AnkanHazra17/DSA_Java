

public class NonDecreasing{

    // Method to check if an array is in non-decreasing order
    static boolean isDecreasing(int[] nums){
        int n = nums.length;
        for(int i = 0; i <= n - 2; i++){
            if(nums[i] > nums[i + 1]){
                return false;  // If any adjacent elements are out of order, return false
            }
            
        }
        return true;  // All elements are in non-decreasing order, return true
    }


    // Method to check if the array can be made non-decreasing by modifying at most one element
    static boolean check(int[] nums){
        int count = 0;   // Counter to keep track of the number of modifications made
        int n = nums.length;

        for(int i = 0; i < n - 2; i++){

            if(nums[n - 2] > nums[n - 1]){
                nums[n - 2] = nums[n - 1];  // If the last two elements are out of order, make them equal
                count++;  // Increment the modification counter
            }


            if(nums[i] > nums[i + 1]){
                if(nums[i] <= nums[i + 2]){
                    nums[i + 1] = nums[i];   // If the current element is greater than the next element but less than or equal to the element after that, make the next element equal to the current element
                    count++;  // Increment the modification counter
                    break;  // No need to continue checking, modification has been made
                }

                if(nums[i] >= nums[i + 2]){
                    nums[i] = nums[i + 1];  // If the current element is greater than the next element and greater than the element after that, make the current element equal to the next element
                    count++;  // Increment the modification counter
                }
            }
        }
        if(count <= 1 && isDecreasing(nums)){
            return true;  // If at most one modification has been made and the array is in non-decreasing order, return true
        }
        return false;  // Otherwise, return false
    }

    public static void main(String[] args){
        int[] nums = {1, 3, 2, 3, 3};
        System.out.println(check(nums));

    }
}