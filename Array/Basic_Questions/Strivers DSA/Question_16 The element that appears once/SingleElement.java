
// Question: Single number:
// Given a non-empty array of integers nums, every element
// appears twice except for one. Find that single one.

public class SingleElement{
    
    // Method to find a single element that appears only once in the array
    static int findsingle(int[] nums){

        int xor = 0;  // Variable to store XOR result

        // XOR operation on all elements in the array
        for(int i = 0; i < nums.length; i++){
            xor = xor ^ nums[i];  // XOR operation between current element and xor
        }

        return xor;  // Return the single element that appears only once
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(findsingle(arr));
    }
}