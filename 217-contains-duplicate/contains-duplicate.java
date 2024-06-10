class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> m = new HashSet<>();

        for(int n: nums){
            if(!m.add(n))
                return true;
            m.add(n);
        }

        return false;
        
    }
}