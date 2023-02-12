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
		boolean letterYet = false;
		if(arg0.getSource() == button) {
			// char c
			// if(c == str.charAt(i)) {
			
			//}
			String character = JOptionPane.showInputDialog("Enter a letter: ");
			char c = character.charAt(0);
			if(theWord.contains(character) && !guessedChars.contains(character)) {
				int index = theWord.indexOf(character);
				blanks = "";
				for(int i = 0; i < theWord.length(); i++) {
					letterYet = false;
					for(int j = 0; j < guessedChars.size(); j++) {
						if(guessedChars.get(j).charAt(0) == theWord.charAt(i) && !letterYet) {
							//c == theWord.charAt(i)
							blanks+=guessedChars.get(j);
							letterYet = true;
						}
					}
					if(c == theWord.charAt(i)) {
						blanks+=character;
						guessedChars.add(character);
						letterYet = true;
					} 
					if(!letterYet) {
					blanks+="_ ";
					}
				}
				System.out.println("var :" + blanks);
				label.setText(blanks);
			} else {
				System.out.println(theWord);
				livesI--;
				String livesS = Integer.toString(livesI);
				lives.setText(livesS);
				if(guessedChars.contains(character)) {
					JOptionPane.showMessageDialog(null, "That letter has already been guessed");
				}
				if(livesI == 0) {
					String yesorno = JOptionPane.showInputDialog("You ran out of lives. The word was " + theWord + ". Would you like to play again?");
					if(yesorno.equalsIgnoreCase("yes")) {
						resetVariables();
					}
				}
				if(!blanks.contains("_")) {
					String yesorno = JOptionPane.showInputDialog("You guessed the word! Would you like to play again?");
					if(yesorno.equalsIgnoreCase("yes")) {
						resetVariables();
					}
				}
			}
		}
	}
	public void resetVariables() {
		
		blanks = "";
		words = new Stack<String>();
		guessedChars = new ArrayList<String>();
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
		livesI = 6;
		livesS = Integer.toString(livesI);
	}
}
