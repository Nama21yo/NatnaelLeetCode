class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        
        while(i>=0){
            char c = s.charAt(i);
            int val;
            switch(c){
                case '#':
                    val = Integer.parseInt(s.substring(i-2,i));
                    i-=3;
                    break;
                default:
                    val = Integer.parseInt(String.valueOf(c));
                    i--;
                    break;
            }
            char v = (char)('a'+val-1);
            sb.append(v);
        }
        return sb.reverse().toString();
    }
}