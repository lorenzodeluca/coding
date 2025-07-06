//avg time O(log base 2 of n = log n), space O(1)
class Solution {
    public int hammingWeight(int n) {
        int c=0;
        while(n>0)
        {
            int r=n%2;
            if(r==1)
            {
                c++;
            }
            n=n/2;
        }
        return c;
    }
}