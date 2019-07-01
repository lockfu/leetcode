package chap05;

public class GetTranslation {
	public static int sum = 0;
	private static char[] aa = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 
		'h', 'i', 'j', 'k', 'l', 'm','n', 
		'o','p','q', 'r', 's', 't',
		'u', 'v', 'w', 'x', 'y', 'z'};
	public static void tran(int num){
		if(num < 0) return ;
		if(num < 10) return ;
		dfs((""+num).toCharArray(), 0, "", "");
		System.out.println(sum);
	}
	public static void dfs(char[] cs, int step, String cur, String str){
		if(cur.length() == cs.length){
			System.out.println(str);
			sum++;
			return;
		}
		for(int i = 1; i<=2; i++){
			if(i == 1 || step == cs.length-1){
				if(step >= cs.length)
					continue;
				char c = cs[step];
				cur += c;
				str += aa[c-'0'];
				dfs(cs, step+1, cur, str);
			}else{
				if(step >= cs.length-1)
					continue;
				char c1 = cs[step];
				char c2 = cs[step+1];
				int cnum = (c1-'0')*10 + (c2-'0');
				if(cnum <= 25){
					cur += (c1+""+c2);
					str += aa[cnum];
					dfs(cs, step+2, cur, str);
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		int num = 12258;
		tran(num);
	}
}
