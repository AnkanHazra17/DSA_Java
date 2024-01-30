import java.util.Arrays;

public class Solution {

    static boolean isPossible(int[] heater, int mid, int[] house) {
        int res1 = Math.abs(heater[0] + mid);
        int res2 = Math.abs(heater[0] - mid);

        return (res1 >= house[house.length - 1]) && (res2 >= house[0]);
    }

    static public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length;
        int low = houses[0];
        int high = houses[n - 1];
        Arrays.sort(heaters);

        while (low <= high) {
            int mid = (low + high) / 2;
            boolean can = isPossible(heaters, mid, heaters);

            if (can) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 2 };
        System.out.println(findRadius(arr, arr2));
    }
}