package pattern;

/**
 * ȷ��һ����ֻ��һ��ʵ������������ʵ������������ϵͳ�ṩ���ʵ��
 * @author DELL
 *
 */
public class SingleTon {
	
}


// ���µ���ģʽ�Ƕ�����ģʽ  �̰߳�ȫ��  ����ʹ��
class Elvis{
	public static final Elvis INSTANCE = new Elvis();
	private Elvis(){}
}

// ���  ���͹���
class Elvis2{
	private static final Elvis2 INSTANCE = new Elvis2();
	private Elvis2(){}
	public static Elvis2 getInstance(){return INSTANCE;}
}
// ʵ�ֵ���ģʽ����ѷ��� 
// �ڹ������빫���򷽷����ƣ������Ӽ�飬�޳��ṩ�����л����ơ�
enum Elvis3{
	INSTANCE;
}

// ����ģʽ
// �����̰߳�ȫ����  
// ��������ò�Ҫʵ��Cloneable�ӿڣ����ƶ���ͨ�����캯������
class Elvis4{
	private static Elvis4 instance = null;
	private Elvis4(){}
	public static Elvis4 getInstance(){
		if(instance == null)
			instance = new Elvis4();
		return instance;
	}
}
// �Ľ���
class Elvis5{
	private static Elvis5 instance = null;
	private Elvis5(){}
	public static synchronized Elvis5 getInstance(){
		if(instance == null)
			instance = new Elvis5();
		return instance;
	}
}
