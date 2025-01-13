package leetCode;



public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumber sn =new SingleNumber();
        System.out.println(sn.singleNumber(new int[]{2,2,1,3,3}));;
    }
}
