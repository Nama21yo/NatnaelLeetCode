class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        word_count = Counter()
        for word in words2:
            word_count |= Counter(word)
        
        ans = []
        for word in words1:
            each_word = Counter(word)
            if word_count <= each_word:
                ans.append(word)
        
        return ans
                
