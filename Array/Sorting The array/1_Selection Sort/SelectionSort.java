

import java.util.Arrays;

public class SelectionSort{

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int findMin(int[] arr, int start, int end){
        int min = start;
        for(int i = start; i < end; i++){
            if(arr[min] > arr[i]){
                min = i;
            }
        }
        return min;
    }

    static void sortArray(int[] arr){
        int n = arr.length;
        
        for(int i = 0; i < n -1; i++){
            int min = i;
            int minInd = findMin(arr,i + 1,n);

            if(arr[min] > arr[minInd]) {
                swap(arr, min, minInd);
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {9, 5, 2, 7, 1};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}