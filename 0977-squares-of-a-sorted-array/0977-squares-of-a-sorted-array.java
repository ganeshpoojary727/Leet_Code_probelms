class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0,j=nums.length-1,k=nums.length-1;
        int[] arr=new int[nums.length];
        while(i<=j){
            if (Math.abs(nums[i])> Math.abs(nums[j])){
                arr[k]=nums[i]*nums[i];
                k--;
                i++;
            }
            else{
                arr[k]=nums[j]*nums[j];
                k--;
                j--;
            }

        }
        return arr;
    }
}