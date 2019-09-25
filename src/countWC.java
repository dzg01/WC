import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

//-c.-l,-w��
public class countWC {
	
	private int charNum;
	private int wordNum;
	private int lineNum;
	
	//����ͳ�ƣ��ڹ��췽���ж����ʼֵΪ0������ݹ�ʱ����
	public countWC() {
		charNum=0;
		wordNum=0;
		lineNum=0;
	}
	
	public void BasicCount(String filename) {
		//����ͳ�ƹ���ʵ��
		try {
			File file=new File(filename);
			FileReader reader=new FileReader(file);
			BufferedReader breader=new BufferedReader(reader); //���ļ�
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
		//�÷���ͳ�Ƴ�һ�еĵ�����
		int j=0;
		
		for(int i=0;i<s.length();i++) {
			s.charAt(i); //ȡ��ǰλ�õ��ַ�
			if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')) {
			//���ʵķ�Χ
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
			BufferedReader breader=new BufferedReader(reader); //���ļ�
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
