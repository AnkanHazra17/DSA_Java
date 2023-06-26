

// Question: Given an mountain array, the task is to find the index of the peak element of the array

public class PeakOfArray{

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

    public static void main(String[] args){
        int[] arr ={0,10,5,2};
        System.out.println(findPeak(arr));
    }
}