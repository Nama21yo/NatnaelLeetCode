class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        # This is naive Algorithm
        # In worst case TC- O((n + m)^ 2)
        
        if len(s) != len(goal):
            return False

        togoal = s + s
        m = len(goal)
        n = len(togoal)

        for i in range(n - m + 1):
            found = True
            for j in range(m):
                if togoal[i + j] != goal[j]:
                    found = False
                    break
            if found:
                return True
        
        return False
