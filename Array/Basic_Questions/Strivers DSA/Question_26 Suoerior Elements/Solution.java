// Question: Leaders in an array

// Given an array A of positive integers. Your task is to find the leaders in the array.
// An element of array is leader if it is greater than or equal to all the elements to its
// right side. The rightmost element is always a leader. 

// Example:
// n = 6
// A[] = {16,17,4,3,5,2}
// Output: 17 5 2

// Explanation: The first leader is 17 
// as it is greater than all the elements
// to its right.  Similarly, the next 
// leader is 5. The right most element 
// is always a leader so it is also 
// included.



import java.util.ArrayList;
import java.util.Collections;

public class Solution{

    public static ArrayList<Integer> superiorElements(int []a) {
        
        ArrayList<Integer> ans = new ArrayList<>();  // create an empty list to store the superior elements
        int n = a.length;   // get the length of the input array
        
        ans.add(a[n - 1]);    // add the last element of the array to the list, as it is always superior
        int maxi = a[n - 1];  // keep track of the maximum element seen so far, starting from the last element

        // loop through the array from right to left, excluding the last element
        for(int i = n - 2; i >= 0; i--){

            if(a[i] >= maxi){     // if the current element is greater than or equal to the maximum seen so far
                ans.add(a[i]);  // add it to the list
                maxi = a[i];    // update the maximum seen so far
            }
        }

        // Collections.sort(ans);
        Collections.reverse(ans);   // reverse the list to get the superior elements in order
        return ans;  // return the list
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0};
        System.out.println(superiorElements(arr));
    }
}