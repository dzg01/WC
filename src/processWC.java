import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

//递归处理目录下符合条件的文件 -s
public class processWC {
	
	
	public  void AllCount(String directory, String[] pmts) throws IOException {
		
		try{
			
		
		List<File> fileList=new ArrayList<File>();
		File file=new File(directory);
		File[] files=file.listFiles(); //获取目录下所有文件，文件夹
		String rex="^[\\S]*\\.cpp$"; //正则表达式判断后缀名为.cpp的文件
		if(file==null) return;
		//遍历目录下所有文件
		for(File f:files) {
			if(f.isFile()&&f.getName().matches(rex)) {
				fileList.add(f); //若是文件且符合条件的文件，添加到fileList中
			} else if(f.isDirectory()) {
				//若是文件夹，递归该文件夹内的文件
				AllCount(f.getAbsolutePath(),pmts);
			}
		}
		//遍历所有符合条件的文件
		for(File fl:fileList) {
			for(String pmt:pmts) {
				countWC cwc=new countWC();
				extendWC ewc=new extendWC();
				if(pmt.equals("-s")) {}
				else if(pmt.equals("-a")) {
					//调用拓展统计功能
					ewc.ExtendCount(fl.getAbsolutePath());
					System.out.println("文件："+fl.getName());
					System.out.println("空行数："+ewc.getBlankLine());
					System.out.println("注释行数："+ewc.getCommentLine());
					System.out.println("代码行数："+ewc.getCodeLine());
					System.out.println("\n");
				} 
				//调用基本统计功能
				else if(pmt.equals("-l")) {
					System.out.println("文件："+fl.getName());
					cwc.BasicCount(fl.getAbsolutePath());
					System.out.println("行数："+cwc.getLineNum());
				}
				else if(pmt.equals("-c")) {
					System.out.println("文件："+fl.getName());
					cwc.BasicCount(fl.getAbsolutePath());
					System.out.println("字符数："+cwc.getCharNum());
				}
				else if(pmt.equals("-w")) {
					System.out.println("文件："+fl.getName());
					cwc.BasicCount(fl.getAbsolutePath());
					System.out.println("单词数："+cwc.getWordNum());
				}
			}
		}
	  }catch (FileNotFoundException e) {
		  e.printStackTrace();
	  }/*catch (java.lang.StringIndexOutOfBoundsException e) {
		  System.out.println("不知道为什么!");
	  }*/
	}

}
