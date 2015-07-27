/*

Binary Search Show result 

For a given sorted array (ascending order) and a target number, find the first
index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Have you met this question in a real interview? Yes Example If the array is [1,
2, 3, 3, 4, 5, 10], for given target 3, return 2.

Challenge If the count of numbers is bigger than 2^32, can your code work
properly?

*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        // If we use start <= end, it may get to an infinite loop. Since mid
        // could be equal to start and we will always get start equals to end
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                // Keep finding the first occurrence.
                end = mid;
                // If finding the last occurrance, start = mid.
                // If we only have 1 occurrance, we can return mid here.
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        // When we break out the while loop, we haven't checked the two ends.
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}
