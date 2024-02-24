import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void solve(int[] nums, List<Integer> list, int index, List<List<Integer>> ans) {
        if (index >= nums.length) {
            ans.add(list);
            return;
        }

        // Exclude
        solve(nums, list, index + 1, ans);

        // Include
        list.add(nums[index]);
        solve(nums, list, index + 1, ans);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, list, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(subsets(arr));
    }
}