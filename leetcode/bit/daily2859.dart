void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.sumIndicesWithKSetBits([5, 10, 1, 5, 2], 1));
  // case2
  print(solution.sumIndicesWithKSetBits([4, 3, 2, 1], 2));
}

class Solution {
  int sumIndicesWithKSetBits(List<int> nums, int k) {
    int size = nums.length;
    int ans = 0;
    for (int i = 0; i < size; i++) {
      if (bitCount(i) == k) {
        ans += nums[i];
      }
    }

    return ans;
  }

  /**
     * 使用Brian Kernighan算法。该算法的基本思想是：对于任意整数n，n & (n - 1)总是能把n的最低位的1变成0，并保持其他位不变。
     */
  int bitCount(int i) {
    int count = 0;
    while (i != 0) {
      i &= (i - 1);
      count++;
    }

    return count;
  }
}
