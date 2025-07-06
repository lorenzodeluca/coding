//time O(n), space O(1)
class Solution {
    int char2num(char a) {
        switch (a) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && char2num(s.charAt(i)) < char2num(s.charAt(i + 1))) {
                result -= char2num(s.charAt(i));
            } else {
                result += char2num(s.charAt(i));
            }
        }
        return result;
    }
}