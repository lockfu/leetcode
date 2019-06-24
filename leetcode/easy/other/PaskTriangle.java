package other;

import java.util.ArrayList;
import java.util.List;

public class PaskTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if(numRows <= 0)
			return res;
		for(int i = 1; i<=numRows; i++){
			List<Integer> tmp = new ArrayList<>();
			tmp.add(1);
			if(i == 1){
				res.add(tmp);
				continue;
			}else if(i != 2){
				List<Integer> pre = res.get(i-2);
				for(int j = 0; j<pre.size()-1; j++){
					tmp.add(pre.get(j)+pre.get(j+1));
				}
			}
			tmp.add(1);
			res.add(tmp);
		}
		return res;
	}
	
}
