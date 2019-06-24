package knife.ch02;

public class Singleton {
	/**
	 * ����ģʽ
	 */
//	private static Singleton instance = new Singleton();
//	private Singleton(){}
//	public static Singleton getInstance(){
//		return instance;
//	}
	
	/**
	 * ����ģʽ
	 */
//	private static Singleton instance;
//	private Singleton(){}
//	public static Singleton getInstance(){
//		if(instance == null)
//			instance = new Singleton();
//		return instance;
//	}
//	public static synchronized Singleton getInstance(){
//		if(instance == null)
//			instance = new Singleton();
//		return instance;
//	}
//	public static  Singleton getInstance(){
//		if(instance == null){
//			synchronized (Singleton.class) {
//				if(instance == null)
//					instance = new Singleton();
//			}
//		}
//		return instance;
//	}
	
	/**
	 * ��̬ final������
	 */
//	public static final Singleton INSTANCE = new Singleton();
//	private Singleton(){};
	
	/**
	 * ��̬�Ĺ�������
	 */
//	private static final Singleton INSTANCE = new Singleton();
//	private Singleton(){};
//	public static Singleton getInstance(){return INSTANCE;}
	
	
}

/**
 * ö�����͵ĵ���ģʽ
 * @author DELL
 *
 */
enum SingleDemo{
	INSTANCE;
}






//class T1{
//	private T1(){}
//}
//
//class T2 extends T1{
//	public T2(){}
//}







