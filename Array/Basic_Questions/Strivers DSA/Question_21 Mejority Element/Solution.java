
// Question: Majority Element
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.

public class Solution{

    // Function to find the majority element in an array
    static int findMejorityEle(int[] nums){
        int n = nums.length;  // Get the length of the array
        int cnt = 0;  // Counter for tracking the count of potential majority element
        int ele = 0;  // Variable to store the potential majority element

        for(int i = 0; i < n; i++){

            if(cnt == 0){    // If the count is 0, update the potential majority element and count
                ele = nums[i];
                cnt = 1;
            }
            else if(ele == nums[i]){ // If the count is 0, update the potential majority element and count
                cnt++;
            }
            else{    // If the current element is different, decrement the count
                cnt--;
            }
        }

        int cnt1 = 0;  // Counter for tracking the actual count of the potential majority element
        for(int i = 0; i < n; i++){
            if(ele == nums[i]){  // Count the occurrences of the potential majority element
                cnt1++;
            }
        }

        if(cnt1 > n / 2){ // If the count is greater than n/2, it is the majority element
            return ele;
        }

        return -1;  // If there is no majority element, return -1
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(findMejorityEle(arr));
    }
}