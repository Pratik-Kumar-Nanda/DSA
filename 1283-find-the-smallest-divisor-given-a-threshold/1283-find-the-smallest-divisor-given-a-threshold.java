class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;

        for (int num : nums)
        {
            end = Math.max(end, num);
        }

        while(start < end)
        {
            int mid = start + (end - start)/2;
            if(isPossible(nums, mid, threshold))
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return end;
    }

    private boolean isPossible(int[] nums, int divisor, int threshold)
    {
        int sum = 0;
        for(int num : nums)
        {
            sum += (num + divisor - 1) / divisor;
            if(sum > threshold)
            {
                return false;
            }
        }
        return true;
    }
}