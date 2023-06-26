
// Question:
// Given an array nums of n integers where nums[i] is in the range [1, n],
// return an array of all the integers in the range [1, n] that do not appear in nums.

// Example
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]


import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumber{

    // Swaps the elements at the given indices in the array
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    } 

    // Finds the disappeared numbers in the array
    static List<Integer> findDisappearedNumbers(int[] arr){
        int n = arr.length;
        int i = 0;

        while(i < n){
            int correctInd = arr[i] - 1;  // Calculate correct position

            // If the current element is not at its correct position,
            // swap it to its correct position
            if(arr[i] != arr[correctInd]){
                swap(arr, i, correctInd);
            }
            else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Iterate over the array and find the numbers that are missing
        // by checking if the element at index is equal to index + 1
        for(int index = 0; index < n; index++){
            if(arr[index] != index + 1){
                ans.add(index + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
}