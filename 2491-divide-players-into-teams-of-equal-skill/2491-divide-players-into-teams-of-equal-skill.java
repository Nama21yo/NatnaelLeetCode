class Solution {
    public long dividePlayers(int[] skill) {
        // Sort the skills array
        Arrays.sort(skill);
        
        int left = 0;
        int right = skill.length - 1;
        
        // Calculate the desired sum of skills for a valid pair
        int sum = skill[left] + skill[right];
        
        // Initialize sumOfSkills with 0
        long sumOfSkills = 0;
        
        // Process pairs from the ends towards the middle
        while (left < right) {
            // Check if the current pair sums to the desired sum
            if (skill[left] + skill[right] != sum) {
                return -1; // If not, return -1 as it's not possible to pair players correctly
            }
            
            // Calculate the product of the current pair and add it to sumOfSkills
            sumOfSkills += (long)skill[left] * skill[right];
            
            // Move the pointers inward
            left++;
            right--;
        }
        
        // Return the total sum of skill products
        return sumOfSkills;
    }
}
