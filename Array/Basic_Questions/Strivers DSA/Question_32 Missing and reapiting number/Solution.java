import java.util.Arrays;

public class Solution{

    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int[] findMissingRepeatingNumbers(int []a) {
        int n = a.length;
        int i = 0;

        while(i < n){
            int correctInd = a[i] - 1;

            if(a[i] != a[correctInd]){
                swap(a, i, correctInd);
            }
            else{
                i++;
            }
        }

        for(int j = 0; j < n; j++){
            if(a[j] != j + 1){
                return new int[] {a[j], j + 1};
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 2};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }
}