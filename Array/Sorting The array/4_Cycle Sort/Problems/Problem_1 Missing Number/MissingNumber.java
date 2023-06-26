
// Question: 
// Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.

// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the 
// range [0,3]. 2 is the missing number in the range since it does not appear in nums.


public class MissingNumber{


    // Swaps the elements at the given indices in the array
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    // Finds the missing number in the array
    static int findMissingNumber(int [] arr){
        int n = arr.length;
        int i = 0;

        while(i < n){
            int correctInd = arr[i]; // find the correct index

            // If the current element is within the range and not at the correct index,
            // swap it to its correct position
            if((arr[i] < n) && arr[i] != arr[correctInd]){
                swap(arr, i, correctInd);
            }
            else{
                i++;
            }
        }

        // Iterate over the array and find the first index that does not match the element
        // at that index, which indicates the missing number
        for(int j = 0; j < n; j++){
            if(j != arr[j]){
                return j;
            }
        }  

        // If no missing number is found, return n (the next expected number)
        return n;  
    }

    public static void main(String[] args){
        int[] arr = {3, 0, 1};
        System.out.println(findMissingNumber(arr));
    }
}