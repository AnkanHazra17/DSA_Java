


public class LongestSubArray{

    static int findLongest(int[] A, int N, int K){
        int len = 0;
        int sum = 0;
        int left = 0;

        for(int right = 0; right < N; right++){

            sum = sum + A[right];

            if(sum == K){
                len = Math.max(len, right - left + 1);
            }


            while(sum > K){
                sum = sum - A[left];
                left++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = {-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};
        int N = arr.length;
        int K = 15;
        System.out.println(findLongest(arr, N, K));
    }
}

