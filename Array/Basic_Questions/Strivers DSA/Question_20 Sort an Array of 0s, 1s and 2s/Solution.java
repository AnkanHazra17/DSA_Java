import java.util.ArrayList;
import java.util.Arrays;

public class Solution{

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // code for array 
    static void sort(int[] nums){
        int n = nums.length;

        int low = 0; 
        int high = n - 1;
        int i = 0;

        while(i <= high){
            if(nums[i] == 0){
                swap(nums, i, low);
                low++;
                i++;
            }
            else if(nums[i] == 2){
                swap(nums, i, high);
                high--;
            }
            else{
                i++;
            }

            
        }

    }

    public static void sortArray(ArrayList<Integer> arr, int n) {
        int low = 0; 
        int high = n - 1;
        int i = 0;

        while(i <= high){
            if(arr.get(i) == 0){
                int temp = arr.get(i);
                arr.set(low, arr.get(i));
                arr.set(i, temp);
                low++;
                i++;
            }
            else if(arr.get(i) == 2){
                int temp = arr.get(i);
                arr.set(i, arr.get(high));
                arr.set(high,temp);
                high--;
            }
            else{
                i++;
            }

        }
    }

    


    public static void main(String[] args) {
        // int[] a = {1,2,0};
        // sort(a);
        // System.out.println(Arrays.toString(a));

        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        sortArray(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}