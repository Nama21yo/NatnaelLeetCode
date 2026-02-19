from math import isqrt

class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        n = len(s)

        prefix_ones = [0] * (n + 1)
        for idx, ch in enumerate(s):
            prefix_ones[idx + 1] = prefix_ones[idx] + (ch == '1')

        zero_positions = [idx for idx, ch in enumerate(s) if ch == '0']
        total_zeros = len(zero_positions)

        total_substrings = 0

        index = 0
        while index < n:
            if s[index] == '0':
                index += 1
                continue

            run_start = index
            while index < n and s[index] == '1':
                index += 1

            run_length = index - run_start
            total_substrings += run_length * (run_length + 1) // 2

        max_zero_count = isqrt(n) + 2

        def count_ones(left, right):
            return prefix_ones[right + 1] - prefix_ones[left]

        for first_zero_idx in range(total_zeros):

            left_min = 0 if first_zero_idx == 0 else zero_positions[first_zero_idx - 1] + 1
            left_max = zero_positions[first_zero_idx]

            if left_min > left_max:
                continue

            for zero_count in range(1, max_zero_count + 1):

                last_zero_idx = first_zero_idx + zero_count - 1
                if last_zero_idx >= total_zeros:
                    break

                right_min = zero_positions[last_zero_idx]
                right_max = (
                    zero_positions[last_zero_idx + 1] - 1
                    if last_zero_idx + 1 < total_zeros
                    else n - 1
                )

                if right_min > right_max:
                    continue

                required_ones = zero_count * zero_count
                right_ptr = right_min

                for left in range(left_min, left_max + 1):

                    if prefix_ones[right_max + 1] - prefix_ones[left] < required_ones:
                        continue

                    while right_ptr <= right_max and count_ones(left, right_ptr) < required_ones:
                        right_ptr += 1

                    if right_ptr > right_max:
                        break

                    total_substrings += (right_max - right_ptr + 1)

        return total_substrings
