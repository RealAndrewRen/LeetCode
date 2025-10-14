class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        last = len(nums) - 1
        i = 0
        while i <= last:
            if nums[i] == val:
                nums[i] = nums[last]
                nums[last] = val
                last -= 1
            else:
                i += 1
        return i
        