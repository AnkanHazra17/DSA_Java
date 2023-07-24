
// Qusetion: Rearrange Array Elements by Sign

// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

// You should rearrange the elements of nums such that the modified array follows the given conditions:

// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.



import java.util.ArrayList;
import java.util.Arrays;



public class Solution{

    // Function to swap two elements in an array
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Method to rearrange the array elements such that positive elements are followed by negative elements
    // In this code order is not maintained, its t.c. = 0(n) s.c. = 0(1)
    static int[] reArrangeArray(int[] nums){   
        
        for(int i = 0; i < nums.length; i++){
            int j = i;

            // If the current index is even, find the first positive number starting from this index
            if(i % 2 == 0){
                while(nums[j] < 0){
                    j++;
                }
                swap(nums, i, j);  // Swap the positive number (if found) with the current element at index 'i'
            }

            // If the current index is odd, find the first negative number starting from this index
            else{
                while(nums[j] > 0){
                    j++;
                }
                swap(nums, i, j);  // Swap the negative number (if found) with the current element at index 'i'
            }
        }

        return nums;
    }


    // Other Method . T.C = 0(n) S.C = 0(n)
    // Method to rearrange the array elements such that positive elements are followed by negative elements
    static int[] re_arrangeArray(int[] nums){

        // Create two ArrayLists to store positive and negative elements temporarily
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Iterate through the input array, categorizing elements into the 'pos' and 'neg' ArrayLists
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }

        // Reconstruct the array by interleaving the elements from 'pos' and 'neg' ArrayLists
        for(int i = 0; i < nums.length/2; i++){
            nums[2*i] = pos.get(i);  // Place positive element at even indices
            nums[2*i+1] = neg.get(i);  // Place negative element at odd indices
        }
        
        return nums;
    }


    public static void main(String[] args) {
        int[] arr = {28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31};
        System.out.println(Arrays.toString(re_arrangeArray(arr)));
    }
}