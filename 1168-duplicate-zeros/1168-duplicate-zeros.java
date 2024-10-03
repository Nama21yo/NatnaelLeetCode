class Solution {
    public void duplicateZeros(int[] arr) {
        // Better Solution using Queue O(n) time and O(n) space
        Queue<Integer> queue = new LinkedList<>();
        int n = arr.length;
        for(int i = 0; i < n; ++i) {
            if(arr[i] == 0) {
                queue.add(0);
                queue.add(0);
            } else {
                queue.add(arr[i]);
            }
            Integer first = queue.poll(); // the first element in the queue
            arr[i] = first;
        }   
    }
}
