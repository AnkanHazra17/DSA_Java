

// Question: Square root of a number

// Given an integer x, find the square root of N. If x is not a perfect square, then return floor(√N).



public class Solution{

    // Function to calculate the integer square root of a given long integer N.
    // It uses binary search to find the largest integer 'mid' whose square is less than or equal to N.
    public static int sqrtN(long N) {
		long start = 1;    // Starting point of the binary search range.
        long end = N;      // Ending point of the binary search range.

        while(start <= end){
            long mid = start + (end - start) / 2;   // Calculate the middle point of the current range.

            // Check if the square of 'mid' is less than or equal to N.
            if(mid*mid <= N){
                start = mid + 1;   // Adjust the starting point to search in the right half.
            }
            else{
                end = mid - 1;     // Adjust the ending point to search in the left half.
            }
        }

        // 'end' holds the largest integer whose square is less than or equal to N.
        // Casting 'end' to int before returning, as the function is expected to return an int.
        return (int)end;
	}

    public static void main(String[] args) {
        
        System.out.println(sqrtN(6));
    }
}

