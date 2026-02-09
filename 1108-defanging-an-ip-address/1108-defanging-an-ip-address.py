class Solution:
    def defangIPaddr(self, address: str) -> str:
        result = []
        for char in address:
            if char == ".":
                result.append("[.]")
            else:
                result.append(char)
        # ""
        # "" + "1"
        # "1"
        # n (n + 1) /2 O(n^2)
        return "".join(result)