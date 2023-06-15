

public class CeilingAndFloor{


    // Method to search ceiling of the array
    static int searchCeiling(int[] arr, int target){
        int n = arr.length;   // Length of the array
        int start = 0;   // Start index of the search range
        int end = n - 1;    // End index of the search range
        

        if(target > arr[n - 1]){ // if the target is greater than the last element of the array, return -1 
            return -1;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;  // Calculate the middle index

            if(arr[mid] == target){   // If the middle element is equal to the target, return the index
                return mid;
            }

            // If the middle element is greater than the target, search in the left half
            if(arr[mid] > target){
                end = mid - 1;
            }

            // If the middle element is smaller than the target, search in the right half
            if(arr[mid] < target){
                start = mid + 1;
            }

        }
        // If the target is not found, return start because the search window become closer to the target.
        // at the end start > end and start target is the index of the ceiling number.
        return start;  
                       
    }


    // Method to search floor of the array
    static int searchFloor(int[] arr, int target){
        int n = arr.length;   // Length of the array
        int start = 0;   // Start index of the search range
        int end = n - 1;    // End index of the search range
        

        if(target > arr[n - 1]){ // if the target is greater than the last element of the array, return -1 
            return -1;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;  // Calculate the middle index

            if(arr[mid] == target){   // If the middle element is equal to the target, return the index
                return mid;
            }

            // If the middle element is greater than the target, search in the left half
            if(arr[mid] > target){
                end = mid - 1;
            }

            // If the middle element is smaller than the target, search in the right half
            if(arr[mid] < target){
                start = mid + 1;
            }

        }
        // If the target is not found, return end because the search window become closer to the target.
        // at the end start > end and end value is the index of the floor number.
        return end;  
                       
    }

    public static void main(String[] args){
        int[] arr = {2, 3, 5, 6};
        System.out.println(searchCeiling(arr,1));
        System.out.println(searchFloor(arr,1));
        
    }
}