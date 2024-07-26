class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        int b = 0;


        for(int i : nums){
            int tmp =map.getOrDefault(i, 0);
            map.put(i, tmp+1);
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
