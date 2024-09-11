class Solution {

    public int minBitFlips(int start, int goal) {
        // XOR start and goal to find the bits that differ
        int differingBits = start ^ goal;
        
        // Count the number of set bits (1s) in the differingBits
        return countSetBits(differingBits);
    }

    private int countSetBits(int num) {
        int count = 0;
        // Count bits set to 1
        while (num != 0) {
            count += num & 1; // Add 1 if the least significant bit is 1
            num >>= 1; // Right shift num by 1 bit
        }
        return count;
    }
}