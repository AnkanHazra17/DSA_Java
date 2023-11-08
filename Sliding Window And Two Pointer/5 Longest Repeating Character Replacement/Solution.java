// Question: Longest Repeating Character Replacement
// Link: https://leetcode.com/problems/longest-repeating-character-replacement/

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int len = 0;
        int maxRepCnt = 0;
        Map<Character, Integer> mpp = new HashMap<>();

        while (right < s.length()) {
            char curr = s.charAt(right);

            mpp.put(curr, mpp.getOrDefault(curr, 0) + 1);

            maxRepCnt = Math.max(maxRepCnt, mpp.get(curr));
            int nonRepCnt = (right - left + 1) - maxRepCnt;

            while (nonRepCnt > k) {
                mpp.put(s.charAt(left), mpp.get(s.charAt(left)) - 1);
                left++;
            }

            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        System.out.println(characterReplacement(s, 1));
    }
}