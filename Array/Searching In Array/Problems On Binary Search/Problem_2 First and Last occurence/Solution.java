
// Question: Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in non-decreasing order,
// find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

// Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/




import java.util.Arrays;

public class Solution{

    // Binary search to check if target is present in the sorted array
    static boolean isPresent(int[] arr, int target){
        int n = arr.length;
        int start = 0; 
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > target){
                end = mid - 1;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
            else{
                return true;
            }
        }

        return false;
    }

    static int findLowerBound(int[] arr, int target){
        if(!isPresent(arr, target)){
            return -1;
        }

        int n = arr.length;
        int start = 0; 
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > target - 1){
                end = mid - 1;
            }
            else if(arr[mid] < target - 1){
                start = mid + 1;
            }
            else{
                return mid + 1;
            }
        }

        return end + 1;
    }

    static int findUpperBound(int[] arr, int target){
        if(!isPresent(arr, target)){
            return -1;
        }

        int n = arr.length;
        int start = 0; 
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > target + 1){
                end = mid - 1;
            }
            else if(arr[mid] < target + 1){
                start = mid + 1;
            }
            else{
                return mid - 1;
            }
        }

        return start - 1;
    }

    static int[] findFirstLastOccurence(int[] arr, int target){
        int first = findLowerBound(arr, target);
        int second = findUpperBound(arr, target);

        if(first != -1){
            while (arr[first] != target){
                first++;
            }

            while (arr[second] != target){
                second--;
            }
        }

        return new int[] {first, second};
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,2,3,3,3};
        System.out.println(Arrays.toString(findFirstLastOccurence(arr, 2)));
    }
}