class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        Random rand = new Random(0);

        while (left <= right) {
        int choosenIndex = rand.nextInt(right - left + 1) + left;

        int finalIndex = partition(nums, left, right, choosenIndex);
        if (finalIndex == n - k) {
            return nums[finalIndex];
        } else if (finalIndex > n - k) {
            right = finalIndex - 1;
        } else {
            left = finalIndex + 1;
        }
        }

        return -1;
    }

    private int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        int lesserIndex = left;
        swap(arr, pivotIndex, right);

        for (int i = left; i < right; i++) {
        if (arr[i] < pivotValue) {
            swap(arr, i, lesserIndex);
            lesserIndex++;
        }
        }

        swap(arr, right, lesserIndex);

        return lesserIndex;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}