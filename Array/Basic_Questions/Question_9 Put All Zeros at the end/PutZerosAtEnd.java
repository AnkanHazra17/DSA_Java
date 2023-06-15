

import java.util.Arrays;

public class PutZerosAtEnd{

    static void zerosAtEnd(int[] arr){
        int n = arr.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] != 0){
                arr[count] = arr[i];
                count++;
            }
        }

        while(count < n){
            arr[count] = 0;
            count++;
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 0, 4, 0, 2, 5, 0, 0, 5, 0};
        zerosAtEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}