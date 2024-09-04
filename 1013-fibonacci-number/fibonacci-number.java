class Solution {
    // Iterarive approach
    public int fib1(int n) {

        if(n == 0) return 0;

        if(n == 1) return 1;

        return fib(n-1) + fib(n-2);
        //TIme: O(2*n)
        //Space: O(2n)
    }

    // top down
    public int fib2(int n) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        map.put(1, 1);

        return helper(map, n);
        //TIme: O(n)
        //Space: O(n)
        
    }

    private int helper(Map<Integer, Integer> map, int n){

        if(map.containsKey(n)) return map.get(n);
        else {
            int prev1 = helper(map, n-1);
            int prev2 = helper(map, n-2);
            map.put(n, prev1 + prev2);
        }

        return map.get(n);

    }

    // bottom up in constant time
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int curr = 1;
        int prev = 0;

        for(int i = 2; i <= n; i++){
            int tmp = curr;
            curr += prev;
            prev = tmp;
        }

        return curr;

        //TIme: O(n)
        //Space: O(1)
    }
}