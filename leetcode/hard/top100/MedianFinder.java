package top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
//    private ArrayList<Integer> list;
//	/** initialize your data structure here. */
//	public MedianFinder() {
//		list = new ArrayList<>();
//	}
//
//	public void addNum(int num) {
//		if(list.isEmpty()){
//			list.add(num);
//			return;
//		}
//		int i = 0;
//		while(i < list.size() && list.get(i) < num){
//			i++;
//		}
//		list.add(i, num);
//	}
//	public double findMedian() {
//		return list.size() % 2 == 0 ? (list.get((list.size()/2)-1) + list.get(list.size()/2))/2d: list.get(list.size()/2);
//	}
	
	private PriorityQueue<Integer> min = new PriorityQueue<>();
	private PriorityQueue<Integer> max = new PriorityQueue<>(100, Collections.reverseOrder());
	
	/** initialize your data structure here. */
	public MedianFinder() {
	}

	public void addNum(int num) {
		max.offer(num);
		min.offer(max.poll());
		if(max.size() < min.size())
			max.offer(min.poll());
	}
	public double findMedian() {
		return max.size() == min.size() ? (max.peek() + min.peek())/2.0: max.peek();
	}
	
	
	
	
	public static void main(String[] args) {
		PriorityQueue<Integer> mm = new PriorityQueue<>(100, Collections.reverseOrder());
		mm.add(2);
		mm.add(5);
		mm.add(1);
		mm.add(10);
		mm.add(3);
		mm.add(20);
		while(!mm.isEmpty()){
			System.out.println(mm.poll());
		}
	}
}

class IntCmp implements Comparable<IntCmp> {
	int x;

	public IntCmp(int x) {
		this.x = x;
	}

	@Override
	public int compareTo(IntCmp o) {
		return this.x - o.x;
	}

	@Override
	public String toString() {
		return x + "";
	}
}
