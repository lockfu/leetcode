package chap06;

public class GetNumOfK {
	public static int getNumofK(int[] A, int k){
		if(null == A || A.length <= 0) return 0;
		int first = getFirstK(A, k, 0, A.length-1);
		int last = getLastK(A, k, 0, A.length-1);
		if(first > -1 && last > -1)
			return last - first + 1;
		return 0;
	}
	
	public static int getFirstK(int[] A, int k, int s, int e){
		if(s > e) return -1;
		int mid = (s + e) / 2;
		int middata = A[mid];
		if(middata == k){
			if(mid > 0 && A[mid-1] != middata || mid == 0)
				return mid;
			e = mid - 1;
		}else if(middata > k){
			e = mid - 1;
		}else{
			s = mid + 1;
		}
		return getFirstK(A, k, s, e);
	}
	
	public static int getLastK(int[] A, int k, int s, int e){
		if(s > e) return -1;
		int mid = (s + e) / 2;
		int middata = A[mid];
		if(middata == k){
			if(mid < A.length - 1 && A[mid+1] != middata || mid == A.length-1)
				return mid;
			s = mid + 1;
		}else if(middata < k){
			s = mid + 1;
		}else{
			e = mid - 1;
		}
		return getLastK(A, k, s, e);
	}
	
	// ------------------------------------
	
	public int GetNumberOfK(int [] A , int k) {
	       if(null == A || A.length <= 0) return 0;
	        int l = findLeft(A, k);
	        int r = findRight(A, k);
	        if(l == -1 || r == -1) return 0;
	        return r - l + 1;
	    }
	    
	    public int findLeft(int[] A, int k){
	        int l = 0, r = A.length-1;
	        while(l<=r){
	            int mid = (l+r) >> 1;
	            if(A[mid] == k){
	                if(mid == 0 || A[mid-1] != k)
	                    return mid;
	                r = mid-1;
	            }else if(A[mid] > k)
	                r = mid-1;
	            else
	                l = mid+1;
	        }
	        return -1;
	    }
	    
	    public int findRight(int[] A, int k){
	        int l = 0, r = A.length-1;
	        while(l<=r){
	            int mid = (l+r) >> 1;
	            if(A[mid] == k){
	                if(mid == A.length-1 || A[mid+1] != k)
	                    return mid;
	                l = mid+1;
	            }else if(A[mid] > k)
	                r = mid-1;
	            else
	                l = mid+1;
	        }
	        return -1;
	    }
	
	public static void main(String[] args) {
		int[] A = {1,2,3,3,4,4,4,5,5,6,7,7,7,7,8};
		int k = 9;
		int res = getNumofK(A, k);
		System.out.println(res);
	}
}
