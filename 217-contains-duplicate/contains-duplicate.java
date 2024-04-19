class Solution {
    public boolean containsDuplicate(int[] nums) {

        //HashSet<> gives a slight better run time than Set<>
        HashSet<Integer> hr = new HashSet<>();

        for(int n : nums){
            if(hr.contains(n))
                return true;
            
            hr.add(n);
        }
        
        return false;
    }

}