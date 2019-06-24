package array;

import java.util.Arrays;

public class Intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
//		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
//			return null;
		int len1 = nums1.length;
		int len2 = nums2.length;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int min = len1 > len2 ? len2 : len1;
		int[] res = new int[min];
		int count = 0;
		for(int i = 0,j = 0; i<len1&&j<len2; ){
			if(nums1[i] < nums2[j]){
				i++;
				continue;
			}else if(nums1[i] > nums2[j]){
				j++;
				continue;
			}else if(nums1[i] == nums2[j])
				res[count++] = nums1[i];
			i++;
			j++;
		}
		return Arrays.copyOf(res, count);
		
	}
}
