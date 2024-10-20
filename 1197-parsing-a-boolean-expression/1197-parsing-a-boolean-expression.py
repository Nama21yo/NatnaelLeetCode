class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        st = []
        temp = ' '

        for ch in expression:
            if ch == '(' or ch == ',':
                continue  # Skip '(' and ','

            if ch in ['t', 'f', '!', '&', '|']:
                st.append(ch)
            elif ch == ')':
                has_true = False
                has_false = False

                # Process until reaching the operator
                while st and st[-1] in ['t', 'f']:
                    val = st.pop()
                    if val == 't':
                        has_true = True
                    if val == 'f':
                        has_false = True

                # Pop the operator if stack isn't empty
                if st:
                    operator = st.pop()

                    # Evaluate the result based on the operator
                    if operator == '|':
                        temp = 't' if has_true else 'f'  # OR operation
                    elif operator == '&':
                        temp = 'f' if has_false else 't'  # AND operation
                    elif operator == '!':
                        temp = 'f' if has_true else 't'  # NOT operation

                    # Push the result back to stack
                    st.append(temp)

        # The final result is the last element in the stack
        return st and st[-1] == 't'
