import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Driver {
	//private static final vars for colors :)
	private static final Color BACKGROUND_COLOR = new Color(247,247,242);
	private static final Color BUTTON_SHADOW = new Color(7, 59, 76);
	private static final Color BUTTON_HIGHLIGHT = new Color(17, 138, 178);
	
	
	public static void main(String args[] ) {		
		//--the actual frame--
		JFrame f = new JFrame("Cats Button");
		//setting the background of just the frame sets it behind all content
		//must set background of where content is to show it
    	f.getContentPane().setBackground(BACKGROUND_COLOR);
		
		//--label for instructions--
		JLabel instructions = new JLabel("Enter a number & push the button to see a cat!");
		instructions.setBounds(50, 10, 300, 30);
		
		//--text field to enter a number--
		JTextField enterNum = new JTextField();
		enterNum.setText("2");
		enterNum.setBounds(175, 50, 50, 30);
		
		//--button to show cats--
		JButton showCatButton = new JButton("Click this for cat!");
		showCatButton.setBounds(100, 100, 200, 30);
		showCatButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, BUTTON_SHADOW, BUTTON_HIGHLIGHT));
		//button must be opaque to have a background color
		showCatButton.setOpaque(true);
		showCatButton.setBackground(BUTTON_SHADOW);
		//setForeground changes text color
		showCatButton.setForeground(BACKGROUND_COLOR);

		//--button as an icon for cat1--
		JButton cat1Button = new JButton(new ImageIcon("cat1.jpeg"));
		cat1Button.setBounds(150, 150, 100, 100);
		cat1Button.setVisible(false);
		
		//--button as an icon for cat2--
		JButton cat2Button = new JButton(new ImageIcon("cat2.jpeg"));
		cat2Button.setBounds(150, 150, 100, 100);
		cat2Button.setVisible(false);
		
		//--button action--
		showCatButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String numString = enterNum.getText();
				int num = Integer.parseInt(numString);
				
				if(!(num % 2 == 0)) {
					//show cat1
					cat2Button.setVisible(false);
					cat1Button.setVisible(true);
				} else {
					//show cat2
					cat1Button.setVisible(false);
					cat2Button.setVisible(true);
				}
			}
			
		});;
		
		//--adding everything to JFrame--
		f.add(cat1Button);
		f.add(cat2Button);
		f.add(instructions);
		f.add(enterNum);
		f.add(showCatButton);
		
		//--set size--
		f.setSize(400,300);		
		//--set layout to null to do it myself--
		f.setLayout(null);
		//--make it visible--
		f.setVisible(true);
		//--make it terminate when closing the window--
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
