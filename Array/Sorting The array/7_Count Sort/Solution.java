
// Count Sort


import java.util.Arrays;

public class Solution{

    // Function to perform Counting Sort on an array
    public static void countSort(int[] arr){

        // Step 1: Find the maximum value in the array
        int maxi = 0;
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        // Step 2: Create an array to store the count of each element
        int[] count = new int[maxi + 1];

        // Step 3: Count the occurrences of each element in the input array
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }

        // Step 4: Reconstruct the sorted array using the count array
        int j = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] != 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1000, 2000, 1500, 3000, 2500};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

