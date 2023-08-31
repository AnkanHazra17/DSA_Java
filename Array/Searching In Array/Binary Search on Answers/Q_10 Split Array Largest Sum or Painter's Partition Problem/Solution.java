
// Question: Split Array Largest Sum
// Problem link: https://leetcode.com/problems/split-array-largest-sum/description/


public class Solution{

    public static int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        return maxi;
    }

    public static int arraySum(int[] arr){
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        return sum;
    }

    public static int numOfSubArr(int[] arr, int minVal){
        int cnt = 1;
        int subArrSum = 0;

        for(int i = 0; i < arr.length; i++){
            if(subArrSum + arr[i] <= minVal){
                subArrSum = subArrSum + arr[i];
            }
            else{
                cnt++;
                subArrSum = arr[i];
            }
        }

        return cnt;
    }

    public static int splitArray(int[] nums, int k) {
        int low = findMax(nums);
        int high = arraySum(nums); 

        while(low <= high){
            int mid = low + (high - low) / 2;
            int subArrCnt = numOfSubArr(nums, mid);

            if(subArrCnt > k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        System.out.println(splitArray(arr, 2));
    }
}