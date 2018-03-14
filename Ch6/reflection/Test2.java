package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.Hero;

public class Test2 {
	public static void main(String[] args) {
		
//		傳統
		Hero h1=new Hero("Ana");
		System.out.println(h1);
		
//		使用反射方式建立對象
		try {
			String classname="reflection.Hero";
//			類對象
			Class Class1=Class.forName(classname);
//			使用構造器
			Constructor c=Class1.getConstructor();
//			用構造器實例化
			Hero h2=(Hero)c.newInstance();
			System.out.println(h2);
		}catch(Exception e) {
			
		}
		
		try {
//			用反射訪問屬性
//			獲取HERO的名字叫做name的字段
			Field f1=h1.getClass().getDeclaredField("name");
//			修改這個字段
			f1.set(h1, "BRIGITTE");
//			修改後直
			System.out.println(h1);
			
		}catch(Exception e) {
			
		}
		
//		getField和getDeclaredField的區別
//		這兩個方法都是用於獲取欄位
//		getField 只能獲取public的，包括從父類繼承來的欄位。
//		getDeclaredField 可以獲取"本類"所有的欄位，包括private的，但是不能獲取繼承來的欄位。 
//		(注： 這裡只能獲取到private的欄位，但並不能訪問該private欄位的值,除非加上setAccessible(true))
		
		try {
//			獲取名子為setName的方法，傳遞參數為String
			Method m1=h1.getClass().getMethod("setName", String.class);
//			對h對象，調用這個方法
			m1.invoke(h1, "JumpRat");
			System.out.println(h1);
		}catch(Exception e) {
			
		}
		
	}

}
