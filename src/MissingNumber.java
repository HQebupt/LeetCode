public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int complete = 0, local = 0;
        for (int i = 0; i < len; i++) {
        	complete ^= i;
        	local ^= nums[i];
        }
        return complete ^ len ^ local;
    }
    
    public static void main(String[] args) {
    	MissingNumber sol = new MissingNumber();
    	int[] nums = {0,1,3};
    	System.out.println(sol.missingNumber(nums));
    }
}