
// Question: Maximize Number of 1's fliping the 0's
// Given a binary array arr of size N and an integer M. 
// Find the maximum number of consecutive 1's produced by flipping at most M 0's.

public class MaxConsicutive{

    // Function to find the maximum number of consecutive 1s
    // after flipping at most 'm' 0s to 1s
    static int findZeroes(int[] arr, int n, int m){

        int max = 0;  // Variable to store the maximum length of consecutive 1s
        int flip = 0;  // Variable to count the number of flipped 0s
        int left = 0;  // Variable to track the left index of the current subarray

        // Iterate over the array using the 'right' index
        for(int right = 0; right < n; right++){
            if(arr[right] == 0){
                flip++;   // Increment 'flip' count if the element is 0
            }

            // Adjust the 'left' index and decrease 'flip' count if
            // the number of flipped 0s exceeds 'm'
            while(flip > m){
                if(arr[left] == 0){
                    flip--;  // Decrease 'flip' count if the element at 'left' is 0
                }
                left++;  // Increment 'left' index to move the window to the right
            }

            // Calculate the length of the current subarray and update 'max' if necessary
            max = Math.max(max, right - left + 1);
        }

        // Return the maximum length of consecutive 1s found in the array after flipping at most 'm' 0s
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int n = arr.length;
        int m = 2;
        System.out.println(findZeroes(arr, n, m));
    }
}

