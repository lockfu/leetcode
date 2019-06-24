package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArr {
	 private static int[] ori;
	    private int[] num;
	    private Random rand = new Random();
	    
	    public ShuffleAnArr(int[] nums) {
	        num = nums;
	        ori = nums.clone();
	        
	    }
	    
	    private List<Integer> getArrayCopy(){
	        List<Integer> asList = new ArrayList<>();
	        for(int i = 0; i<num.length; i++){
	            asList.add(num[i]);
	        }
	        return asList;
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        num = ori;
	        ori = ori.clone();
	        return num;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        List<Integer> aux = getArrayCopy();
	        
	        for(int i = 0; i<num.length; i++){
	            int rmindex = rand.nextInt(aux.size());
	            num[i] = aux.get(rmindex);
	            aux.remove(rmindex);
	        }
	        return num;
	    }
}
