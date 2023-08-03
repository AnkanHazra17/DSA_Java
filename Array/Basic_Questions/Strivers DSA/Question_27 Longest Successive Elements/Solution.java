
// Question: Longest Successive Elements
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.



import java.util.Arrays;

public class Solution{

    // This method takes an array of integers 'a' as input and returns the length of the longest sequence of consecutive elements in the array.
    public static int longestSuccessiveElements(int []a) {

        int n = a.length;  // Get the length of the input array 'a'.
        int len = 0;       //to keep track of the current length of the consecutive sequence ('len')
        int maxLen = 0;    // the maximum length of consecutive sequence found so far ('maxLen')
        int lastSmaller = Integer.MIN_VALUE;   // to keep track of the last smaller element found ('lastSmaller').

        // Sort the input array in ascending order. This is required to group consecutive elements together.
        Arrays.sort(a);

        // Iterate through the sorted array 'a' to find the longest consecutive sequence.
        for(int i = 0; i < n; i++){

            // Check if the current element 'a[i]' is exactly one less than the 'lastSmaller' element.
            // This means 'a[i]' is part of the current consecutive sequence.
            if(a[i] -1 == lastSmaller){
                len++;                  // Increment the 'len' variable as we found a consecutive element.
                lastSmaller = a[i];     // Update 'lastSmaller' to the current element 'a[i]' for the next iteration.
            }
            // If the current element 'a[i]' is not one less than 'lastSmaller', it means the current sequence is broken.
            else if(lastSmaller != a[i]){
                len = 1;              // Reset 'len' to 1 as the current element can be the start of a new consecutive sequence.
                lastSmaller = a[i];   // Update 'lastSmaller' to the current element 'a[i]' for the next iteration.
            }
            
            // Update 'maxLen' to store the maximum length found so far, either the current 'len' or the previous 'maxLen'.
            maxLen = Math.max(len, maxLen);
        }

        // Return the maximum length of the consecutive sequence found in the array.
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr ={1, 2, 2, 1};
        System.out.println(longestSuccessiveElements(arr));
    }
}