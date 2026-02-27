class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # cbaebabacd , p = abc
        # p -> {a : 1, b : 1, c : 1}
        # cba -> valid
        # new_dict {c : 1, b : 1, a : 1}
        # bae -> invalid
        # new_dict {b : 1, a : 1, e : 1}
        # old_dict {c : 1, b : 1, a : 1}
        # couunt decrease by 1 and if it is 0 remove it
        # old_dict {b: 1, a : 1}
        # add the new element
        # old_dict {b : 1, a :1 , e : 1} == new_dict
        # sliding
        
        # count p
        ans = []
        actual = Counter(p)
        n = len(s)

        current_count = Counter()
        k = len(p) # window size
        if k > n:
            return []
        for i in range(k):
            current_count[s[i]] += 1
        
        if actual == current_count:
            ans.append(0)

        left = 0
        for right in range(k , n):
            current_count[s[right]] += 1

            current_count[s[left]] -= 1

            if current_count[s[left]] == 0:
                del current_count[s[left]]
                # .pop
            left += 1

            if current_count == actual:
                ans.append(left)
        return ans
        

        
