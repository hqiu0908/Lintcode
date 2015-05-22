/*

Triangle Count

Given an array of integers, how many three numbers can be found in the array, 
so that we can build an triangle whose three edges length is the three 
numbers that we find?

Example
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]

*/

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public static int triangleCount(int S[]) {
        if (S == null || S.length < 3) {
            return 0;
        }

        Arrays.sort(S);
        
        int count = 0;
        
        for (int end = S.length - 1; end > 0; end--) {
            int left = 0;
            int right = end - 1;
            
            while (left < right) {
                int sum = S[left] + S[right];
                
                if (sum > S[end]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return count;
    }
}
