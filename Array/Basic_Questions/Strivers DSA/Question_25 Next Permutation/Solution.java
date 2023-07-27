
// Question: Next Permutation

// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the
// permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array 
// is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the 
// lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.


import java.util.ArrayList;
import java.util.Collections;
// import java.util.Arrays;
import java.util.List;


public class Solution{

    // Function to swap two elements in an array
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Function to reverse a portion of the array from 'start' to 'end'
    static void reverseArr(int[] arr, int start, int end){
        while(start <= end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Function to find the next permutation of the given array 'nums'
    static List<Integer> nextPermutation(int[] nums){
        int n = nums.length;
        int ind = -1;

        // Step 1: Find the index 'ind' where the array has a decreasing sequence from right to left
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                ind = i;
                break;
            }
        }

        // Step 2: If no decreasing sequence found, the array is in decreasing order; reverse it to get the smallest permutation
        if(ind == -1){
            reverseArr(nums,0,n - 1);
        }
        else{  // Step 3: If a decreasing sequence is found
            for(int i = n - 1; i >= 0; i--){   // Step 4: Find the rightmost element greater than nums[ind] in the array and swap it with nums[ind]
                if(nums[i] > nums[ind]){
                    swap(nums,i,ind);
                    break;
                }
            }
        }

        // Step 5: Reverse the portion of the array to the right of 'ind' to get the smallest permutation to the right of 'ind'
        if(ind != -1){
            reverseArr(nums, ind+1, n-1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(nums[i]);
        }

        return ans;
    }

    // Function to find the next permutation of the given arraylist
    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        int n = A.size();
        int ind = -1;

        for(int i = n - 2; i >= 0; i++){
            if(A.get(i) < A.get(i + 1)){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            Collections.reverse(A);
            return A;
        }
        else{
            for(int i = n -1; i >= 0; i++){
                if(A.get(i) > A.get(ind)){
                    int tmp = A.get(i);
                    A.set(i, A.get(ind));
                    A.set(ind, tmp);
                    break;
                }
            }
        }
    

        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        // nextPermutation(arr);
        // System.out.println(Arrays.toString(arr));

        System.out.println(nextPermutation(arr));
    }
}


