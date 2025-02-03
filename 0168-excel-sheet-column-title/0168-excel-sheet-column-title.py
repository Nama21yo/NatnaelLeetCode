class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        decrypted = []

        while columnNumber > 0:
            columnNumber -= 1
            decrypted.append(chr((columnNumber % 26) + ord("A")))
            columnNumber //= 26
        
        return "".join(decrypted[::-1])