package knife.ch02;

public class Singleton {
	/**
	 * 饿汉模式
	 */
//	private static Singleton instance = new Singleton();
//	private Singleton(){}
//	public static Singleton getInstance(){
//		return instance;
//	}
	
	/**
	 * 懒汉模式
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
	 * 静态 final公有域
	 */
//	public static final Singleton INSTANCE = new Singleton();
//	private Singleton(){};
	
	/**
	 * 静态的工厂方法
	 */
//	private static final Singleton INSTANCE = new Singleton();
//	private Singleton(){};
//	public static Singleton getInstance(){return INSTANCE;}
	
	
}

/**
 * 枚举类型的单列模式
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







