import java.util.ArrayList;
import java.util.List;

public class Solution{

    // Method to find majority elements in the array
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0;    // Counter for the first potential majority element
        int cnt2 = 0;    // Counter for the second potential majority element

        int ele1 = Integer.MIN_VALUE;    // First potential majority element
        int ele2 = Integer.MIN_VALUE;    // Second potential majority element

        // Loop through the array to find the two potential majority elements
        for(int i = 0; i < n; i++){

            // The condition ele2 != nums[i] checks whether the current element nums[i] is different from the second potential majority element (ele2).
            if(cnt1 == 0 && ele2 != nums[i]){
                ele1 = nums[i];    // Set ele1 to the current element
                cnt1 = 1;          // Start counting ele1 occurrences
            }

            // The condition ele1 != nums[i] checks whether the current element nums[i] is different from the first potential majority element (ele1).
            else if(cnt2 == 0 && ele1 != nums[i]){
                ele2 = nums[i];    // Set ele2 to the current element
                cnt2 = 1;          // Start counting ele2 occurrences
            }
            else if(ele1 == nums[i]){
                cnt1++;        // Increment the count of ele1 occurrences              
            }
            else if(ele2 == nums[i]){
                cnt2++;        // Increment the count of ele2 occurrences
            }
            else{
                cnt1--;      // Decrease both counters if the current element is neither ele1 nor ele2
                cnt2--;
            }
        }

        int cont1 = 0;      // Count for the first potential majority element
        int cont2 = 0;      // Count for the second potential majority element

        // List to store the majority elements
        List<Integer> ans = new ArrayList<>();

        // Loop through the array to count the occurrences of ele1 and ele2
        for(int i = 0; i < n; i++){
            if(ele1 == nums[i]){
                cont1++;   // Increment the count for ele1
            }
            if(ele2 == nums[i]){
                cont2++;   // Increment the count for ele2
            }
        }

        // Check if either ele1 or ele2 is a majority element and add them to the answer list
        if(cont1 > n/3){
            ans.add(ele1);
        }
        if(cont2 > n/3){
            ans.add(ele2);
        }

        // If no majority elements are found, add -1 to the list
        if(ans.size() == 0){
            ans.add(-1);
        }

        return ans;  // Return the list containing the majority elements or -1
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 7, 8, 2, 4, 4, 2, 4, 6, 4, 1, 7, 8, 6, 9, 3, 5, 6, 9, 3, 2, 7, 6, 3, 6, 3, 5, 3, 7, 2, 1, 5, 6, 6, 6, 7, 9, 6, 2, 3, 9, 2, 8, 5, 7, 7, 5, 9, 1};
        System.out.println(majorityElement(arr));
    }
}