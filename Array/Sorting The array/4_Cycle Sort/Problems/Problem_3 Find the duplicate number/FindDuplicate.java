
// Question:
// Given an array of integers nums containing n + 1 integers where each
// integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.

// Example:
// Input: nums = [1,3,4,2,2]
// Output: 2


public class FindDuplicate{

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    } 

    static int findDuplicate(int[] arr){
        int n = arr.length;
        int i = 0;

        while(i < n){
            int correctInd = arr[i] - 1;

            if(arr[i] != arr[correctInd]){
                swap(arr, i, correctInd);
            }
            else{
                i++;
            }
        }

        for(int index = 0; index < n; index++){
            if(arr[index] != index + 1){
                return arr[index];
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2};
        System.out.println(findDuplicate(arr));
    }
}