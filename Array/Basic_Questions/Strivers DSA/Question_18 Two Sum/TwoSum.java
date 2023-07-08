//Question: Two Sum
// Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.


import java.util.Arrays;


public class TwoSum{

    static int[] twoSum(int[] nums, int target){
        int n = nums.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
}

