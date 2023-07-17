import java.util.ArrayList;

public class OparationsOnArrayLIst{

    // Mathod to everse an ArrayList
    static void reverse(ArrayList<Integer> list){
        for(int i = list.size() - 1; i >= 0; i--){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    // Mathod to Swap two elements
    static void swap(ArrayList<Integer> list, int first, int second){
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    // Mathod to swap two elements using two pointer Approach
    static void reverseUsingTwoPointer(ArrayList<Integer> list){
        int start = 0;
        int end = list.size() - 1;

        while(start <= end){
            swap(list, start, end);
            start++;
            end--;
        }
    }

    // Mmathod to find max in an ArrayList
    static int findMax(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < list.size(); i++){
            max = Math.max(max, list.get(i));
        }

        return max;
    }

    // Mmathod to find max in an ArrayList
    static int findMin(ArrayList<Integer> list){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < list.size(); i++){
            min = Math.min(min, list.get(i));
        }

        return min;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(8);
        list.add(6);
        list.add(10);

        System.out.println(list);

        // reverse(list);
        // swap(list, 1, 3);
        // System.out.println(list);

        // reverseUsingTwoPointer(list);
        // System.out.println(list);

        System.out.println(findMax(list));

        System.out.println(findMin(list));
        
    }
}