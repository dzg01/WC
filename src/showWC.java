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
	public JFileChooser filechooser = new JFileChooser(); //文件选择
	
	
	public showWC() {
		
		super("WordCount");   //标题
		setContentPane(contentPanel);
		setBounds(100, 100, 558, 439); 
		getContentPane().setLayout(null);   //绝对布局
		setLocationRelativeTo(null);   //居中
		setResizable(false);   //不可调整大小
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(31, 50, 292, 329);
		getContentPane().add(textArea);
		//JScrollPane scrollPane = new JScrollPane(textPane);
		
		JButton button = new JButton("\u9009\u62E9\u6587\u4EF6");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
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
							textArea.setFont(new Font("宋体", Font.BOLD, 18));
							textArea.append("文件："+f.getName()+"\n");
							textArea.append("字符数："+wc1.getCharNum()+"\n");
							textArea.append("单词数："+wc1.getWordNum()+"\n");
							textArea.append("行数："+wc1.getLineNum()+"\n");
							textArea.append("空行："+ewc1.getBlankLine()+"\n");
							textArea.append("注释行"+ewc1.getCommentLine()+"\n");
							textArea.append("代码行"+ewc1.getCodeLine()+"\n");
							//breader.close();
							
							
							

						} catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					
					
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u7EDF\u8BA1\u7ED3\u679C");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 19, 72, 32);
		getContentPane().add(lblNewLabel);
		
	}
	
	   //显示窗口,用于测试
    //主程序线程启动时需要添加注释
	/*public static void main(String[] args) {
		//try {
			showWC mainShow = new showWC();
			mainShow.setVisible(true);
		//} catch(Exception e) {
			//e.printStackTrace();
		//}
	}*/
	
}
