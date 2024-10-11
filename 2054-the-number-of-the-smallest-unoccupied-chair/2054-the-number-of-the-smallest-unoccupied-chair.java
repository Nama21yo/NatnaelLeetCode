class Item {
    int friend;
    int chair = -1;
    int startTime;
    int endTime;

    public Item(int friend, int startTime, int endTime) {
        this.friend = friend;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }
}

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        Item[] arrival = new Item[times.length];

        // PriorityQueue to track available chairs
        PriorityQueue<Integer> available = new PriorityQueue<>();
        // PriorityQueue to track assigned chairs (by endTime)
        PriorityQueue<Item> assigned = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);

        // Initialize arrival times and add chairs to the available queue
        for (int i = 0; i < times.length; ++i) {
            arrival[i] = new Item(i, times[i][0], times[i][1]);
            available.add(i);
        }

        // Sort the arrival array by startTime
        Arrays.sort(arrival, (a, b) -> a.startTime - b.startTime);

        // Assign chairs
        for (Item item : arrival) {
            // Free up chairs for friends who have left before the current friend's arrival
            while (!assigned.isEmpty() && assigned.peek().endTime <= item.startTime) {
                available.add(assigned.poll().chair);
            }

            // Assign the next available chair to the current friend
            item.setChair(available.poll());
            assigned.add(item);

            // If this friend is the target friend, return their chair number
            if (item.friend == targetFriend) {
                return item.chair;
            }
        }

        return -1;
    }
}
