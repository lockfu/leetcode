package chap06;

import java.util.Deque;
import java.util.LinkedList;

public class MaxQueue {
	private Deque<QNode> data = new LinkedList<>();
	private Deque<QNode> max = new LinkedList<>();
	private static int curindex = 0;
	public MaxQueue() {
		// TODO Auto-generated constructor stub
	}
	public void push(int num){
		while(!max.isEmpty() && num > max.getLast().data){
			max.removeLast();
		}
		QNode cur = new QNode(curindex, num);
		data.addLast(cur);
		max.addLast(cur);
		++curindex;
	}
	
	public int pop(){
		if(max.isEmpty() || data.isEmpty())
			throw new RuntimeException("Queue Is Empty!!");
		if(max.getFirst().index == data.getFirst().index)
			max.removeFirst();
		return data.removeFirst().data;
	}
	
	public int getMax(){
		if(max.isEmpty())
			throw new RuntimeException("Queue Is Empty!!");
		return max.getFirst().data;
	}
	
	public static void main(String[] args) {
		MaxQueue q = new MaxQueue();
		q.push(1);
		q.push(3);
		System.out.println(q.getMax());
		q.push(5);
		q.push(4);
		System.out.println(q.getMax());
	}
}

class QNode{
	public int index;
	public int data;
	public QNode(int index, int data){
		this.index = index;
		this.data = data;
	}
}
