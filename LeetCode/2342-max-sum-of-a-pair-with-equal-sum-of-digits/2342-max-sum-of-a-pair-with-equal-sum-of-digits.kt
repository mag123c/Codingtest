class Solution {
    fun maximumSum(nums: IntArray): Int {
        val digitsMap = mutableMapOf<Int, MutableList<Int>>()

        for (num in nums) {
            val digitSum = num.toString().sumOf { it.digitToInt() }

            digitsMap.putIfAbsent(digitSum, mutableListOf())
            digitsMap[digitSum]?.add(num)
        }

        var maxSum = -1


        for ((_, list) in digitsMap) {
            if (list.size > 1) {
                list.sortDescending()
                maxSum = maxSum.coerceAtLeast(list[0] + list[1])
            }
        }

        return maxSum;
    }
}