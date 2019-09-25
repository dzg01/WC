import java.io.File;
import java.io.IOException;

//主方法调用，命令行运行该类
public class workWC {
	
	public static void main(String[] args) throws IOException {
		//for(String pmt : args) {
			
		    
		    for(String pmt:args) {
		    	
		    	countWC cWC=new countWC();
			   // extendWC eWC=new extendWC();
		    	
		    
			if(pmt.equals("-x")) {
				//图形界面
				showWC wc=new showWC();
				wc.setVisible(true);
				
			} else if(pmt.equals("-s")) {
				//调用processWC类，实现递归统计
				System.out.println(args[args.length-1]);
				processWC pwc=new processWC();
				pwc.AllCount(args[args.length-1], args);
				break;
				
			} else {
				
				cWC.BasicCount(args[args.length-1]);  //选取文件
				//调用countWC类，实现基本的统计功能
				if(pmt.equals("-c")) {
					System.out.println("文件："+args[args.length-1]);
					System.out.println("字符数："+cWC.getCharNum());
				}
				if(pmt.equals("-w")) {
					System.out.println("文件："+args[args.length-1]);
					System.out.println("单词数："+cWC.getWordNum());
				}
				if(pmt.equals("-l")) {
					System.out.println("文件："+args[args.length-1]);
					System.out.println("行数："+cWC.getLineNum());
				}
				//调用extendWC类，实现扩展功能
				if(pmt.equals("-a")) {
					extendWC eWC=new extendWC();
					eWC.ExtendCount(args[args.length-1]);
					System.out.println("文件："+args[args.length-1]);
					System.out.println("空行数："+eWC.getBlankLine());
					System.out.println("注释行数："+eWC.getCommentLine());
					System.out.println("代码行数："+eWC.getCodeLine());
				}
			}
			
			
		}
		
	}

}
