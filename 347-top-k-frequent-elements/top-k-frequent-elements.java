class Solution {

    /* 
    Easiest approach to this is sorting the map values using collections, then creating a sublist of k elements. Picking the element key from the map with value from the topK list.

    Learnings: Extracting map values in an list, collections sort on a list and reverse, creating subList, 
    using list contains.

    Alternative solutions: priority queue, bucket sort, min/max heap
    */


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        int b = 0;


        for(int i : nums){
            map.put(i , map.getOrDefault(i, 0) + 1);
        }

        List<Integer> vals = new ArrayList<>(map.values());
        Collections.sort(vals, Collections.reverseOrder());

        List<Integer> topK = vals.subList(0, Math.min(k, vals.size()));

        for(Map.Entry<Integer, Integer> val: map.entrySet()){
            if(topK.contains(val.getValue())){
                ans[b] = val.getKey();
                b++;
            }
        }

        return ans;
        
    }
}
