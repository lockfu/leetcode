package algo.tree;

public class Heap {

	private int[] A;
	private int curSize;
	private int cap;
	public Heap(int[] A, int cap) {
		A = new int[cap];
		curSize = 0;
	}
	
	public void swap(int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}

	public void createMin() {
		for (int i = curSize / 2; i >= 0; i--) {
			siftdownMin( i);
		}
	}
	
	public void createMax(int[] A) {
		for (int i = curSize / 2; i >= 0; i--) {
			siftdownMax(i);
		}
	}

	// 向下
	public void siftdownMin( int i) {
		int t = i, flag = 0;
		while (i * 2 < curSize && flag == 0) { // 有儿子节点
			if (A[i] > A[i * 2]) //
				t = i * 2;
			if (i * 2 + 1 < curSize) {
				if (A[t] > A[i * 2 + 1])
					t = i * 2 + 1;
			}
			if (t != i) {
				swap(t, i);
				i = t;
			} else {
				flag = 1;
			}
		}
	}

	// 向下
	public void siftdownMax( int i) {
		int t = i, flag = 0;
		while (i * 2 < curSize && flag == 0) { // 有儿子节点
			if (A[i] < A[i * 2]) //
				t = i * 2;
			if (i * 2 + 1 < curSize) {
				if (A[t] < A[i * 2 + 1])
					t = i * 2 + 1;
			}
			if (t != i) {
				swap(t, i);
				i = t;
			} else {
				flag = 1;
			}
		}
	}

	// 向上
	public void siftupMin( int i) {
		if (i == 0)
			return;
		int flag = 0;
		while (i != 0 && flag == 0) {
			if (A[i / 2] < A[i])
				swap(i / 2, i);
			else
				flag = 1;
			i = i / 2;
		}
	}

	// 向上
	public void siftupMax( int i) {
		if (i == 0)
			return;
		int flag = 0;
		while (i != 0 && flag == 0) {
			if (A[i / 2] > A[i])
				swap(i / 2, i);
			else
				flag = 1;
			i = i / 2;
		}
	}

	public  int deletemin() {
		int t = A[0];
		A[0] = A[curSize - 1];
		curSize--;
		siftdownMin(0);
		return t;
	}

}
