
// Question: Koko Eating Bananas

//Problem link: https://leetcode.com/problems/koko-eating-bananas/description/


public class Solution{

    static int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        return maxi;
    }


    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }

    public static int minEatingSpeed(int[] piles, int h){
        int start = 1;
        int end = findMax(piles);

        while(start <= end){
            int mid = start + (end - start) / 2;

            int totalHor = calculateTotalHours(piles, mid);

            if(totalHor <= h){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(arr, 8));
    }
}

