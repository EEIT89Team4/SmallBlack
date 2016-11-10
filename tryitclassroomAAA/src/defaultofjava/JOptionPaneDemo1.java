package defaultofjava;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPaneDemo1 {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		  jf.setSize(300, 200);
		  jf.setTitle("JOptionPaneDemo1.java");
		  jf.setVisible(true);
		  JOptionPane.showMessageDialog(jf, "How are you?");
		                //之前為  jf.contentPane.add(xxxx);  加入元件
		  JOptionPane.showInputDialog(null, "I am fine.");
		                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
