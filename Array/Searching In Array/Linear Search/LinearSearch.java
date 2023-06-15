

// Code for Linear Search  ==> Time Complexity O(n)

public class LinearSearch{

    // Method to perform linear search and find the index of a value in an array
    static int searchLS(int[] arr, int value){
        int n = arr.length;

        // Iterate through each element in the array
        for(int i = 0; i < n; i++){

            // Check if the current element is equal to the given value
            if(arr[i] == value){
                return i;  // If found, return the index
            }
        }
        return -1;  // If the value is not found, return -1
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 8, 6, 10};
        System.out.println(searchLS(arr,8));
    } 
}