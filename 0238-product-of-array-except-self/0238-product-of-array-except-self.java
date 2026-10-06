class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr=new int[nums.length];
        int prefix=1;
        for(int i=0;i<nums.length;i++){
           arr[i]=prefix;
           prefix*=nums[i];
        }
        int suffix=1;
         for(int i=nums.length-1;i>=0;i--){
           arr[i]=arr[i]*suffix;
          suffix*=nums[i];
        }
        return arr;
    }
}