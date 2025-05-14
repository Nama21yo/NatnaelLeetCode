class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        n = len(pref)
        running = pref[0]
        for i in range(1,n):
            pref[i] = pref[i] ^ running
            running = running ^ pref[i]
        return pref
