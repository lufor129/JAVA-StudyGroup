package exception;

import java.io.File;
import java.io.IOException;

public class Prevent {
	public static void main(String[] args) {

		File f = new File("OverWatch.txt");

		if (f.exists()) {

		} else {
			try {
				f.createNewFile();
			} catch (IOException e) {
			}
		}
	}

}
