class Solution:
    def isPalindrome(self, x: int) -> bool:
        reversed = 0
        temp = x
        while x > 0:
            reversed = (reversed * 10) + (x % 10)
            x = x // 10
        return reversed == temp

        