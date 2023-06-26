
// Question:
// You have a set of integers s, which originally contains all the numbers from 1 to n. 
// Unfortunately, due to some error, one of the numbers in s got duplicated to another 
// number in the set, which results in repetition of one number and loss of another number.

// You are given an integer array nums representing the data status of this set after the error.

// Find the number that occurs twice and the number that is missing and return them in the form of an array.

// Example:
// Input: nums = [1,2,2,4]
// Output: [2,3]


import java.util.Arrays;

public class SetMismatch{

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp; 
    }

    static int[] findErrorNums(int[] arr){
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

        for(int ind = 0; ind < n; ind++){
            if(arr[ind] != ind + 1){
                return new int[] {arr[ind], ind + 1};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args){
        int[] arr = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }
}