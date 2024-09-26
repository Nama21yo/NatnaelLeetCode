class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> common = new HashMap<>();
        
        for(int i = 0; i < list1.length; i++) {
            common.put(list1[i], i);
        }
        List<String> leastCommon = new ArrayList<>();
        int total = 0;
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++) {
            if(common.get(list2[i]) != null) {
                total = i + common.get(list2[i]); 
                if(total < minIndex) {
                    leastCommon.clear();
                    leastCommon.add(list2[i]);
                } else if(total == minIndex) {
                    leastCommon.add(list2[i]);
                }
                minIndex = Math.min(minIndex, total);
            }
        }

        String[] result = new String[leastCommon.size()];
        return leastCommon.toArray(result);
    }
}