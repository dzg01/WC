import java.io.File;
import java.io.IOException;

//���������ã����������и���
public class workWC {
	
	public static void main(String[] args) throws IOException {
		//for(String pmt : args) {
			
		    
		    for(String pmt:args) {
		    	
		    	countWC cWC=new countWC();
			   // extendWC eWC=new extendWC();
		    	
		    
			if(pmt.equals("-x")) {
				//ͼ�ν���
				showWC wc=new showWC();
				wc.setVisible(true);
				
			} else if(pmt.equals("-s")) {
				//����processWC�࣬ʵ�ֵݹ�ͳ��
				System.out.println(args[args.length-1]);
				processWC pwc=new processWC();
				pwc.AllCount(args[args.length-1], args);
				break;
				
			} else {
				
				cWC.BasicCount(args[args.length-1]);  //ѡȡ�ļ�
				//����countWC�࣬ʵ�ֻ�����ͳ�ƹ���
				if(pmt.equals("-c")) {
					System.out.println("�ļ���"+args[args.length-1]);
					System.out.println("�ַ�����"+cWC.getCharNum());
				}
				if(pmt.equals("-w")) {
					System.out.println("�ļ���"+args[args.length-1]);
					System.out.println("��������"+cWC.getWordNum());
				}
				if(pmt.equals("-l")) {
					System.out.println("�ļ���"+args[args.length-1]);
					System.out.println("������"+cWC.getLineNum());
				}
				//����extendWC�࣬ʵ����չ����
				if(pmt.equals("-a")) {
					extendWC eWC=new extendWC();
					eWC.ExtendCount(args[args.length-1]);
					System.out.println("�ļ���"+args[args.length-1]);
					System.out.println("��������"+eWC.getBlankLine());
					System.out.println("ע��������"+eWC.getCommentLine());
					System.out.println("����������"+eWC.getCodeLine());
				}
			}
			
			
		}
		
	}

}
