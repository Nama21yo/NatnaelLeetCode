class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        win = [0] * 100001
        loss = [0] * 100001
        for match in matches:
            win[match[0]] += 1
            loss[match[1]] -= 1
        
        winner = []
        loser = []

        for i, num in enumerate(win):
            if num > 0 and loss[i] == 0:
                winner.append(i)
            elif loss[i] == -1:
                loser.append(i)
        return [winner, loser]
        
        