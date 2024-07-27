import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all indices to the queue, representing people in the queue.
        for(int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }
        
        int seconds = 0;
        // Process the queue until it's empty.
        while(!queue.isEmpty()) {
            seconds++;
            // Take the person at the front of the queue.
            int person = queue.poll();
            
            // Decrease the number of tickets for this person.
            if(tickets[person] >= 1) {
                tickets[person]--;
            }
            // If this is the person k and they have finished buying tickets, break the loop.
            if(person == k && tickets[person] == 0) {
                break;
            }
            // If the person is not person k and they have finished buying tickets, do not add them back to the queue.
            if(person != k && tickets[person] == 0) {
                continue;
            }
            // Add the person back to the end of the queue.
            queue.add(person);
        }
        
        return seconds;
    }
}
