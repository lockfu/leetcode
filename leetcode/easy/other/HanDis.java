package other;

public class HanDis {
	public int hammingDistance(int x, int y) {
		int res = 0, yh = x ^ y;
		for(int i = 0; i<32; i++){
			res += (yh >> i) & 1;
		}
		return res;
	}
}
