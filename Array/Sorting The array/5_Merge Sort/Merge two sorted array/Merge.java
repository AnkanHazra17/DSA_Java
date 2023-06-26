

import java.util.Arrays;

public class Merge{

    static int[] arrayMerge(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int p = (n + m);

        int[] arr3 = new int[p];
        int i = 0;
        int j = 0;
        int k = 0;

        while(k < p){
            if(i > n - 1){
                arr3[k] = arr2[j];
                j++;
                k++;
            }

            if(j > m - 1){
                arr3[k] = arr1[i];
                i++;
                k++;
            }

            if(arr1[i] <= arr2[j]){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        return arr3;
    }

    public static void main(String[] args){
        int[] arr1 = {2, 5, 9, 11, 12};
        int[] arr2 = {1, 3, 7, 13};

        System.out.println(Arrays.toString(arrayMerge(arr1, arr2)));
    }
}