class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;

        List<Integer> ans = new ArrayList<>();

        while(i < n)
        {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct])
            {
                swap(nums, i, correct);
            }
            else
            {
                i++;
            }
        }
        for(i = 0; i < n ; i++)
        {
            if(nums[i] != i+1)
            {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    private void swap(int[] nums, int first, int second)
    {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}