package math;

public class Sqrt {
	public int mySqrt(int x){ // Å£¶Ùµü´ú·¨
		if(x == 0) return 0;
		long i = x;
		while(i*i > x){
			i = (i+x/i)/2;
		}
		return (int)i;
	}
	
	public int mySqrt1(int x){
		if(x == 0) return 0;
		int l = 1, r = x;
		while(true){
			int mid = l + (r-l)/2;
			if(mid > x/mid)
				r = mid - 1;
			else{
				if(mid+1 > x/(mid+1))
					return mid;
				l =mid+1;
			}
		}
	}
	
}
