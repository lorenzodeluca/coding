//avg time O(n^2), space O(1)

class Solution {
    public String longestPalindrome(String s) {
        //inclusive bounds of the answer
        int[] ans = new int[] { 0, 0 };

        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i, s);
            if (oddLength > ans[1] - ans[0] + 1) {
                int dist = oddLength / 2;
                ans[0] = i - dist;
                ans[1] = i + dist;
            }

            int evenLength = expand(i, i + 1, s);
            if (evenLength > ans[1] - ans[0] + 1) {
                int dist = (evenLength / 2) - 1;
                ans[0] = i - dist;
                ans[1] = i + 1 + dist;
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }

    //find the length of the longest palindrome centered at i, j.
    private int expand(int i, int j, String s) {
        int left = i;
        int right = j;

        while (
            left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
        ) {
            left--;
            right++;
        }
        /*
         * The formula for the length of a substring starting at
         *  left and ending at right is right - left + 1.
            However, when the while loop ends, it implies s[left] != s[right]. 
                Therefore, we need to subtract 2. Return right - left - 1.
         */
        return right - left - 1;
    }
}