package searchandsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Intervals {
	class Interval{
		public int start;
		public int end;
		public Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
	}
	public List<Interval> intervals(List<Interval> intervals){
		LinkedList<Interval> res = new LinkedList<>();
		if(null == intervals || intervals.size() <= 0)
			return res;
		LinkedList<Interval> linked = new LinkedList<>();
		for(Interval inter : intervals){
			if(linked.size() == 0){
				linked.add(inter);
				continue;
			}
			int size = linked.size();
			for(int i = 0; i<size; i++){
				Interval cur = linked.get(i);
				if(cur.start >= inter.start){
					linked.add(i, inter);
					break;
				}else if(i == linked.size() - 1)
					linked.add(inter);
			}
		}
//		return linked;
		for(Interval item : linked){
			if(res.isEmpty() || linked.getLast().end < item.start)
				res.add(item);
			else
				res.getLast().end = Math.max(linked.getLast().end, item.end);
		}
		return res;
	}
	
	
	private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		List<Interval> res = new ArrayList<>();
		Intervals iv = new Intervals();
		res.add(iv.new Interval(1,3));
		res.add(iv.new Interval(2,6));
		res.add(iv.new Interval(8,10));
		res.add(iv.new Interval(15,18));
		
		List<Interval> list = iv.intervals(res);
		for(Interval i : list)
			System.out.println(i);
		
		
	}
}
