class Solution {
    public int minimumSteps(int[] num1, int[] num2) {
        int steps = 0;
        for(int i = 0; i < num1.length; i++) {
            steps += Math.abs(num1[i] - num2[i]);
        }
        return steps;
    }
}