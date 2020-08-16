import java.io.File;
import java.io.IOException;

public class MainAddress {

	public static void main(String[] args) {
		File file = new File("filestorage.ser");
		if(!file.exists()) {
			try {
				boolean newfile = file.createNewFile();
				//System.out.println(newfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(file.exists());
		
	}

}
