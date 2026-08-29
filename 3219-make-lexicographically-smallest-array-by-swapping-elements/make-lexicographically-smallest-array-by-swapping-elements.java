class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] indexedNums = new int[n][2];
        for (int i = 0; i < n; i++) 
        {
            indexedNums[i][0] = nums[i];
            indexedNums[i][1] = i;
        }
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[n];
        int i = 0;
        while (i < n) {
            int start = i;
            i++;
            while (i < n && indexedNums[i][0] - indexedNums[i - 1][0] <= limit) 
            {
                i++;
            }
            List<Integer> indices = new ArrayList<>();
            for (int j = start; j < i; j++) 
            {
                indices.add(indexedNums[j][1]);
            }
            Collections.sort(indices);
            for (int j = 0; j < indices.size(); j++) {
                result[indices.get(j)] = indexedNums[start + j][0];
            }
        }
        return result;
    }
}