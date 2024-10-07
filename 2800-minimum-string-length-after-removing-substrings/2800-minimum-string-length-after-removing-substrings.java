class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new LinkedList();

        for(int i = 0; i < s.length();++i) {
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.addLast(c);
            } else if(c == 'B' && stack.peekLast() =='A') {
                stack.pollLast();
            } else if(c == 'D' && stack.peekLast() == 'C') {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }

        return stack.size();
    }
}