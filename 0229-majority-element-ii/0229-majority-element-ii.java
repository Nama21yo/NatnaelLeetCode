import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> candidates = findCandidate(nums);
        return validateCandidates(nums, candidates);
    }
    
    private List<Integer> findCandidate(int[] nums) {
        int count1 = 0, count2 = 0;
        int cand1 = Integer.MIN_VALUE, cand2 = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (cand1 == nums[i] ) {
                count1++;
            } else if (cand2 == nums[i]) {
                count2++;
            } else if (count1 == 0 && nums[i] != cand2) {
                cand1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != cand1) {
                cand2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(cand1);
        result.add(cand2);
        return result;
    }
    
    private List<Integer> validateCandidates(int[] nums, List<Integer> candidates) {
        int count1 = 0, count2 = 0;
        int cand1 = candidates.get(0), cand2 = candidates.get(1);
        
        // Count occurrences of the two candidates
        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }
        
        List<Integer> ans = new ArrayList<>();
        int mini = nums.length / 3;
        
        // Only add the candidates if their counts exceed n/3
        if (count1 > mini) ans.add(cand1);
        if (count2 > mini && cand2 != cand1) ans.add(cand2); // Avoid duplicates
        
        return ans;
    }
}
