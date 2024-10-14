class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int num : nums) {
            pq.offer(num);
        }

        long score = 0;

        while(!pq.isEmpty() && k > 0) {
            int maxi = pq.poll();
            score += maxi;

            pq.add((int) (maxi + 2) / 3);
            k--;
        }

        return score;
    }
}