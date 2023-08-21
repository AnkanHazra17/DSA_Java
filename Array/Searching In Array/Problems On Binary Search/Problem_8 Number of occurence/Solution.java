


public class Solution{

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

    static int countFirstLastOccurence(int[] arr, int target){
        int first = findLowerBound(arr, target);
        int second = findUpperBound(arr, target);

        if(first == -1){
            return 0;
        }

        while (arr[first] != target){
            first++;
        }

        while (arr[second] != target){
            second--;
        }
        
        return second - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5};
        System.out.println(countFirstLastOccurence(arr, 4));
    }
}