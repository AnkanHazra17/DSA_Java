

public class ConsicutiveOne{

    // Method to find the maximum number of consecutive ones
    static int maxConsicutiveOne(int[]  nums){
        int n = nums.length;
        int count = 0; // Initialize count to keep track of the current number of consecutive ones
        int max = 0;  // Initialize max to keep track of the maximum number of consecutive ones

        for(int i = 0; i < n; i++){  // Iterate through the array
            if(nums[i] == 1){
                count++;  // Increment the count if the current element is 1
                max = Math.max(max, count);  // Update the max value if count is greater than max
            }
            else{
                count = 0; // Reset the count to 0 if the current element is not 1   

            }
        }
        return max;  // Return the maximum number of consecutive ones
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        System.out.println(maxConsicutiveOne(arr));
    }
}