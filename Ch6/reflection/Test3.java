package reflection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Test3 {
	public static void main(String[] args) throws InterruptedException{
		// 基於文件配置的編程
		Hero h=getHero();
		h.name="REINHARDT";
		System.out.println(h);
	}
	
	public static Hero getHero() {
		File f=new File("hero.config");
		
		try(FileReader fr=new FileReader(f)){
			String Classname=null;
			char[] all=new char[(int)f.length()];
			fr.read(all);
			Classname=new String(all);
			Class clazz=Class.forName(Classname);
			Constructor c=clazz.getConstructor();
			Hero h=(Hero)c.newInstance();
			return h;
		}catch(Exception e) {
			return null;
		}
		
	}
}
