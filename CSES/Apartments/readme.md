# Apartment Allocation Problem

## Problem Description
You are given `n` applicants and `m` free apartments. Your task is to allocate apartments so that the maximum number of applicants receive an apartment.

Each applicant has a desired apartment size and will accept any apartment whose size falls within an acceptable range determined by a given tolerance `k`.

## Input Format
- The first line contains three integers `n`, `m`, and `k`:
  - `n`: Number of applicants
  - `m`: Number of available apartments
  - `k`: Maximum allowed difference between an applicant’s desired size and an available apartment’s size
- The second line contains `n` integers: the desired apartment sizes of each applicant.
- The third line contains `m` integers: the sizes of available apartments.

## Output Format
- Print a single integer: the maximum number of applicants who can get an apartment.

## Constraints
- `1 \leq n, m \leq 2 \times 10^5`
- `0 \leq k \leq 10^9`
- `1 \leq a_i, b_i \leq 10^9`

## Example
### Input:
```
4 3 5
60 45 80 60
30 60 75
```
### Output:
```
2
```

## Explanation
- The first applicant (60) can get the second apartment (60).
- The second applicant (45) cannot get any apartment within `k` range.
- The third applicant (80) can get the third apartment (75).
- The fourth applicant (60) can get the second apartment (60), but it is already taken.
- Thus, a maximum of **2 applicants** receive an apartment.

