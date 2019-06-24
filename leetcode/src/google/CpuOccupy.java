package google;

public class CpuOccupy {
	public static void main(String[] args) throws InterruptedException {
		long busytime = 10;
		
		while(true){
			long starttime = System.currentTimeMillis();
			while((System.currentTimeMillis() - starttime) <= busytime);
			Thread.sleep(10);
		}
	}
}
