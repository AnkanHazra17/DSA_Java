import java.util.ArrayList;
import java.util.Arrays;

class pair {
    long first;
    long second;

    public pair(long first, long second){
        this.first = first;
        this.second = second;
    }
}

public class PairSum{

    static pair[] allPairs(long A[], long B[], long N, long M, long X){
        ArrayList<pair> list = new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0; 
        int j = B.length - 1;

        while(i < N && j >= 0){
            long sum = A[i] + B[j];

            if(sum < X){
                i++;
            }
            else if(sum > X){
                j--;
            }
            else{
                list.add(new pair(A[i], B[j]));
                i++;
                j--;
            }
        }

        pair[] ans = new pair[list.size()];
        return list.toArray(ans);

    }

    public static void main(String[] args) {
        long[] a = {1, 2, 4, 5, 7};
        long N = a.length;

        long[] b = {5, 6, 3, 4, 8};
        long M = b.length;

        long X = 9;

        
        pair[] result = allPairs(a, b, N, M, X);

        for (pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }
}