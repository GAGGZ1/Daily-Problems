# String Swap Transformation

## Problem Statement
Given a string and a set of `(m * 2)` matrix where the matrix contains pairs of characters to swap.
The user needs to swap every character that matches the characters in the string until all pairs in the matrix are processed.

**Note:** The string is updated after every swap, and subsequent swaps must be performed on the new string.

## Example

### Input:
```plaintext
String: "abcde"
Matrix: [['a', 'b'], ['b', 'c'], ['e', 'd']]
```

### Process:
1. Swap 'a' with 'b' → "bacde"
2. Swap 'b' with 'c' → "cacde"
3. Swap 'e' with 'd' → "cacdd"

### Output:
```plaintext
"cacdd"
```
