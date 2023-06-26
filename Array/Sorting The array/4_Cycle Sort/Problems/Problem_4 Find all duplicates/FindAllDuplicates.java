

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates{

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static List<Integer> findDuplicates(int[] arr){
        int n = arr.length;
        int i = 0;

        while(i < n){
            int correctInd = arr[i] - 1;

            if(arr[i] != arr[correctInd]){
                swap(arr, i, correctInd);
            }
            else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int index = 0; index < n; index++){
            if(arr[index] != index + 1){
                ans.add(arr[index]);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
}