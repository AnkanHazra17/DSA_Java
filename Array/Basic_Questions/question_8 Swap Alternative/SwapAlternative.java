

// Question: Given an array of length N, the task is to swap every pair of alternate element in the array

import java.util.Arrays;

public class SwapAlternative{

    static void swapAlternate(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n - 1; i += 2){
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args){
        int arr[] = {9, 3, 6, 12, 4};
        swapAlternate(arr);
        System.out.println(Arrays.toString(arr));
    }
}