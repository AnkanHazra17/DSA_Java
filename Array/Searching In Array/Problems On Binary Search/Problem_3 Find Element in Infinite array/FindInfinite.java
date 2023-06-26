

public class FindInfinite{

    static int searchBS(int[] arr, int target, int start, int end){
        
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
        return -1;  // If the value is not found, return -1
    }

    static int findElement(int[] arr, int target){
        int start = 0;
        int end = 1;

        while(arr[end] < target){
            int newStart = end + 1;
            end = start + (end - start + 1)*2;
            start = newStart;
        }

        return searchBS(arr, target, start, end);
    }

    public static void main(String[] args){
        int[] arr = {2};
        System.out.println(findElement(arr, 11)); 
    }
}