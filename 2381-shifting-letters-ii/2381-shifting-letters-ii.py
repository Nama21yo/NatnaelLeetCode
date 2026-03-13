class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        # a _> forward -> backward -> a
        n = len(s)
        diff = [0] * (n + 1)

        for start, end, dirc in shifts:
            if dirc == 1: # forward
                diff[start] += 1
                diff[end + 1] -= 1
            else:
                diff[start] -= 1
                diff[end + 1] += 1

        running_sum = 0 # prefix sum
        # abc -> ace
        # 012
        ans = []
        for i in range(n):
            running_sum += diff[i]
            # b -> + 1 -> c
            # ord("b") - ord("a") + running_sum -> c
            number = (ord(s[i]) - ord("a") + running_sum) % 26

            ans.append(chr(ord("a") + number))
        return "".join(ans)