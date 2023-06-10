

public class MinMax{

    static int minValue(int[] arr){
        int n = arr.length;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    static int minValueInRange(int[] arr, int start, int end){
        int n = arr.length;
        int min = Integer.MAX_VALUE;

        for(int i = start; i <= end; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    static int maxValue(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static int maxValueInRange(int[] arr, int start, int end){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for(int i = start; i <= end; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }


    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minValue(arr));
        System.out.println(minValueInRange(arr,1,2));
        System.out.println(maxValue(arr));
        System.out.println(maxValueInRange(arr,1,2));

    }
}