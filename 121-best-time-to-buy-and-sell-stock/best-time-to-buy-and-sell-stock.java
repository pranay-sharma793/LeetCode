class Solution {
    public int maxProfit(int[] p) {

        int max_profit = 0;
        int b = 0;
        int s = b+1;
        
        while(s < p.length){

            if(p[b] < p[s]){
                max_profit = Math.max((p[s] - p[b]), max_profit);
            } else if(p[b] > p[s]){
                b = s;
                // s = s+1;
            }

            s++;
        }

        return max_profit;
    }
}