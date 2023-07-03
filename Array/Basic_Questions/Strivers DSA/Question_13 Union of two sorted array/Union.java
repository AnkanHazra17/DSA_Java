import java.util.ArrayList;
import java.util.Arrays;

public class Union{

    // Method to find the union of two sorted arrays
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){

        // Create an ArrayList to store the union elements
        ArrayList<Integer> unionArr = new ArrayList<>();

        // Initialize two pointers for array traversal
        int i = 0; 
        int j = 0;

        // Iterate until either pointer reaches the end of its respective array
        while(i < n && j < m){

            // If the current element in arr1 is less than or equal to the current element in arr2
            if(arr1[i] <= arr2[j]){

                // Check if unionArr is empty or if the last element of unionArr is not equal to arr1[i]
                if(unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr1[i]){
                    
                    unionArr.add(arr1[i]);  // Add arr1[i] to unionArr since it is a distinct element
                }
                i++; // Move to the next element in arr1
            }

            else{
                // If the current element in arr1 is greater than the current element in arr2
                // Check if unionArr is empty or if the last element of unionArr is not equal to arr2[j]
                if(unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr2[j]){
                    
                    unionArr.add(arr2[j]);  // Add arr2[j] to unionArr since it is a distinct element
                }
                j++; // Move to the next element in arr2
            }
        }

        // Handle remaining elements in arr1
        while(i < n){

            // Check if the last element of unionArr is not equal to arr1[i]
            if(unionArr.get(unionArr.size() - 1) != arr1[i]){
                unionArr.add(arr1[i]);
            }
            i++;
        }

        // Handle remaining elements in arr2
        while(j < m){

            // Check if the last element of unionArr is not equal to arr1[j]
            if(unionArr.get(unionArr.size() - 1) != arr2[j]){
                unionArr.add(arr2[j]);
            }
            j++;
        }

        return unionArr;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 3, 4, 5};
        int n = arr1.length;
        int[] arr2 = {1, 1, 2, 3, 4};
        int m = arr2.length;

        System.out.println(findUnion(arr1, arr2, n, m));
    }
}