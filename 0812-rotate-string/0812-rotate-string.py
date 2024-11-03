class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        # TC- O(n + m)
        # SC - O(m)

        # DNA Pattern Matching
        # when the text and pattern has a lot of repeated characters
        if len(s) != len(goal):
            return False
        togoal = s + s  # text
        return self.KMPSearch(goal, togoal)

    def KMPSearch(self, pattern, text):
        n = len(text)
        m = len(pattern)
        lps = [0] * m
        self.computeLPSArray(pattern, m, lps)

        i = 0  # index for text
        j = 0  # index for pattern

        while i < n:
            if pattern[j] == text[i]:
                i += 1
                j += 1
            if j == m:
                return True  # pattern found in text
            elif i < n and pattern[j] != text[i]:
                if j != 0:
                    j = lps[j - 1]
                else:
                    i += 1
        return False

    def computeLPSArray(self, pattern, m, lps):
        i = 0  # length of previous longest prefix suffix
        j = 1  # start from the second character

        lps[0] = 0

        while j < m:
            if pattern[i] == pattern[j]:
                i += 1
                lps[j] = i
                j += 1
            else:
                if i != 0:
                    i = lps[i - 1]
                else:
                    lps[j] = 0
                    j += 1