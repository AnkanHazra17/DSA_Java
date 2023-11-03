
public class Solution {

    public static int maxDepth(String s) {
        int count = 0;
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ')') {
                count++;
            } else {
                break;
            }
            i--;
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "((0-9))(1-3)(((4+5)((0/2)(5-1)(5/9))(9-0)((4/3)(2+7))(3-6)(((6+2)))))";
        System.out.println(maxDepth(str));
    }
}