

public class LargeColSum{

    static int colSum(int[][] arr){
        int maxSum = 0;
        int row = arr.length;
        int col = arr[0].length;

        for(int j = 0; j < col; j++){
            int sum = 0;
            for(int i = 0; i < row; i++){
                sum = sum + arr[i][j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 5, 2, 11},
            {3, 6, 9, 7},
            {20, 5, 12, 10},
        };

        System.out.println(colSum(arr));
    }
}