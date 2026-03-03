class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        rows = len(matrix)
        cols = len(matrix[0])
        left = 0
        right = cols - 1
        bottom = rows - 1
        top = 0
        # [1,2,3,4,8,12,11,10,9,5,6,7,6]
        # [1,2,3,4,8,12,11,10,9,5,6,7]

        answer = []
        # rows != cols
        # 3 * 4
        # l = 0 , r = 3, b = 2, t = 0
        # t=0 , 0 -> 4
        # top = 1, [1,2,3,4]
        # right = 3, 1 -> 3
        # right = 2, [1,2,3,4,8,12]
        # bottom = 2, 2 -> -1
        # bottom = 1, [1,2,3,4,8,12,11,10,9]
        # left = 0, 1 -> 0
        # left = 1 , [1,2,3,4,8,12,11,10,9, 5]
        
        #t = 1, 1 -> 3
        # top = 2, [1,2,3,4,8,12,11,10,9, 5, 6, 7]
        
        # right = 2, 2 -> 1
        # no loop
        # right = 1

        # right -> left
        # bottom = 1, 1 -> 0
        # revisiting 6

        # 
        while left <= right and top <= bottom:
            # on top
            # left -> right
            for i in range(left, right + 1):
                answer.append(matrix[top][i])
            top += 1

            # on right
            # top -> bottom
            # print(left, right, bottom, top)
            # 0 2 3 1
            for i in range(top, bottom + 1):
                answer.append(matrix[i][right])
            right -= 1

            # on bottom
            # right -> left
            if top <= bottom:
                for i in range(right , left - 1, -1):
                    answer.append(matrix[bottom][i])
                bottom -= 1
            # on the left
            # b -> t
            if left <= right:
                for i in range(bottom, top - 1, -1):
                    answer.append(matrix[i][left])
                left += 1
        
        return answer