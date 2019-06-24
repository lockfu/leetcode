package other;

import java.util.Arrays;

public class MedianOfTwoSortedArr {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] res = null;
		if(null == nums1 || nums1.length <= 0)
			res = nums2;
		else if(null == nums2 || nums2.length <= 0)
			res = nums1;
		if(null != res){
			if(res.length == 1)
				return (double)res[0];
			return res.length % 2 == 0 ?  (double)(res[res.length/2-1] +  res[res.length/2]) / 2d: (double)res[res.length/2];
		}
		int n1 = 0, n2 = 0, len1 = nums1.length, len2 = nums2.length;
		res = new int[len1+len2];
		int count = 0;
		while(true){
			int tmp = nums1[n1] <= nums2[n2] ? nums1[n1++] : nums2[n2++];
			res[count++] = tmp;
			if(n1 == len1){
				while(n2 < len2)
					res[count++] = nums2[n2++];
				break;
			}else if(n2 == len2){
				while(n1 < len1)
					res[count++] = nums1[n1++];
				break;
			}
		}
		return res.length % 2 == 0 ?  (double)(res[res.length/2-1] +  res[res.length/2]) / 2d: (double)res[res.length/2];
	}
	public static void main(String[] args) {
		int[] nums1 = {3,4};
		int[] nums2 = {1,2,3,4};
		double res = findMedianSortedArrays(nums1,nums2); 
		System.out.println(res);
	}
}
