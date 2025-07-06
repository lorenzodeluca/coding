//avg time O(n), space O(1)
/*
 * Approach : XOR Operation
Why XOR works:

1. XOR of a number with itself is 0 (a ^ a = 0 , any number XOR with itself is zero)
2 . XOR of a number with 0 is the number itself (a ^ 0 = a),any number XOR with zero is the number itself
3 . XOR is commutative and associative (order doesn't matter)
🔧 Steps (in code)

1 . Initialize a variable index to 0.
2 . Iterate through the array.
3 . For each number nums[i], compute index = index ^ nums[i].
4 . After the loop, index will hold the single number.
 */
class Solution {
    public int singleNumber(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            index=index^nums[i];
        }
        
        return index;
    }
}