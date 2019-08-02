package chap06;

import java.util.LinkedList;

public class LastRemaining {
	public static int lastRemain(int n, int m){
		if(n < 1 || m < 1) return -1;
		int last = 0;
		for(int i = 2; i<=n; i++){
			last = (last + m) % i;
		}
		return last;
	}
	
	public static int lastRemain_link(int n, int m){
		if(n < 1 || m < 1) return -1;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i<n; i++)
			list.add(i);
		int bt = 0;
		while(list.size() > 1){
			bt = (bt + m - 1) % list.size();
			list.remove(bt);
		}
		return list.size() == 1 ? list.get(0):-1;
	}
}
