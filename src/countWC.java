import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

//-c.-l,-w类
public class countWC {
	
	private int charNum;
	private int wordNum;
	private int lineNum;
	
	//用于统计，在构造方法中定义初始值为0，以免递归时出错
	public countWC() {
		charNum=0;
		wordNum=0;
		lineNum=0;
	}
	
	public void BasicCount(String filename) {
		//基本统计功能实现
		try {
			File file=new File(filename);
			FileReader reader=new FileReader(file);
			BufferedReader breader=new BufferedReader(reader); //读文件
			Scanner sc=new Scanner(file);
			
			//StringBuilder sb=new StringBuilder();
			//String s_line=breader.readLine();
			while(sc.hasNextLine()) {
				
				String s_line=sc.nextLine();
				charNum+=s_line.length();
				//String s=sc.nextLine().trim();
				//String str[]=s.split("\\s+");
				//wordNum+=str.length;
				//wordNum+=getWord_Line(s_line);
				lineNum++;
			}
			breader.close();
			
			wordNum=getWord_Line(filename);
			
			return;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public int getWord_Line(String s) {
		//该方法统计出一行的单词数
		int j=0;
		
		for(int i=0;i<s.length();i++) {
			s.charAt(i); //取当前位置的字符
			if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')) {
			//单词的范围
				while(i<s.length()&&(s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')) {
					i++;
				}
				j++;
			}
			
		}
		return j;
	}*/
	public int getWord_Line(String filename) {
		int i=0;
		try{
			File file=new File(filename);
			FileReader reader=new FileReader(file);
			BufferedReader breader=new BufferedReader(reader); //读文件
			Scanner sc=new Scanner(file);
			while(sc.hasNextLine()) {
				String s=sc.nextLine().trim();
				String str[]=s.split("\\s");
				i+=str.length;
;			}
			sc.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int getCharNum() {
		return charNum;
	}
	
	public int getWordNum() {
		return wordNum;
	}
	
	public int getLineNum() {
		return lineNum;
	}
		
	

}
