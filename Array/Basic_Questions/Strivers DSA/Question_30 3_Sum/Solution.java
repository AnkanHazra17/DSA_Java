import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    
    // Function to find all unique triplets in the input array that sum up to zero.
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();   // List to store the result of triplets.
        int n = nums.length;    // Get the length of the input array.

        Arrays.sort(nums);     // Sort the input array in ascending order. This is necessary for the two-pointer approach.

        for(int i = 0; i < n; i++){

            // Skip duplicate elements to avoid duplicate triplets.
            // If the current element is the same as the previous element, skip to the next element.
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // Initialize two pointers j and k.
            int j = i + 1;     // j points to the next element after nums[i].
            int k = n - 1;     // k points to the last element of the array.

            // Use a two-pointer approach to find triplets.
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];  // Calculate the sum of the current triplet.

                if(sum < 0){       // If the sum is less than zero, move the j pointer to the right to increase the sum.
                    j++;
                }
                else if(sum > 0){  // If the sum is greater than zero, move the k pointer to the left to decrease the sum.
                    k--;
                }
                else{
                    // If the sum is zero, we found a triplet that sums up to zero.

                    // Add the triplet to the ans list.
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);

                    // Move both j and k pointers to find other possible triplets.
                    j++;
                    k--;

                    // Skip any duplicate elements to avoid duplicate triplets.
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }
            }
        }

        return ans;   // Return the list of triplets that sum up to zero.
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0,0,0,0,0,0};
        System.out.println(threeSum(arr));
    }
}