

public class OrderAgnosticBS{


    // Method to perform binary search on a sorted array
    static int search(int[] arr, int value){
        int n = arr.length;   // Length of the array
        int start = 0;   // Start index of the search range
        int end = n - 1;    // End index of the search range
        

        // When the array is in assending order
        if(arr[start] < arr[end]){
            while(start <= end){
                int mid = start + (end - start) / 2;  // Calculate the middle index

                if(arr[mid] == value){   // If the middle element is equal to the value, return the index
                    return mid;
                }

                // If the middle element is greater than the value, search in the left half
                if(arr[mid] > value){
                    end = mid - 1;
                }

                // If the middle element is smaller than the value, search in the right half
                if(arr[mid] < value){
                    start = mid + 1;
                }

            }
        }

        // When the array is in decending order
        if(arr[start] > arr[end]){
             while(start <= end){
                int mid = start + (end - start) / 2;  // Calculate the middle index

                if(arr[mid] == value){   // If the middle element is equal to the value, return the index
                    return mid;
                }

                // If the middle element is greater than the value, search in the right half
                if(arr[mid] > value){
                    start = mid + 1;
                }

                // If the middle element is smaller than the value, search in the left half
                if(arr[mid] < value){
                    end = mid - 1;
                }

            }
        }

        return -1;  // If the value is not found, return -1
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(search(arr,2));
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(search(arr2,2));
    }
}