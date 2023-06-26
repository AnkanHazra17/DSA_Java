

import java.util.Arrays;

public class CycleSort{

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    } 

    static void sortArray(int[] arr){
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
    }

    public static void main(String[] args){
        int[] arr = {4, 1, 5, 3, 2};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}