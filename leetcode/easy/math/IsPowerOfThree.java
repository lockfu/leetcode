package math;

public class IsPowerOfThree {
	public boolean isPowerOfThree(int n) {
		if(n == 1 || n == 3)
            return true;
        else if(n%3!=0 || n == 0)
            return false;
        else
            return isPowerOfThree(n/3);
	}
}
