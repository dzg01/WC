import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//-a������
public class extendWC {
	
	private  int blankLine;
	private  int codeLine;
	private  int commentLine;
	
	//����ͳ�ƣ��ڹ��췽���ж����ʼֵΪ0������ݹ�ʱ����
	public extendWC() {
		blankLine=0;
		codeLine=0;
		commentLine=0;
	}
	
	public void ExtendCount(String filename) {
		boolean flag=false;  //���ע����
		try {
			File file=new File(filename);
			FileReader reader=new FileReader(file);
			BufferedReader breader=new BufferedReader(reader);
			String str="";
			while((str=breader.readLine())!=null) {
				//str=str.replace("\\s", "");
				str=str.trim();
				//������ʽƥ�䵥�ַ��С�{�� ��}�� ��;��
				if(str.matches("^[\\s&&[^\\n]]*$")||str.equals("{")||str.equals("}")||str.equals(";")) {
					blankLine++;
					if(flag==true) {
						commentLine++;
					}
				} else if(str.startsWith("/*")&&!str.endsWith("*/")) {
					//����ע����/* */
					commentLine++;
					flag=true;
				} else if(flag==true) {
					commentLine++;
					if(str.endsWith("*/")) {
						flag=false;
					}
				} else if(str.startsWith("//")||(str.startsWith("/*")&&str.endsWith("*/"))) {
					commentLine++;
				} else {
					codeLine++;
				}
			}
			breader.close();
			
			
		} catch(IOException ex) {
			ex.printStackTrace();
		} 
	}
	
	public int getBlankLine() {
		return blankLine;
	}
	
	public int getCommentLine() {
		return commentLine;
	}
	
	public int getCodeLine() {
		return codeLine;
	}

}
