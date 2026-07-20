class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        int ans = Integer.MAX_VALUE;

        for (int nums : piles)
        {
            end = Math.max(end, nums);
        }

        if(piles.length == h)
        {
            return end;
        }

        while(start <= end)
        {
            int mid = start + (end - start)/2;
            int time = Total_time(piles, mid);

            if(time <= h)
            {
                ans = Math.min(ans,mid);
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }  
        }
        return ans;
    }

    private int Total_time(int[] piles, double k)
    {
        double hours = 0;
        for(int banana : piles)
        {
            hours += Math.ceil(banana/k);
        }
        return (int)hours;
    }
}