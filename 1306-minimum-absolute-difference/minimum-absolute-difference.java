class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        int min = arr[1] - arr[0];

        for(int i=1; i < arr.length; i++){
            int val1 = arr[i];
            int val2 = arr[i-1];
            int currDiff = val1 - val2;

            if(currDiff < min){
                min = currDiff;
                result.clear();
                result.add(Arrays.asList(arr[i-1], arr[i]));
            } else if(currDiff == min){
                result.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }

        return result;
        
    }
}