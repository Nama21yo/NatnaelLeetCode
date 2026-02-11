class Solution:
    def findCommonResponse(self, responses: List[List[str]]) -> str:

        hash={}
    
        for i in range(len(responses)):
            temp=set(responses[i])

            for t in temp:
                hash[t]=hash.get(t,0)+1
            temp=set()
                

        maxval=max(hash.values())
        mostcommon=[key for key in hash.keys() if hash[key]==maxval ]

        if len(mostcommon)>1:
            return min(mostcommon)

        return mostcommon[0]