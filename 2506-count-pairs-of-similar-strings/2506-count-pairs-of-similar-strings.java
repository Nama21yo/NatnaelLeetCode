class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        for(int i = 0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(checkSimilar(words[i],words[j])){
                    count++;    
                }
            }
        }
        return count;
    }
    public static boolean checkSimilar(String s,String t){
        Set<Character> sSet = new HashSet<>();
        for(char ch:s.toCharArray()){
            sSet.add(ch);
        }
        Set<Character> tSet = new HashSet<>();
         for(char ch:t.toCharArray()){
            tSet.add(ch);
        }
        if(sSet.equals(tSet)){
            return true;
        }
        return false;
    }
}