class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        min = -1
        gas = 0
        for n in nums:
            if gas < 0:
                return min
            elif n > gas:
                gas = n
                min = min + 1
            gas -= 1
        return min
