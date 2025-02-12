class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        seats.sort()
        students.sort()

        diff = 0
        for seat,student in zip(seats,students):
            diff += abs(student - seat)
        return diff

        