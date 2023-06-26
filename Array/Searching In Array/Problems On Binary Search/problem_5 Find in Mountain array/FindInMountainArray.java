

public class FindInMountainArray{

    // Method to find the index of a peak element in the array
    static int findPeak(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(arr[mid] < arr[mid + 1]){
                // If the element at mid is less than its adjacent element on the right,
                // the peak element must be on the right side of mid
                start = mid + 1;
            }
            else{
                // Otherwise, the peak element must be on the left side of mid or can be the mid element itself
                // Since we are looking for any peak element, updating end to mid is valid.
                end = mid;
            }
        }

        // At this point, start and end will be equal, indicating the index of the peak element
        return start;
    }

    static int findElement(int[] arr, int target){
        int n = arr.length;   // Length of the array
        int start = 0;   // Start index of the search range
        int end = n - 1;    // End index of the search range
        int peakInd = findPeak(arr);
        

        // When the array is in assending order
        if(target < arr[peakInd]){
            end = peakInd;
            while(start <= end){
                int mid = start + (end - start) / 2;  // Calculate the middle index

                if(arr[mid] == target){   // If the middle element is equal to the value, return the index
                    return mid;
                }

                // If the middle element is greater than the value, search in the left half
                if(arr[mid] > target){
                    end = mid - 1;
                }

                // If the middle element is smaller than the value, search in the right half
                if(arr[mid] < target){
                    start = mid + 1;
                }

            }
        }

        // When the array is in decending order
        else{
            start = peakInd;
             while(start <= end){
                int mid = start + (end - start) / 2;  // Calculate the middle index

                if(arr[mid] == target){   // If the middle element is equal to the value, return the index
                    return mid;
                }

                // If the middle element is greater than the value, search in the right half
                if(arr[mid] > target){
                    start = mid + 1;
                }

                // If the middle element is smaller than the value, search in the left half
                if(arr[mid] < target){
                    end = mid - 1;
                }

            }
        }

        return -1;  // If the value is not found, return -1
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println(findElement(arr, 3));
    }
}