package chap06;

public class GetSum {
	// ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
	public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
