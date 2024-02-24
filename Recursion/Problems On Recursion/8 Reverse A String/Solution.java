
public class Solution {

    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "Ankan";
        // reverseString(str);
        // System.out.println(str.substring(1));
        System.out.println(reverseString(str));
    }
}