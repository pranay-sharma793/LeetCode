class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxVal = -1;

        for(int n : piles){
            maxVal = Math.max(maxVal, n);
        }

        int start = 1;
        int end = maxVal;

        int minH=0;

        // System.out.println("We have max  " + maxVal);

        while(start <= end){

            int mid = start + (end - start)/2;

            // System.out.println("mid, current minH, start and end. " + mid + " " + minH + " " + start + " " + end);

            if(canKokoEat(piles, mid, h)){
                minH = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        
        return minH;
    }

    private boolean canKokoEat(int[] nums, int k, int h){
        double val = 0;
        for(int n : nums){
            double tmp = (n + k - 1) / k;
            val += tmp;
        }

        // System.out.println("val , h " + val + " " + h);

        if((int)val <= h) return true;
        
        return false;
    }
}