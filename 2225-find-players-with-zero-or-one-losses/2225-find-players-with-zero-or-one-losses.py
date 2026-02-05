class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        losers = defaultdict(int)
        winners = set()
        for winner, loser in matches:
            losers[loser] += 1
            winners.add(winner)
        
        zero_loss = []
        one_loss = []
        for player in winners:
            if player not in losers:
                zero_loss.append(player)
        
        for player, loss_count in losers.items():
            if loss_count == 1:
                one_loss.append(player)
        
        return [sorted(zero_loss), sorted(one_loss)]