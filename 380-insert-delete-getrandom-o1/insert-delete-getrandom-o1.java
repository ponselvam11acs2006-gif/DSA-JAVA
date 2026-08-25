class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> numToIndex;
    private Random rand;
    public RandomizedSet() {
        nums = new ArrayList<>();
        numToIndex = new HashMap<>();
        rand = new Random();
    }
    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false;
        }
        numToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }
    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false;
        }
        int index = numToIndex.get(val);
        int lastElement = nums.get(nums.size() - 1);
        nums.set(index, lastElement);
        numToIndex.put(lastElement, index);
        nums.remove(nums.size() - 1);
        numToIndex.remove(val);
        return true;
    }
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}