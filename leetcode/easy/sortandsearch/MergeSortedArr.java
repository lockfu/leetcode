package sortandsearch;

public class MergeSortedArr {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sum = m + n;
        for(int i1 = m-1, i2 = n - 1, i3 = sum -1; i3>=0; i3-- ){
            if(i2 < 0)
                break;
            if(i1 < 0){
                for(;i2 >= 0; i2--){
                    nums1[i3] = nums2[i2];
                    i3--;
                }
                break;
            }
            if(nums1[i1] > nums2[i2]){
                nums1[i3] = nums1[i1];
                i1--;
            }else{
                nums1[i3] = nums2[i2];
                i2--;
            }
        }
    }
}
