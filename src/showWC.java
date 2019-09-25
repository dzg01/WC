import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;




public class showWC extends JFrame {

	private final JPanel contentPanel = new JPanel();
	public JFileChooser filechooser = new JFileChooser(); //�ļ�ѡ��
	
	
	public showWC() {
		
		super("WordCount");   //����
		setContentPane(contentPanel);
		setBounds(100, 100, 558, 439); 
		getContentPane().setLayout(null);   //���Բ���
		setLocationRelativeTo(null);   //����
		setResizable(false);   //���ɵ�����С
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(31, 50, 292, 329);
		getContentPane().add(textArea);
		//JScrollPane scrollPane = new JScrollPane(textPane);
		
		JButton button = new JButton("\u9009\u62E9\u6587\u4EF6");
		button.setFont(new Font("����", Font.PLAIN, 20));
		button.setBounds(362, 209, 119, 54);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  int i=filechooser.showOpenDialog(textArea);
					if(i==JFileChooser.APPROVE_OPTION) {
						File f=filechooser.getSelectedFile();
						//filename=filechooser.getSelectedFile();
						try {
							//FileReader reader=new FileReader(f);
							//BufferedReader breader=new BufferedReader(reader);
							countWC wc1=new countWC();
							extendWC ewc1=new extendWC();
							wc1.BasicCount(f.getAbsolutePath());
							ewc1.ExtendCount(f.getAbsolutePath());
							textArea.setFont(new Font("����", Font.BOLD, 18));
							textArea.append("�ļ���"+f.getName()+"\n");
							textArea.append("�ַ�����"+wc1.getCharNum()+"\n");
							textArea.append("��������"+wc1.getWordNum()+"\n");
							textArea.append("������"+wc1.getLineNum()+"\n");
							textArea.append("���У�"+ewc1.getBlankLine()+"\n");
							textArea.append("ע����"+ewc1.getCommentLine()+"\n");
							textArea.append("������"+ewc1.getCodeLine()+"\n");
							//breader.close();
							
							
							

						} catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					
					
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u7EDF\u8BA1\u7ED3\u679C");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 19, 72, 32);
		getContentPane().add(lblNewLabel);
		
	}
	
	   //��ʾ����,���ڲ���
    //�������߳�����ʱ��Ҫ���ע��
	/*public static void main(String[] args) {
		//try {
			showWC mainShow = new showWC();
			mainShow.setVisible(true);
		//} catch(Exception e) {
			//e.printStackTrace();
		//}
	}*/
	
}
