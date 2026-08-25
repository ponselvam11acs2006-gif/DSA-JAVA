class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] counts = new int[1001];
        for (int num : nums1) 
        {
            counts[num]++;
        }
        int[] tempResult = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) 
        {
            if (counts[num] > 0) 
            {
                tempResult[index++] = num;
                counts[num]--;
            }
        }
        return Arrays.copyOfRange(tempResult, 0, index);
    }
}