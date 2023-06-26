

import java.util.Arrays;

public class Bubblesort{

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void sortArray(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {5, 4, 3, 2, 1, -2, 0};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}