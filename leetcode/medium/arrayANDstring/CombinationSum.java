package arrayANDstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == candidates || candidates.length <= 0) return res;
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        backtrack(candidates, 0, res, tmp, target);
        return res;
    }
    
	private boolean backtrack(int[] candidates, int start, List<List<Integer>> res, List<Integer> tmp, int target){
		if(target < 0) return false;
		if(target == 0){
			res.add(new ArrayList<>(tmp));
			return false;
		}
		for(int i = start; i<candidates.length; i++){
			boolean flag;
			tmp.add(candidates[i]);
			flag = backtrack(candidates, i, res, tmp, target-candidates[i]);
			tmp.remove(tmp.size()-1);
			if(!flag)
				break;
		}
		return true;
	}
	
    private void helper(int[] candidates, int cur, List<List<Integer>> res, List<Integer> tmp, int target){
        if(cur < 0 || candidates[cur] > target) return;
        if(cur == 0 && target % candidates[cur] != 0) return;
        if(candidates[cur] == target){
            tmp.add(target);
            res.add(tmp);
            return;
        }
        if(target % candidates[cur] == 0){
            List<Integer> curlist = new ArrayList<>(tmp);
            int nn = target / candidates[cur];
            while(nn-- > 0)
                curlist.add(candidates[cur]);
            res.add(curlist);
        }
        int count = 1;
        while(count++ < cur){
        	List<Integer> curlist = new ArrayList<>(tmp);
        	curlist.add(candidates[cur]);
        	helper(candidates, cur-(count+1), res, curlist, target - candidates[cur]);
        }
        if(cur > 1){
        	List<Integer> curlist = new ArrayList<>(tmp);
        	curlist.add(candidates[cur]);
        	helper(candidates, cur-2, res, curlist, target - candidates[cur]);
        }
        int n = target / candidates[cur];
        for(int i = 1; i<=n; i++){
            int j = i;
            List<Integer> curlist = new ArrayList<>(tmp);
            while(j-- > 0){
                curlist.add(candidates[cur]);
            }
            helper(candidates, cur-1, res, curlist, target - i*candidates[cur]);
        }
    }
    
    public static void main(String[] args) {
    	CombinationSum cc = new CombinationSum();
    	int[] candidates = {7,3,2};//{2,3,6,7}; // {2,3,5}; {8,7,4,3};//
    	int target = 18;
    	List<List<Integer>> res = cc.combinationSum(candidates, target);
    	System.out.println(res);
	}
}
