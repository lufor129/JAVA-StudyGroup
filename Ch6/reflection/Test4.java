package reflection;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {
	public static void main(String[] args) {
		File f = new File("hero.config");

		try (FileReader fr = new FileReader(f)) {
			String content = null;
			char[] all = new char[(int) f.length()];
			fr.read(all);
			content = new String(all);
			String[] cs = content.split("\r\n");
			String hero1classname = cs[0];
			String hero1Name = cs[1];
			String hero2classname = cs[2];
			String hero2Name = cs[3];

			// 用反射獲取hero1，並給hero1的name字段復職
			Class hero1Class = Class.forName(hero1classname);
			Constructor hero1C = hero1Class.getConstructor();
			Object hero1 = hero1C.newInstance();
			Field hero1NameField = hero1Class.getField("name");
			hero1NameField.set(hero1, hero1Name);

			// 用反射獲取hero1，並給hero1的name字段賦值
			Class hero2Class = Class.forName(hero2classname);
			Constructor hero2C = hero2Class.getConstructor();
			Object hero2 = hero2C.newInstance();
			Field hero2NameField = hero2Class.getField("name");
			hero2NameField.set(hero2, hero2Name);

			// 根據反射獲取attack方法，並調用hero1參數為hero2
			Method attackM=hero1Class.getMethod("attackHero", Hero.class);
			attackM.invoke(hero1, hero2);
		} catch (Exception e) {

		}
	}

}
