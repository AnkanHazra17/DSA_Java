
// Question: Longest Substring Without Repeating Characters
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashMap;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {

        // Create a HashMap to store characters and their last seen indices.
        HashMap<Character, Integer> mpp = new HashMap<>();

        int n = s.length(); // Get the length of the input string.

        int left = 0; // Left pointer of the current substring
        int right = 0; // Right pointer to iterate through the string
        int len = 0; // Maximum length of the substring without repeating characters

        // Loop through the string from the beginning to the end.
        while (right < n) {
            // If the current character at 'right' is already in the map.
            if (mpp.containsKey(s.charAt(right))) {
                // Update 'left' pointer to the maximum of its current value and
                // one position after the last occurrence of the character.
                left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            }

            // Update the map with the current character and its index.
            mpp.put(s.charAt(right), right);

            // Update the maximum length if a longer non-repeating substring is found.
            len = Math.max(len, right - left + 1);

            right++; // Move the 'right' pointer to process the next character.
        }

        return len; // Return the maximum length

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
