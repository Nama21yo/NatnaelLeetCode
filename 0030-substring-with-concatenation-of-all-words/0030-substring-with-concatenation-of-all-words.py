class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return []
        
        word_len = len(words[0])
        word_count = len(words)
        total_len = word_len * word_count
        n = len(s)
        
        if n < total_len:
            return []
        
        word_freq = defaultdict(int)
        for word in words:
            word_freq[word] += 1
        
        result = []
        
        for i in range(word_len):
            left = i
            count = 0
            window = defaultdict(int)
            
            for right in range(i, n - word_len + 1, word_len):
                word = s[right:right + word_len]
                
                if word in word_freq:
                    window[word] += 1
                    count += 1
                    
                    while window[word] > word_freq[word]:
                        left_word = s[left:left + word_len]
                        window[left_word] -= 1
                        left += word_len
                        count -= 1
                    
                    if count == word_count:
                        result.append(left)
                else:
                    window.clear()
                    count = 0
                    left = right + word_len
        
        return result