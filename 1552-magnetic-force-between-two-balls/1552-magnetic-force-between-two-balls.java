class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int start = 1;
        int end = position[position.length - 1] - position[0];

        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(canWePlace(position, m, mid))
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return end;
    }

    private boolean canWePlace(int[] position, int m, int force)
    {
        int prev = position[0];
        int count_mag = 1;
        for(int i = 1; i < position.length; i++)
        {
            if(position[i] - prev >= force)
            {
                count_mag++;
                prev = position[i];
            }
            if(count_mag == m)
            {
                return true;
            }
        }
        return false;
    }
}