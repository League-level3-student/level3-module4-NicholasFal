package _03_Hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel lives = new JLabel();
	int livesI = 6;
	String livesS = Integer.toString(livesI);
	String blanks = "";
	JButton button = new JButton();
	static Stack<String> words = new Stack<String>();
	String theWord = "";
	ArrayList<String> guessedChars = new ArrayList<String>();
	public void setup() {
		frame.add(panel);
		panel.add(label);
		panel.add(lives);
		panel.add(button);
		lives.setText(livesS);
		button.setText("Guess");
		
		
		
		
		button.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String stackNum = JOptionPane.showInputDialog("Choose a number from 1 to 266.");
		int stackNumI = Integer.parseInt(stackNum);
		for(int i = stackNumI; i > 0; i--) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			words.push(word);
			}
		theWord = words.pop();
		
		for(int i = 0; i < theWord.length(); i++) {
			blanks += "_ ";
		}
		label.setText(blanks);


		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == button) {
			String character = JOptionPane.showInputDialog("Enter a letter: ");
			if(theWord.contains(character)) {
				int index = theWord.indexOf(character);
				guessedChars.add(character);
				blanks = "";
				for(int i = 0; i < theWord.length(); i++) {
					for(int j = 0; j < guessedChars.size(); j++) {
						if(theWord.indexOf(guessedChars.get(j)) == i) {
							blanks+=guessedChars.get(j);
						}
					}
					if(index == i) {
						blanks+=character;
					} else {
					blanks+="_ ";
					}
				}
				System.out.println("var :" + blanks);
				label.setText(blanks);
			} else {
				System.out.println(theWord);
			}
		}
	}
}
