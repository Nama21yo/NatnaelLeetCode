class Solution:
    def generate(self, numRows):
        result = []
        
        for row_number in range(1, numRows + 1):
            result.append(self.generate_row(row_number))
        
        return result
    
    def generate_row(self, row_number):
        row = []
        element = 1
        row.append(element)
        
        for i in range(1, row_number):
            element = element * (row_number - i)
            element = element // i
            row.append(element)
        
        return row
