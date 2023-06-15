
// Question: Given an array find the Equilibrium index of the array 


public class EquilibriumIndex{


    // Method to calculate the sum of all elements in the array
    static int arraySum(int[] arr, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        return sum;
    }


    // Method to find the equilibrium index in the array
    static int findequilibrium(int[] arr){
        int n = arr.length;
        int total = arraySum(arr,n);

        // If the array length is less than or equal to 2, return -1
        if (n <= 2){
            return -1;
        }

        int left_sum = 0;
        for(int i = 1; i < n; i++){

            // Calculate the left sum
            left_sum += arr[i - 1];

            // Calculate the right sum by subtracting the total sum, left sum, and current element
            int right_sum = total - left_sum - arr[i];

            // If left sum is equal to right sum, return the current index i as equilibrium index
            if(left_sum == right_sum){
                return i;
            }
        }
        return -1;  // If no equilibrium index is found, return -1
    }
    public static void main(String[] args){
        int [] arr = {1, 2, 0, 3};
        System.out.println(findequilibrium(arr));
    }
}