import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

//�ݹ鴦��Ŀ¼�·����������ļ� -s
public class processWC {
	
	
	public  void AllCount(String directory, String[] pmts) throws IOException {
		
		try{
			
		
		List<File> fileList=new ArrayList<File>();
		File file=new File(directory);
		File[] files=file.listFiles(); //��ȡĿ¼�������ļ����ļ���
		String rex="^[\\S]*\\.cpp$"; //������ʽ�жϺ�׺��Ϊ.cpp���ļ�
		if(file==null) return;
		//����Ŀ¼�������ļ�
		for(File f:files) {
			if(f.isFile()&&f.getName().matches(rex)) {
				fileList.add(f); //�����ļ��ҷ����������ļ�����ӵ�fileList��
			} else if(f.isDirectory()) {
				//�����ļ��У��ݹ���ļ����ڵ��ļ�
				AllCount(f.getAbsolutePath(),pmts);
			}
		}
		//�������з����������ļ�
		for(File fl:fileList) {
			for(String pmt:pmts) {
				countWC cwc=new countWC();
				extendWC ewc=new extendWC();
				if(pmt.equals("-s")) {}
				else if(pmt.equals("-a")) {
					//������չͳ�ƹ���
					ewc.ExtendCount(fl.getAbsolutePath());
					System.out.println("�ļ���"+fl.getName());
					System.out.println("��������"+ewc.getBlankLine());
					System.out.println("ע��������"+ewc.getCommentLine());
					System.out.println("����������"+ewc.getCodeLine());
					System.out.println("\n");
				} 
				//���û���ͳ�ƹ���
				else if(pmt.equals("-l")) {
					System.out.println("�ļ���"+fl.getName());
					cwc.BasicCount(fl.getAbsolutePath());
					System.out.println("������"+cwc.getLineNum());
				}
				else if(pmt.equals("-c")) {
					System.out.println("�ļ���"+fl.getName());
					cwc.BasicCount(fl.getAbsolutePath());
					System.out.println("�ַ�����"+cwc.getCharNum());
				}
				else if(pmt.equals("-w")) {
					System.out.println("�ļ���"+fl.getName());
					cwc.BasicCount(fl.getAbsolutePath());
					System.out.println("��������"+cwc.getWordNum());
				}
			}
		}
	  }catch (FileNotFoundException e) {
		  e.printStackTrace();
	  }/*catch (java.lang.StringIndexOutOfBoundsException e) {
		  System.out.println("��֪��Ϊʲô!");
	  }*/
	}

}
