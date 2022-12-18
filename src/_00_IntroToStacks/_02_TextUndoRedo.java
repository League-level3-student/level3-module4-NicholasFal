package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String text = "";
	String text2;
	Stack<Character> deletedKeys = new Stack<Character>();
	public void run() {
	frame.add(panel);
	panel.add(label);
	frame.setVisible(true);
	label.setText(text);
	frame.addKeyListener(this);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			//System.out.println(KeyEvent.VK_de);
			if(arg0.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
				text2 = text.substring(0, text.length() - 1);
				deletedKeys.push(text.charAt(text.length() - 1));
				text = text2;
				label.setText(text);
			} else if(arg0.getKeyChar() == KeyEvent.VK_MINUS) {
				Character popped = deletedKeys.pop();
				text += popped;
				label.setText(text);
			} else {
			text += arg0.getKeyChar();
			label.setText(text);
	}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
