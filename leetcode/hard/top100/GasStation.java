package top100;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i<gas.length; i++){
            if(gas[i] >= cost[i]){
            	if(helper(i, gas, cost))
            		return i;
            }
        }
        return -1;
    }
	public boolean helper(int i, int[] gas, int[] cost){
		int curtank = gas[i];
		int cp = (i == 0) ? gas.length-1 : i-1;
		int nxt = i;
		while(nxt != cp){
			if(curtank >= cost[nxt]){
				curtank -= cost[nxt];
				if(nxt == gas.length-1)
					nxt = 0;
				else
					nxt++;
				curtank += gas[nxt];
			}else{
				return false;
			}
		}
		if(nxt == cp && curtank >= cost[nxt]){
			return true;
		}
		return false;
	}
	
	public int canCompleteCircuit_2(int[] gas, int[] cost) {
		int curtank = 0, sum = 0, start = 0;
		for(int i = 0; i<gas.length; i++){
			curtank += gas[i] - cost[i];
			sum += gas[i] - cost[i];
			if(sum < 0){
				start = i+1;
				sum = 0;
			}
		}
		return curtank < 0 ? -1 : start;
	}
	
	public static void main(String[] args) {
		int[] gas  = {2,3,4};
		int[] cost = {3,4,3};
		int res = new GasStation().canCompleteCircuit(gas, cost);
		System.out.println(res);
	}
}
