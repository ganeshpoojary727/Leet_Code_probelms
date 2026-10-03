class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i=0,j=0,k=0;
    int size=m+n;
    int[] arr=new int[size];
    while(k<size){
        if(i==m){
            while(j!=n){
                arr[k]=nums2[j];
                k++;
                j++;
            }
        }
        else if(j==n){
            while(i!=m){
                arr[k]=nums1[i];
                k++;
                i++;
            }
        }
        else if(nums1[i]<nums2[j]){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        else{
            arr[k]=nums2[j];
            j++;
            k++;
        }
    }
    for(int p=0;p<size;p++){
        nums1[p]=arr[p];
    }
    }
}