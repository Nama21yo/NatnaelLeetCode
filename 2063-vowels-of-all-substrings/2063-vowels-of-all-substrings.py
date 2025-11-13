class Solution:
    def countVowels(self, word: str) -> int:
        vowels = {"a", "e", "i", "o", "u"}
        total = 0

        n = len(word)
        for i in range(n):
            if word[i] in vowels:
                total += (i + 1) * (n - i)

        return total