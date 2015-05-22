/*

Print Numbers by Recursion

Print numbers from 1 to the largest number with N digits by recursion.

Example
Given N = 1, return [1,2,3,4,5,6,7,8,9].

Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].

Note
It's pretty easy to do recursion like:

recursion(i) {
    if i > largest number:
        return
    results.add(i)
    recursion(i + 1)
}
however this cost a lot of recursion memory as the recursion depth maybe very
large. Can you do it in another way to recursive with at most N depth?

Challenge
Do it in recursion, not for-loop.

*/

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> results = new ArrayList<Integer>(); 
     
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        if (n <= 0) {
            return results;
        }
    
        if (n == 1) {
            for (int i = 1; i < 10; i++) {
               results.add(i);
            }
            return results;
        }
    
        results = numbersByRecursion(n - 1);
        int size = results.size();
    
        int start = (int) (Math.pow(10, n-2) - 1);
        for (int i = start; i < size; i++) {
            for (int j = 0; j < 10; j++) {
                int num = results.get(i) * 10 + j;
                results.add(num);
            }
        }
    
        return results;
    }
}

