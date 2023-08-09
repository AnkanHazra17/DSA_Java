// Question: Search Insert Position

// You are given a sorted array "arr" of distinct value and a target value "m". The task is to 
// find the insert position of the target value

public class Solution{

    public static int searchInsert(int [] arr, int m){
        int n = arr.length;
        int start = 0; 
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > m){
                end = mid - 1;
            }
            else if(arr[mid] < m){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }

        return start; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        System.out.println(searchInsert(arr, 0));
    }
}