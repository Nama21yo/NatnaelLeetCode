from typing import List

class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        result = []
        
        for h in range(12):        # hours: 0 to 11
            for m in range(60):    # minutes: 0 to 59
                if (bin(h).count("1") + bin(m).count("1")) == turnedOn:
                    result.append(f"{h}:{m:02d}")  # minutes always 2 digits
                    
        return result
