import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheFruitGame {
    private static String[] fruits = {"apple", "banana", "cherry", "grape", "orange", "pear", "peach", "melon", "mango", "kiwi"};
    private static String selectedFruit;
    private static char[] guessedWord;

    public GuessTheFruitGame() {
        
        Random random = new Random();
        selectedFruit = fruits[random.nextInt(fruits.length)];
        guessedWord = new char[selectedFruit.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

       
        JFrame frame = new JFrame("Guess the Fruit");
        frame.setSize(400, 300);
        frame.setLayout(null); 
        frame.setLocation(370,180);
        frame.getContentPane().setBackground(Color.WHITE);

        
        JLabel wordLabel = new JLabel(String.valueOf(guessedWord), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 24));
        wordLabel.setBounds(50, 30, 300, 50); 
        frame.add(wordLabel);

        
        JTextField inputField = new JTextField();
        inputField.setBounds(50, 100, 200, 30); 
        frame.add(inputField);

        
        JLabel messageLabel = new JLabel("Enter a letter and press Guess", SwingConstants.CENTER);
        messageLabel.setBounds(50, 150, 300, 30); 
        frame.add(messageLabel);

        
        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(270, 100, 100, 30); 
        guessButton.setBackground(Color.pink);
        frame.add(guessButton);

       
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().toLowerCase();
                inputField.setText("");

                if (input.length() != 1) {
                    messageLabel.setText("Please enter one letter only.");
                    return;
                }

                char guessedLetter = input.charAt(0);
                boolean correct = false;

                for (int i = 0; i < selectedFruit.length(); i++) {
                    if (selectedFruit.charAt(i) == guessedLetter) {
                        guessedWord[i] = guessedLetter;
                        correct = true;
                    }
                }

                if (correct) {
                    messageLabel.setText("Correct!");
                } else {
                    messageLabel.setText("Wrong! Try again.");
                }

                wordLabel.setText(String.valueOf(guessedWord));

                if (String.valueOf(guessedWord).equals(selectedFruit)) {
                    messageLabel.setText("Congratulations! You guessed the word.");
                    inputField.setEnabled(false);
                    guessButton.setEnabled(false);
                }
            }
        });

        
        frame.setVisible(true);
    }
}
