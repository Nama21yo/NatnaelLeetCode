class Solution {
    public int addDigits(int num) {
        int digital_root = 0;
        while (num > 0) {
            digital_root += num % 10;
            num /= 10;
            if (num == 0 && digital_root > 9) {
                num = digital_root;
                digital_root = 0;
            }
        }
        return digital_root;
    }
}
