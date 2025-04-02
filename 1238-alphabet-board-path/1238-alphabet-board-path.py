class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        letter_map = {}
        for i in range(26):
            letter = chr(ord("a") + i)
            # c = 2 
            # 2 // 5 = 0, 2 % 5 = 2
            # e = 5
            # 4 // 5 = 0, 4 % 5 = 4 
            letter_map[letter] = (i // 5, i % 5)
        
        moves = []
        i , j = 0, 0
        for letter in target:
            target_i, target_j = letter_map[letter]
            if (i , j) == letter_map["z"] and letter != "z":
                moves.append("U")
                i -= 1
            while j != target_j:
                if j < target_j:
                    moves.append("R")
                    j += 1
                else:
                    moves.append("L")
                    j -= 1
            while i != target_i:
                if i < target_i:
                    moves.append("D")
                    i += 1
                else:
                    moves.append("U")
                    i -= 1
            moves.append("!")
        return "".join(moves)