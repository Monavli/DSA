# 3Sum (LeetCode 15)

## 📌 Problem Statement
Given an integer array `nums`, return all the unique triplets `[nums[i], nums[j], nums[k]]`
such that `nums[i] + nums[j] + nums[k] == 0`.

The solution set must not contain duplicate triplets.

---

## 🧠 Approach (Sorting + Two Pointers)

1. Sort the array
2. Fix one element at index `i`
3. Use two pointers `left` and `right`
4. Adjust pointers based on sum
5. Skip duplicates to avoid repeated triplets

---

## ✅ Algorithm
1. Sort the array
2. Loop from `i = 0` to `n-3`
3. Skip duplicate values of `i`
4. Use two pointers to find pairs
5. If sum is zero → store triplet
6. Skip duplicates for `left` and `right`

---

## 💻 Java Implementation

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
