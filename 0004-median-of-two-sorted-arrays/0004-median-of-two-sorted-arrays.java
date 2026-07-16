class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1_size = nums1.length;
        int nums2_size = nums2.length;

        if (nums1_size > nums2_size)
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = (nums1_size + nums2_size + 1) / 2;
        int total = nums1_size + nums2_size;

        int start = 0;
        int end = nums1_size;

        while(start <= end)
        {
            int mid1 = start + (end - start)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1 < nums1_size)
            {
                r1 = nums1[mid1];
            }
            if(mid2 < nums2_size)
            {
                r2 = nums2[mid2];
            }
            if(mid1 > 0)
            {
                l1 = nums1[mid1-1];
            }
            if(mid2 > 0)
            {
                l2 = nums2[mid2-1];
            }
            if(l1 <= r2 && l2 <= r1)
            {
                if(total % 2 == 1)
                {
                    return Math.max(l1, l2);
                }
                else
                {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
            else if (l1 > r2)
            {
                end = mid1 - 1;
            }
            else
            {
                start = mid1 + 1;
            }
        }
        return 0;
    }
}