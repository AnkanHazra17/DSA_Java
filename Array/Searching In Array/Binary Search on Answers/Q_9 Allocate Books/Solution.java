
// Question: Allocate Books

// Problem link: https://www.codingninjas.com/studio/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries

// import java.util.ArrayList;

import java.util.ArrayList;

public class Solution{

    // On Array
    public static int findMin(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        return maxi;
    }

    public static int arrSum(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }

        return sum;
    }

    // Function to determine the number of students needed to read an array of book pages
    public static int studentNumber(int[] arr, int pages){
        int student = 1;    // Initialize the number of students to one
        int stdPages = 0;   // Initialize the pages currently assigned to a student

        for(int i = 0; i < arr.length; i++){
            if(stdPages + arr[i] <= pages){
                // If adding the current book's pages doesn't exceed the limit, assign it to the student
                stdPages = stdPages + arr[i]; 
            }
            else{
                student++;  // If adding the current book's pages would exceed the limit, increment the student count
                stdPages = arr[i];  // Assign the current book's pages to the next student
            }
        }

        return student;  // Return the total number of students needed
    }

    // Function to find the minimum number of pages each student must read
    public static int findPages(int[] arr, int m) {

        if(arr.length > m){
            return -1;    // If there are more books than students, it's not possible, so return -1
        }

        int low = findMin(arr);  // Find the minimum value in the array
        int high = arrSum(arr);  // Calculate the sum of all elements in the array

        // Perforn binary search Algorithm
        while(low <= high){
            int mid = low + (high - low) / 2;  // Calculate the middle value
            int stdCnt = studentNumber(arr, mid);  // Find the number of students needed for the current page allocation

            if(stdCnt > m){
                low = mid + 1;   // If more students are needed than available, increase the page allocation
            }
            else{
                high = mid - 1;  // If the current allocation is sufficient, decrease the page allocation
            }
        }

        return low;  // Return the minimum number of pages each student must read
    } 



    // On ArrayList
    public static int findMinList(ArrayList<Integer> arr, int n){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, arr.get(i));
        }

        return maxi;
    }

    public static int arrSumList(ArrayList<Integer> arr, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + arr.get(i);
        }

        return sum;
    }

    public static int studentNumberList(ArrayList<Integer> arr, int pages, int n){
        int student = 1;
        int stdPages = 0;

        for(int i = 0; i < n; i++){
            if(stdPages + arr.get(i) <= pages){
                stdPages = stdPages + arr.get(i);
            }
            else{
                student++;
                stdPages = arr.get(i);
            }
        }

        return student;
    }

    public static int findPagesArrayList(ArrayList<Integer> arr, int n, int m) {

        if(n < m){
            return -1;
        }

        int low = findMinList(arr, n);
        int high = arrSumList(arr, n);

        while(low <= high){
            int mid = low + (high - low) / 2;
            int stdCnt = studentNumberList(arr, mid, n);

            if(stdCnt > m){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        // int[] arr = {12, 34, 67, 90};
        // System.out.println(findPages(arr, 2));

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(34);
        arr.add(67);
        arr.add(90);

        int n = arr.size();

        System.out.println(findPagesArrayList(arr,n,2));
    }
}