class Solution {
    public void rotate(int[] nums, int k) {
       int len = nums.length;
       k = k%len;

       perform(nums,0,len-1);
       perform(nums,0,k-1);
       perform(nums,k,len-1);
    }
    static void perform(int[] nums, int left, int right)
    {
        while(left<right)
        {
            int temp = nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            left++;
            right--;
        }
    }
}