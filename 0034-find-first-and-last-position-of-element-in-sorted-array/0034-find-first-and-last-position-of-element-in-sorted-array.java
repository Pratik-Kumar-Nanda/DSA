class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = BinarySearch(nums, target, true);
        int last = BinarySearch(nums, target, false);

        return new int[] {first, last};
        
    }
    private int BinarySearch(int[] nums , int target , boolean isFirst)
    {
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
         while(start<=end)
         {
            int mid = start + (end-start)/2;
            if(nums[mid] < target)
                start = mid+1;
            else if(nums[mid] > target)
                end = mid-1;
            else
            {
                ans = mid;
                if(isFirst)
                    end = mid-1;
                else
                    start = mid+1;
            }
         }
         return ans;
    }
}