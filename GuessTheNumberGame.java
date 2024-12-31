
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GuessTheNumberGame {

     static int targetNumber; 
     static int triesLeft;
    static int points = 0; 
      
    public GuessTheNumberGame(){
        JFrame frame = new JFrame("Guess The Number");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setLocation(450,180);
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel iconLabel = new JLabel();
        iconLabel.setBounds(100, 70, 200, 150);
        frame.add(iconLabel);


        try {
            BufferedImage img = ImageIO.read(new File("guss.jpg")); 
            Image scaledImg = img.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            iconLabel.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Image not found!");
        }

        JLabel modeLabel = new JLabel("Choose mode");
        modeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        modeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modeLabel.setBounds(80, 240, 300, 30);
        frame.add(modeLabel);

        JButton easyButton = new JButton("Easy");
        easyButton.setBackground(Color.GREEN);
        easyButton.setBounds(50, 290, 100, 40);
        frame.add(easyButton);

        JButton mediumButton = new JButton("Medium");
        mediumButton.setBackground(Color.YELLOW);
        mediumButton.setBounds(180, 290, 100, 40);
        frame.add(mediumButton);

        JButton hardButton = new JButton("Hard");
        hardButton.setBackground(Color.RED);
        hardButton.setBounds(310, 290, 100, 40);
        frame.add(hardButton);

       
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGuessTheNumberWindow("Easy", 1, 10, 3);
            }
        });

        
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGuessTheNumberWindow("Medium", 1, 50, 5);
            }
        });

       
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGuessTheNumberWindow("Hard", 1, 100, 7);
            }
        });

        frame.setVisible(true);

    }
   

    public static void showGuessTheNumberWindow(String mode, int min, int max, int initialTries) {
        JFrame guessFrame = new JFrame("Guess The Number - " + mode + " Mode");
        guessFrame.setSize(500, 500);
        guessFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        guessFrame.setLayout(null);
        guessFrame.getContentPane().setBackground(Color.WHITE);

        Random random = new Random();
        targetNumber = random.nextInt(max - min + 1) + min; 
        triesLeft = initialTries; 

        JLabel title = new JLabel("Guess the Number?");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(120, 20, 300, 30);
        title.setForeground(Color.RED);
        guessFrame.add(title);

        JLabel subtitle = new JLabel("Enter a number between " + min + " and " + max);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setBounds(140, 60, 300, 30);
        guessFrame.add(subtitle);

        JTextField guessField = new JTextField();
        guessField.setBounds(170, 100, 150, 30);
        guessFrame.add(guessField);

        JLabel tryLabel = new JLabel("Try and guess it!");
        tryLabel.setBounds(190, 140, 200, 30);
        guessFrame.add(tryLabel);

        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(190, 180, 100, 30);
        guessFrame.add(guessButton);
        
        JLabel iconLabel = new JLabel();
        iconLabel.setBounds(140, 230, 200, 150);
        guessFrame.add(iconLabel);

        try {
            BufferedImage img = ImageIO.read(new File("easy.jpg")); 
            Image scaledImg = img.getScaledInstance(200, 150, Image.SCALE_SMOOTH); 
            iconLabel.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(guessFrame, "Image not found!");
        }

        JLabel yourTryLabel = new JLabel("Your Tries:");
        yourTryLabel.setBounds(50, 380, 100, 30);
        guessFrame.add(yourTryLabel);

        JTextField triesField = new JTextField(String.valueOf(triesLeft));
        triesField.setBounds(120, 380, 50, 30);
        triesField.setEditable(false);
        guessFrame.add(triesField);

        JLabel yourPointsLabel = new JLabel("Your Points:");
        yourPointsLabel.setBounds(200, 380, 100, 30);
        guessFrame.add(yourPointsLabel);

        JTextField pointsField = new JTextField(String.valueOf(points));
        pointsField.setBounds(300, 380, 50, 30);
        pointsField.setEditable(false);
        guessFrame.add(pointsField);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(guessField.getText());

                    if (userGuess == targetNumber) {
                        
                        JOptionPane.showMessageDialog(guessFrame, "Correct! You guessed the number.🎉🎉🎊");
                        points += 10;
                        pointsField.setText(String.valueOf(points));
                       
                        targetNumber = random.nextInt(max - min + 1) + min;
                        triesLeft = initialTries;
                        triesField.setText(String.valueOf(triesLeft));
                    } else {
                        
                        triesLeft--;
                        triesField.setText(String.valueOf(triesLeft));
                        
                        if (triesLeft > 0) {
                            
                            if(userGuess>targetNumber){
                                JOptionPane.showMessageDialog(guessFrame, "Wrong guess! Try again.😞😞, the number is greater");
                            }
                            else if(userGuess<targetNumber){
                                JOptionPane.showMessageDialog(guessFrame, "Wrong guess! Try again.😞😞, the number is lesser");
                            }
                        } else {
                            JOptionPane.showMessageDialog(guessFrame, "Game Over! You ran out of tries.");
                            points = 0; 
                            pointsField.setText(String.valueOf(points));
                            triesLeft = initialTries; 
                            triesField.setText(String.valueOf(triesLeft));
                            targetNumber = random.nextInt(max - min + 1) + min;
                        }
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(guessFrame, "Please enter a valid number!");
                }
            }
        });

        guessFrame.setVisible(true);
    }

    
}
