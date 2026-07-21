class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int ans = -1;

        if((long)m*k > bloomDay.length)
        {
            return ans;
        }

        for(int bloom : bloomDay)
        {
            start = Math.min(start, bloom);
            end = Math.max(end, bloom);
        }

        while(start <= end)
        {
            int mid = start + (end - start)/2;
            int bouquets = noOfBouquets(bloomDay, k, mid);

            if(bouquets >= m)
            {
                ans = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return ans;

    }

    private int noOfBouquets(int[] bloomDay, int k, int mid)
    {
        int count = 0;
        int bouquets = 0;
        for(int bloom : bloomDay)
        {
            if(bloom <= mid)
            {
                count++;
            }
            else
            {
                bouquets += count / k;
                count = 0;
            }
        }
        bouquets += count/k;
        return bouquets;
    }

}