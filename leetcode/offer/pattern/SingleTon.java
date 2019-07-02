package pattern;

/**
 * 确保一个类只有一个实例，而且自行实例化并向整个系统提供这个实例
 * @author DELL
 *
 */
public class SingleTon {
	
}


// 以下单列模式是饿汉子模式  线程安全的  建议使用
class Elvis{
	public static final Elvis INSTANCE = new Elvis();
	private Elvis(){}
}

// 灵活  泛型工厂
class Elvis2{
	private static final Elvis2 INSTANCE = new Elvis2();
	private Elvis2(){}
	public static Elvis2 getInstance(){return INSTANCE;}
}
// 实现单列模式的最佳方法 
// 在功能上与公有域方法相似，但更加简介，无偿提供了序列化机制。
enum Elvis3{
	INSTANCE;
}

// 懒汉模式
// 会有线程安全问题  
// 单列类最好不要实现Cloneable接口，复制对象不通过构造函数进行
class Elvis4{
	private static Elvis4 instance = null;
	private Elvis4(){}
	public static Elvis4 getInstance(){
		if(instance == null)
			instance = new Elvis4();
		return instance;
	}
}
// 改进：
class Elvis5{
	private static Elvis5 instance = null;
	private Elvis5(){}
	public static synchronized Elvis5 getInstance(){
		if(instance == null)
			instance = new Elvis5();
		return instance;
	}
}

//改进：
class Elvis6{
	private static Elvis6 instance = null;
	private Elvis6(){}
	public static Elvis6 getInstance(){
		if(instance == null){
			synchronized (Elvis6.class) {
				if(instance == null)
					instance = new Elvis6();
			}
		}
		return instance;
	}
}

//改进：
class Elvis7{
	private static volatile Elvis7 instance = null;
	private Elvis7(){}
	public static Elvis7 getInstance(){
		if(instance == null){
			synchronized (Elvis7.class) {
				if(instance == null)
					instance = new Elvis7();
			}
		}
		return instance;
	}
}

//改进：
class Elvis8{
	
	private Elvis8(){}
	private static class InstanceHolder{
		public static Elvis8 instance = new Elvis8();
	}
	public static Elvis8 getInstance(){
		return InstanceHolder.instance;
	}
}



