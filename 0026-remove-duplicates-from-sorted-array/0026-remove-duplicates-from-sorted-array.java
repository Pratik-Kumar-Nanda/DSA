class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int left = 0,right = 0;
        while(right < nums.length)
        {
            if(nums[left]==nums[right])
                right++;
            else
            {
                left++;
                nums[left] = nums[right];
                right++;
            }       
        }
        return left+1;
    }
}