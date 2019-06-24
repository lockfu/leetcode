package arrayandstring2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSumCount {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		List<Integer> L = new ArrayList<>();
		List<Integer> R = new ArrayList<>();
		int len = A.length;
		for(int i = 0; i<len; i++){
			for(int j = 0; j<len; j++){
				L.add(A[i]+B[j]);
			}
		}
		for(int i = 0; i<len; i++){
			for(int j = 0; j<len; j++){
				R.add(C[i]+D[j]);
			}
		}
		int res = 0;
		for(int l : L){
			for(int r : R){
				if((l+r) == 0)
					res++;
			}
		}
		return res;
	}
	public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();
		int len = A.length;
		for(int i = 0; i<len; i++){
			for(int j = 0; j<len; j++){
				int tmp = A[i]+B[j];
				if(map.containsKey(tmp))
					map.put(tmp, map.get(tmp)+1);
				else
					map.put(tmp, 1);
			}
		}
		int res = 0;
		for(int i = 0; i<len; i++){
			for(int j = 0; j<len; j++){
				int tmp = C[i]+D[j];
				if(map.containsKey(-tmp))
					res += map.get(-tmp);
			}
		}
		return res;
	}

}
