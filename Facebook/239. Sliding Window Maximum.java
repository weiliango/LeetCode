class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length - k + 1 < 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        int[] ret = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            pq.offer(nums[right++]);
            if(right - left == k) {
                ret[left] = pq.peek();
                pq.remove(nums[left++]);
            }
        }
        return ret;
    }
}

//O(nlogk)

//using Deque, would be O(n), at each time
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length - k + 1 < 0) return new int[0];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int[] ret = new int[nums.length -k + 1];
        int idx = 0;
        while(idx < nums.length) {
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[idx])
                dq.pollLast();
            dq.offer(idx);
            if(idx - dq.peekFirst() >= k)
                dq.pollFirst();
            if(idx + 1 >= k)
                ret[idx+1-k] = nums[dq.peekFirst()];
            idx++;
        }
        return ret;
    }
}