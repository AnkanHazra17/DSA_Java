
// Question: find Nth root of M


public class Solution{

    // Function to calculate mid^n and compare it with m
    public static int finc(int mid, int n, int m){
        long ans = 1;

        // Calculate mid^n iteratively
        for(int i = 0; i < n; i++){
            ans = ans*mid;

            // If mid^n exceeds m, return 2
            if(ans > m){
                return 2;
            }
        }

        // If mid^n is equal to m, return 1
        if(ans == m){
            return 1;
        }

        // If mid^n is less than m, return 0
        return 0;
    }

    // Function to find the nth root of m
    public static int NthRoot(int n, int m) {
        int start = 1;
        int end = m;

        // Binary search loop to find the nth root
        while(start <= end){
            int mid = start + (end - start) / 2;  // Calculate the mid value

            // Get the result of finc(mid, n, m)
            long nthVal = finc(mid, n, m);

            if(nthVal == 1){    // If mid^n is equal to m, return mid
                return mid;
            }
            else if(nthVal == 0){   // If mid^n is less than m, adjust the search range to the right
                start = mid + 1;
            }
            else{         // If mid^n is greater than m, adjust the search range to the left
                end = mid - 1;
            }
        }

        // Return -1 if no nth root is found
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(9, 1953125));
    }
}