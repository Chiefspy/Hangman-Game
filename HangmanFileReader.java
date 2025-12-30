import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HangmanFileReader {

	public static String[] words(){
		// TODO Auto-generated method stub
		ArrayList<String> words = new ArrayList<String>();
		FileReader reader;
		try {
			reader = new FileReader("C:\\Users\\santi\\eclipse-workspace\\MyFirstProgram\\src\\words.txt");
			String word = "";
			int data = reader.read();
			char ch;
			while (data != -1) {
				ch = (char) data;
				if (ch == ',' || ch == ' ' || ch == '\n') { // if the read character is before a comma then add the past string to arrayList
					words.add(word.toLowerCase());
					word = "";
				}else {
					word += ch;
				}
				data = reader.read();
			}
			if (word.length() >0) {
				words.add(word);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return words.toArray(new String[words.size()]);
		
		

	}

}
