

// Question:
// Given an unsorted integer array nums, return the smallest missing positive integer.

// Example:
// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.

public class FirstMissingPositive{

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int find(int[] arr){
        int n = arr.length;
        int i = 0;

        while(i < n){
            int correctInd = arr[i] - 1;

            if(arr[i] > 0 && arr[i] <=n && arr[i] != arr[correctInd]){
                swap(arr, i, correctInd);
            }
            else{
                i++;
            }
        }

        for(int ind = 0; ind < n; ind++){
            if(arr[ind] != ind + 1){
                return ind + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args){
        int[] arr = {7,8,9,11,12};
        System.out.println(find(arr));
    }
}