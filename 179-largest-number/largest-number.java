class Solution {
    public static String largestNumber(int[] nums){

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                String n1 = Integer.toString(nums[j]);
                String n2 = Integer.toString(nums[j+1]);

                if(compareNums(n1, n2)){
                    // Swap arr[j] and arr[j + 1]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Boolean nonZeroFlag = false;
        for(int i=n-1; i >=0; i--){
            if(nums[i] != 0) nonZeroFlag=true;

            String num = Integer.toString(nums[i]);
            sb.append(num);
        }

        if(!nonZeroFlag) return "0";

        return sb.toString();
    }

    private static boolean compareNums(String n1, String n2) {

        return (n1+n2).compareTo(n2+n1) >= 0;
    }
}