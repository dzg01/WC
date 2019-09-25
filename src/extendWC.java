import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//-a功能类
public class extendWC {
	
	private  int blankLine;
	private  int codeLine;
	private  int commentLine;
	
	//用于统计，在构造方法中定义初始值为0，以免递归时出错
	public extendWC() {
		blankLine=0;
		codeLine=0;
		commentLine=0;
	}
	
	public void ExtendCount(String filename) {
		boolean flag=false;  //标记注释行
		try {
			File file=new File(filename);
			FileReader reader=new FileReader(file);
			BufferedReader breader=new BufferedReader(reader);
			String str="";
			while((str=breader.readLine())!=null) {
				//str=str.replace("\\s", "");
				str=str.trim();
				//正则表达式匹配单字符行”{“ ”}“ ”;“
				if(str.matches("^[\\s&&[^\\n]]*$")||str.equals("{")||str.equals("}")||str.equals(";")) {
					blankLine++;
					if(flag==true) {
						commentLine++;
					}
				} else if(str.startsWith("/*")&&!str.endsWith("*/")) {
					//多行注释行/* */
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
