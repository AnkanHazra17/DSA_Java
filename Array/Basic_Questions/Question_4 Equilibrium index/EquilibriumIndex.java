
// Question: Given an array find the Equilibrium index of the array 


public class EquilibriumIndex{

    static int arraySum(int[] arr, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        return sum;
    }

    static int findequilibrium(int[] arr){
        int n = arr.length;
        int total = arraySum(arr,n);

        if (n <= 2){
            return -1;
        }

        int left_sum = 0;
        for(int i = 1; i < n; i++){
            left_sum += arr[i - 1];
            int right_sum = total - left_sum - arr[i];

            if(left_sum == right_sum){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int [] arr = {1, 2, 0, 3};
        System.out.println(findequilibrium(arr));
    }
}