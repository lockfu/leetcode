package math;

public class FacTailZero {
	public int trailingZeroes(int n) {
        int count  = 0;
        while(n >= 5){
            n = n/5;
            count += n;
        }
        return count;
    }
	public int trailingZeroes1(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }
}
