class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        counts = {}
        for i in range(len(nums)):
            key = nums[i]
            counts[key] = counts.get(key, 0) + 1
            if counts[key] >= 2:
                return True
        return False